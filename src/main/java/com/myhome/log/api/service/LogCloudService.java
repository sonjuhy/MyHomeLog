package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogCloudEntity;

import java.util.List;

public interface LogCloudService {
    LogCloudEntity insert(LogDefaultDto dto);
    LogCloudEntity findById(long id);
    List<LogCloudEntity> findAll();
    List<LogCloudEntity> findByType(boolean type);
    List<LogCloudEntity> findByDay(String day);
    List<LogCloudEntity> findByDayAndType(String day, boolean type);
    List<LogCloudEntity> findByDayStartToEnd(String startDay, String endDay);
    List<LogCloudEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type);
    List<LogCloudEntity> findBySender(String sender);
    List<LogCloudEntity> findBySenderAndDay(String sender, String day);
    List<LogCloudEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
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
