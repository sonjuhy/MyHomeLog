package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogDefaultEntity;

import java.util.List;

public interface LogDefaultService {
    LogDefaultEntity insert(LogDefaultDto dto);
    LogDefaultEntity findById(long id);
    List<LogDefaultEntity> findByType(boolean type);
    List<LogDefaultEntity> findByDay(String day);
    List<LogDefaultEntity> findByDayAndType(String day, boolean type);
    List<LogDefaultEntity> findByDayStartToEnd(String startDay, String endDay);
    List<LogDefaultEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type);
    List<LogDefaultEntity> findBySender(String sender);
    List<LogDefaultEntity> findBySenderAndDay(String sender, String day);
    List<LogDefaultEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    List<LogDefaultEntity> findByService(String service);
    List<LogDefaultEntity> findByServiceAndDay(String service, String day);
    List<LogDefaultEntity> findByServiceAndDayAndType(String service, String day, boolean type);
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
