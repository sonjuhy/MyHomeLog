package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogDefaultEntity;

import java.util.List;

public interface LogDefaultService {
    LogDefaultEntity insert(LogDefaultDto dto);
    LogDefaultEntity findById(long id);
    List<LogDefaultEntity> findByType(boolean type);
    List<LogDefaultEntity> findByDay(String day);
    List<LogDefaultEntity> findBySender(String sender);
    List<LogDefaultEntity> findByService(String service);
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
