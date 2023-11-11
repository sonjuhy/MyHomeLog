package com.myhome.log.api.controller;

import com.myhome.log.api.service.LogDefaultService;
import com.myhome.log.db.entity.LogDefaultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class LogController {

    @Autowired
    LogDefaultService logDefaultService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<LogDefaultEntity> findById(@PathVariable long id){
        LogDefaultEntity entity = logDefaultService.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/findByType/{bool}")
    public ResponseEntity<List<LogDefaultEntity>> findByType(@PathVariable boolean bool){
        List<LogDefaultEntity> list = logDefaultService.findByType(bool);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByTypeCount")
    public ResponseEntity<int[]> findByTypeCount(){
        int trueCount = logDefaultService.findByType(true).size();
        int falseCount = logDefaultService.findByType(false).size();
        int[] result = {trueCount, falseCount};
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByDay/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByDay(@PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByDay(day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByDay/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayAndType(@PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByDayAndType(day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByDayCount/{day}")
    public ResponseEntity<Integer> findByDayCount(@PathVariable String day){
        int listSize = logDefaultService.findByDay(day).size();
        return new ResponseEntity<>(listSize, HttpStatus.OK);
    }

    @GetMapping("/findByDayStartToEnd/{startDay}/{endDay}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayStartToEnd(@PathVariable String startDay, @PathVariable String endDay){
        return new ResponseEntity<>(logDefaultService.findByDayStartToEnd(startDay,endDay), HttpStatus.OK);
    }

    @GetMapping("/findByDayStartToEnd/{startDay}/{endDay}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayStartToEnd(@PathVariable String startDay, @PathVariable String endDay, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.findByDayStartToEndAndType(startDay, endDay, type), HttpStatus.OK);
    }

    @GetMapping("/findBySender/{sender}")
    public ResponseEntity<List<LogDefaultEntity>> findBySender(@PathVariable String sender){
        List<LogDefaultEntity> list = logDefaultService.findBySender(sender);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findBySender/{sender}/{Day}")
    public ResponseEntity<List<LogDefaultEntity>> findBySenderAndDay(@PathVariable String sender, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findBySenderAndDay(sender, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findBySender/{sender}/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findBySenderAndDayAndType(@PathVariable String sender, @PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findBySenderAndDayAndType(sender, day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByService/{service}")
    public ResponseEntity<List<LogDefaultEntity>> findByService(@PathVariable String service){
        List<LogDefaultEntity> list = logDefaultService.findByService(service);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByService/{service}/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByService(@PathVariable String service, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDay(service, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByService/{service}/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByService(@PathVariable String service, @PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayAndType(service, day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
