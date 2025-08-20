package com.user.service;

import com.user.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = AppConstant.LOCATION_TOPIC, groupId = AppConstant.GROUP_ID)
    public void updatedLocation(String value) {
        System.out.println("Received location update: " + value);
    }
}
