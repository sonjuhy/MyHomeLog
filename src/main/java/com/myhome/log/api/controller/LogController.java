package com.myhome.log.api.controller;

import com.myhome.log.api.dto.LogReceiveDto;
import com.myhome.log.api.service.KafkaProducerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class LogController {

    @Autowired
    KafkaProducerImpl producer;

    @GetMapping("/test")
    public void test(){
        producer.sendMessage("test message");
    }

    @GetMapping("/dtoTest")
    public void testDto(){
        LogReceiveDto dto = new LogReceiveDto(0,true,"spring","cloud","content");
        producer.sendDtoMessage(dto);
    }

}
