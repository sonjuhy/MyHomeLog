package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogDefaultEntity;
import com.myhome.log.db.repository.LogDefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogDefaultServiceImpl implements LogDefaultService{

    @Autowired
    LogDefaultRepository repository;

    @Override
    public LogDefaultEntity insert(LogDefaultDto dto) {
        return repository.insert(dto.dtoToEntity());
    }

    @Override
    public LogDefaultEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogDefaultEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogDefaultEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogDefaultEntity> findByDayAndType(String day, boolean type) {
        return repository.findByDayAndType(day, type);
    }

    @Override
    public List<LogDefaultEntity> findByDayStartToEnd(String startDay, String endDay) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogDefaultEntity> resultList = new ArrayList<>();

        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+startCal.get(Calendar.MONTH)+"-"+startCal.get(Calendar.DATE);
                System.out.println(dateStr);
                resultList.addAll(repository.findByDay(dateStr));
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogDefaultEntity> resultList = new ArrayList<>();

        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);
            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+startCal.get(Calendar.MONTH)+"-"+startCal.get(Calendar.DATE);
                resultList.addAll(repository.findByDayAndType(dateStr, type));
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDay(String sender, String day) {
        return repository.findBySenderAndDay(sender, day);
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.findBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public List<LogDefaultEntity> findByService(String service) {
        return repository.findByService(service);
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDay(String service, String day) {
        return repository.findByServiceAndDay(service, day);
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayAndType(String service, String day, boolean type) {
        return repository.findByServiceAndDayAndType(service, day, type);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByDay(String day) {
        repository.deleteByDay(day);
    }

    @Override
    public void deleteBySender(String sender) {
        repository.deleteBySender(sender);
    }

    @Override
    public void deleteByService(String service) {
        repository.deleteByService(service);
    }
}
