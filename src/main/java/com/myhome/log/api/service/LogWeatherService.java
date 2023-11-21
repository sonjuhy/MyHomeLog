package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogWeatherEntity;

import java.util.List;

public interface LogWeatherService {
    LogWeatherEntity insert(LogDefaultDto dto);
    List<LogWeatherEntity> findAll();
    LogWeatherEntity findById(long id);
    List<LogWeatherEntity> findByType(boolean type);
    List<LogWeatherEntity> findByDay(String day);
    List<LogWeatherEntity> findByDayAndType(String day, boolean type);
    List<LogWeatherEntity> findByDayStartToEnd(String startDay, String endDay);
    List<LogWeatherEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type);
    List<LogWeatherEntity> findBySender(String sender);
    List<LogWeatherEntity> findBySenderAndDay(String sender, String day);
    List<LogWeatherEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    long count();
    long countByType(boolean type);
    long countByDay(String day);
    long countByDayAndType(String day, boolean type);
    long countBySender(String sender);
    long countBySenderAndDay(String sender, String day);
    long countBySenderAndDayAndType(String sender, String day, boolean type);
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
