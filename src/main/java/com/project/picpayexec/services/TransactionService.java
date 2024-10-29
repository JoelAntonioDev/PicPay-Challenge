package com.project.picpayexec.services;

import com.project.picpayexec.domain.model.Transaction;
import com.project.picpayexec.domain.model.User;
import com.project.picpayexec.dtos.TransactionDTO;
import com.project.picpayexec.infra.exceptions.TransacaoNaoAutorizadaException;
import com.project.picpayexec.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception {
        User sender = this.userService.findUserById(transactionDTO.senderId());
        User receiver = this.userService.findUserById(transactionDTO.receiverId());

        userService.validateTransatcion(sender, transactionDTO.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transactionDTO.value());
        if(!isAuthorized){
            throw new TransacaoNaoAutorizadaException("Transação não autorizada");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.value());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionDTO.value()));
        receiver.setBalance(receiver.getBalance().add(transactionDTO.value()));

        this.transactionRepository.save(transaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

        //this.notificationService.sendNotification(sender,
        //       "Transação realizada com sucesso");
        //this.notificationService.sendNotification(receiver,
        //       "Transação realizada com sucesso");

        return transaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal value)throws Exception{
        try {
            ResponseEntity<Map> authorizationResponse = restTemplate.
                    getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
            if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
                Map<String, Boolean> data = (Map<String, Boolean>)
                        authorizationResponse.getBody().get("data");
                boolean isAuthorized = data.get("authorization");
                System.out.println(isAuthorized);
                return isAuthorized;
            } else return false;
        }catch (HttpClientErrorException e){
            throw new Exception("403 Forbidden");
        }
    }
}
