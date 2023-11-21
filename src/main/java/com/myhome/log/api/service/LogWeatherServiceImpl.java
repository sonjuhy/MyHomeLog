package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogIotEntity;
import com.myhome.log.db.entity.LogReserveEntity;
import com.myhome.log.db.entity.LogWeatherEntity;
import com.myhome.log.db.repository.LogIotRepository;
import com.myhome.log.db.repository.LogReserveRepository;
import com.myhome.log.db.repository.LogWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogWeatherServiceImpl implements LogWeatherService{

    @Autowired
    LogWeatherRepository repository;

    @Override
    public LogWeatherEntity insert(LogDefaultDto dto) {
        return repository.insert(dtoToEntity(dto));
    }

    @Override
    public List<LogWeatherEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LogWeatherEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogWeatherEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogWeatherEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogWeatherEntity> findByDayAndType(String day, boolean type) {
        return repository.findByDayAndType(day, type);
    }

    @Override
    public List<LogWeatherEntity> findByDayStartToEnd(String startDay, String endDay) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogWeatherEntity> resultList = new ArrayList<>();

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
    public List<LogWeatherEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogWeatherEntity> resultList = new ArrayList<>();

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
    public List<LogWeatherEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDay(String sender, String day) {
        return repository.findBySenderAndDay(sender, day);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.findBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public long countByType(boolean type) {
        return repository.countByType(type);
    }

    @Override
    public long countByDay(String day) {
        return repository.countByDay(day);
    }

    @Override
    public long countByDayAndType(String day, boolean type) {
        return repository.countByDayAndType(day, type);
    }

    @Override
    public long countBySender(String sender) {
        return repository.countBySender(sender);
    }

    @Override
    public long countBySenderAndDay(String sender, String day) {
        return repository.countBySenderAndDay(sender, day);
    }

    @Override
    public long countBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.countBySenderAndDayAndType(sender, day, type);
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

    private LogWeatherEntity dtoToEntity(LogDefaultDto dto){
        LogWeatherEntity entity = new LogWeatherEntity(
                dto.getId(),
                dto.getUnixTime(),
                dto.isType(),
                dto.getSender(),
                dto.getService(),
                dto.getDay(),
                dto.getTime(),
                dto.getContent());
        return entity;
    }
}
