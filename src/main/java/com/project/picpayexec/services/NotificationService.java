package com.project.picpayexec.services;

import com.project.picpayexec.domain.model.User;
import com.project.picpayexec.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity(
                "https://util.devi.tools/api/v1/notify", notificationRequest, String.class);
        System.out.println("Notification response:"+notificationResponse.getBody());
        System.out.println("Notification response:"+notificationResponse.getStatusCode());
        if(notificationResponse.getStatusCode() != HttpStatus.NO_CONTENT) {
            throw new Exception("Serviço de notificação fora do ar");
        }
    }

}
