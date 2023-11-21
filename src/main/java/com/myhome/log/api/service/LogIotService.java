package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogIotEntity;

import java.util.List;

public interface LogIotService {
    LogIotEntity insert(LogDefaultDto dto);
    LogIotEntity findById(long id);
    List<LogIotEntity> findAll();
    List<LogIotEntity> findByType(boolean type);
    List<LogIotEntity> findByDay(String day);
    List<LogIotEntity> findByDayAndType(String day, boolean type);
    List<LogIotEntity> findByDayStartToEnd(String startDay, String endDay);
    List<LogIotEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type);
    List<LogIotEntity> findBySender(String sender);
    List<LogIotEntity> findBySenderAndDay(String sender, String day);
    List<LogIotEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
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