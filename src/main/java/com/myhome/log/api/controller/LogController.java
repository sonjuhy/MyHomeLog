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

    @GetMapping("/findById/{service}/{id}")
    public ResponseEntity<LogDefaultEntity> findById(@PathVariable String service, @PathVariable long id){
        LogDefaultEntity entity = logDefaultService.findById(service, id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/findByType/{bool}")
    public ResponseEntity<List<LogDefaultEntity>> findByType(@PathVariable boolean bool){
        List<LogDefaultEntity> list = logDefaultService.findByType(bool);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByType")
    public ResponseEntity<long[]> findByTypeCount(){
        long trueCount = logDefaultService.countByType(true);
        long falseCount = logDefaultService.countByType(false);
        long[] result = {trueCount, falseCount};
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByDay/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByDay(@PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByDay(day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByDay/{day}")
    public ResponseEntity<Long> countByDay(@PathVariable String day){
        long count = logDefaultService.countByDay(day);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/findByDayAndType/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayAndType(@PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByDayAndType(day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByDayAndType/{day}")
    public ResponseEntity<long[]> countByDayAndType(@PathVariable String day){
        long[] result = new long[2];
        result[0] = logDefaultService.countByDayAndType(day, true);
        result[1] = logDefaultService.countByDayAndType(day, false);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByStartToEnd/{startDay}/{endDay}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayStartToEnd(@PathVariable String startDay, @PathVariable String endDay){
        return new ResponseEntity<>(logDefaultService.findByDayStartToEnd(startDay,endDay), HttpStatus.OK);
    }

    @GetMapping("/countByStartToEnd/{startDay}/{endDay}")
    public ResponseEntity<Long> countByStartToEnd(@PathVariable String startDay, @PathVariable String endDay){
        return new ResponseEntity<>(logDefaultService.countByStartToEnd(startDay, endDay), HttpStatus.OK);
    }

    @GetMapping("/findByStartToEnd/{startDay}/{endDay}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayStartToEnd(@PathVariable String startDay, @PathVariable String endDay, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.findByDayStartToEndAndType(startDay, endDay, type), HttpStatus.OK);
    }

    @GetMapping("/countByStartToEnd/{startDay}/{endDay}/{type}")
    public ResponseEntity<Long> countByStartToEnd(@PathVariable String startDay, @PathVariable String endDay, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countByStartToEndAndType(startDay, endDay, type), HttpStatus.OK);
    }
    @GetMapping("/findBySender/{sender}")
    public ResponseEntity<List<LogDefaultEntity>> findBySender(@PathVariable String sender){
        List<LogDefaultEntity> list = logDefaultService.findBySender(sender);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countBySender/{sender}")
    public ResponseEntity<Long> countBySender(@PathVariable String sender){
        return new ResponseEntity<>(logDefaultService.countBySender(sender), HttpStatus.OK);
    }

    @GetMapping("/findBySenderAndDay/{sender}/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findBySenderAndDay(@PathVariable String sender, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findBySenderAndDay(sender, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countBySenderAndDay/{sender}/{day}")
    public ResponseEntity<Long> countBySenderAndDay(@PathVariable String sender, @PathVariable String day){
        return new ResponseEntity<>(logDefaultService.countBySenderAndDay(sender, day), HttpStatus.OK);
    }

    @GetMapping("/findBySenderAndDayAndType/{sender}/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findBySenderAndDayAndType(@PathVariable String sender, @PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findBySenderAndDayAndType(sender, day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countBySenderAndDayAndType/{sender}/{day}/{type}")
    public ResponseEntity<Long> countBySenderAndDayAndType(@PathVariable String sender, @PathVariable String day, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countBySenderAndDayAndType(sender, day, type), HttpStatus.OK);
    }

    @GetMapping("/findByService/{service}")
    public ResponseEntity<List<LogDefaultEntity>> findByService(@PathVariable String service){
        List<LogDefaultEntity> list = logDefaultService.findByService(service);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByService/{service}")
    public ResponseEntity<Long> countByService(@PathVariable String service){
        return new ResponseEntity<>(logDefaultService.countByService(service), HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDay/{service}/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDay(@PathVariable String service, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDay(service, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByServiceAndDay/{service}/{day}")
    public ResponseEntity<Long> countByServiceAndDay(@PathVariable String service, @PathVariable String day){
        return new ResponseEntity<>(logDefaultService.countByServiceAndDay(service, day), HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDayAndType/{service}/{day}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDayAndType(@PathVariable String service, @PathVariable String day, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayAndType(service, day, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/countByServiceAndDayAndType/{service}/{day}/{type}")
    public ResponseEntity<Long> countByServiceAndDayAndType(@PathVariable String service, @PathVariable String day, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countBySenderAndDayAndType(service, day, type), HttpStatus.OK);
    }
}
