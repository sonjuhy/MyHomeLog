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

    /**
     * find : all, type, day, limit(page)
     * count : all, type, day
     *
     * session : default, sender, service
     * */

    // default
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
        return new ResponseEntity<>(logDefaultService.findByDayBetween(startDay,endDay), HttpStatus.OK);
    }

    @GetMapping("/countByStartToEnd/{startDay}/{endDay}")
    public ResponseEntity<Long> countByStartToEnd(@PathVariable String startDay, @PathVariable String endDay){
        return new ResponseEntity<>(logDefaultService.countByStartToEnd(startDay, endDay), HttpStatus.OK);
    }

    @GetMapping("/findByStartToEnd/{startDay}/{endDay}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByDayStartToEnd(@PathVariable String startDay, @PathVariable String endDay, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.findByTypeBetween(type, startDay, endDay), HttpStatus.OK);
    }

    @GetMapping("/countByStartToEnd/{startDay}/{endDay}/{type}")
    public ResponseEntity<Long> countByStartToEnd(@PathVariable String startDay, @PathVariable String endDay, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countByStartToEndAndType(startDay, endDay, type), HttpStatus.OK);
    }

    // sender
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

    // service
    @GetMapping("/findByService/{service}")
    public ResponseEntity<List<LogDefaultEntity>> findByService(@PathVariable String service){
        List<LogDefaultEntity> list = logDefaultService.findByService(service);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServicePage/{service}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServicePage(@PathVariable String service, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceLimit(service, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServicePageReverse/{service}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServicePageReverse(@PathVariable String service, @PathVariable int page, @PathVariable int pageSize) {
        List<LogDefaultEntity> list = logDefaultService.findByServiceLimitReverse(service, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByService/{service}")
    public ResponseEntity<Long> countByService(@PathVariable String service){
        return new ResponseEntity<>(logDefaultService.countByService(service), HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndType/{service}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndType(@PathVariable String service, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndType(service, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndTypeReverse/{service}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndTypeReverse(@PathVariable String service, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeReverse(service, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndTypePage/{service}/{type}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndTypePage(@PathVariable String service, @PathVariable boolean type, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeLimit(service, type, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndTypePageReverse/{service}/{type}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndTypePageReverse(@PathVariable String service, @PathVariable boolean type, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeLimitReverse(service, type, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByServiceAndType/{service}/{type}")
    public ResponseEntity<Long> countByServiceAndType(@PathVariable String service, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countByServiceAndType(service, type), HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDay/{service}/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDay(@PathVariable String service, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDay(service, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDayReverse/{service}/{day}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDayReverse(@PathVariable String service, @PathVariable String day){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayReverse(service, day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDayPage/{service}/{day}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDayPage(@PathVariable String service, @PathVariable String day, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayLimit(service, day, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndDayPageReverse/{service}/{day}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDayPageReverse(@PathVariable String service, @PathVariable String day, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayLimitReverse(service, day, page, pageSize);
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

    @GetMapping("/findByServiceAndDayAndTypePage/{service}/{day}/{type}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndDayAndTypePage(@PathVariable String service, @PathVariable String day, @PathVariable boolean type, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndDayAndTypeLimit(service, day, type, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByServiceAndDayAndType/{service}/{day}/{type}")
    public ResponseEntity<Long> countByServiceAndDayAndType(@PathVariable String service, @PathVariable String day, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countByServiceAndDayAndType(service, day, type), HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayAndType/{service}/{start}/{end}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDay(@PathVariable String service, @PathVariable String start, @PathVariable String end){
        List<LogDefaultEntity> list = logDefaultService.findByServiceBetween(service, start, end);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayAndType/{service}/{start}/{end}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayAndType(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeBetween(service, type, start, end);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayPage/{service}/{start}/{end}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayPage(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceBetweenLimit(service, start, end, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayAndTypePage/{service}/{start}/{end}/{type}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayAndTypePage(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable boolean type, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeBetweenLimit(service, type, start, end, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayReverse/{service}/{start}/{end}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayReverse(@PathVariable String service, @PathVariable String start, @PathVariable String end){
        List<LogDefaultEntity> list = logDefaultService.findByServiceBetweenReverse(service, start, end);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayPageReverse/{service}/{start}/{end}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayPageReverse(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceBetweenLimitReverse(service, start, end, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayAndTypeReverse/{service}/{start}/{end}/{type}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayAndTypeReverse(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable boolean type){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeBetweenReverse(service, type, start, end);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findByServiceAndStartToEndDayAndTypePageReverse/{service}/{start}/{end}/{type}/{page}/{pageSize}")
    public ResponseEntity<List<LogDefaultEntity>> findByServiceAndStartToEndDayAndTypePageReverse(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable boolean type, @PathVariable int page, @PathVariable int pageSize){
        List<LogDefaultEntity> list = logDefaultService.findByServiceAndTypeBetweenLimitReverse(service, type, start, end, page, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/countByServiceAndStartToEndDayAndTypeReverse/{service}/{start}/{end}/{type}")
    public ResponseEntity<Long> countByServiceAndStartToEndDayAndType(@PathVariable String service, @PathVariable String start, @PathVariable String end, @PathVariable boolean type){
        return new ResponseEntity<>(logDefaultService.countByServiceAndStartToEndDayAndType(service, start, end, type), HttpStatus.OK);
    }
}
