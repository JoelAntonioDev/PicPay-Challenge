package com.project.picpayexec.services;

import com.project.picpayexec.domain.enums.UserType;
import com.project.picpayexec.domain.model.User;
import com.project.picpayexec.dtos.UserDTO;
import com.project.picpayexec.infra.exceptions.EntidadeNaoEncontradaException;
import com.project.picpayexec.infra.exceptions.InsuficienteAmountException;
import com.project.picpayexec.infra.exceptions.UsuarioLojistaException;
import com.project.picpayexec.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void validateTransatcion(User sender, BigDecimal amount)
            throws InsuficienteAmountException, UsuarioLojistaException {

        if(sender.getUserType() == UserType.LOJISTA){
            throw new UsuarioLojistaException(
                    "Usuário do tipo Lojista não tem autorização para realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new InsuficienteAmountException("Saldo insuficiente");
        }
    }

    public User findUserById(Long id)throws EntidadeNaoEncontradaException {
        User user = userRepository.findById(id).orElseThrow(()->
                new EntidadeNaoEncontradaException("Usuário não encontrado"));
        return user;
    }

    public User adicionar(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
    public List<User> listar(){
        return userRepository.findAll();
    }

}
