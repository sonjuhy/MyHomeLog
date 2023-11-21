package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogDefaultEntity;

import java.util.List;

public interface LogDefaultService {
    LogDefaultEntity findById(String category, long id);
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
    long countByType(boolean type);
    long countByDay(String day);
    long countByDayAndType(String day, boolean type);
    long countByStartToEnd(String startDay, String endDay);
    long countByStartToEndAndType(String startDay, String endDay, boolean type);
    long countBySender(String sender);
    long countBySenderAndDay(String sender, String day);
    long countBySenderAndDayAndType(String sender, String day, boolean type);
    long countByService(String service);
    long countByServiceAndDay(String service, String day);
    long countByServiceAndDayAndType(String service, String day, boolean type);
    void deleteById(String category, long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
