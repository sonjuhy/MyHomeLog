package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogReceiveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImpl {

    private static final String TOPIC_TEST = "exam-topic";


    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, LogReceiveDto> kafkaTemplateDto;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, LogReceiveDto> kafkaTemplateDto) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplateDto = kafkaTemplateDto;
    }


    public void sendMessage(String message){
        System.out.println("Produce message : "+message);
        this.kafkaTemplate.send(TOPIC_TEST, message);
    }

    public void sendDtoMessage(LogReceiveDto dto){
        System.out.println("sendDtoMessage : " + dto);
        this.kafkaTemplateDto.send(TOPIC_TEST, dto);
    }
}
