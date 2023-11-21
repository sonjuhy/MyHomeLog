package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogReserveEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogReserveRepository extends MongoRepository<LogReserveEntity, Long> {
    LogReserveEntity findById(long id);
    List<LogReserveEntity> findByType(boolean type);
    List<LogReserveEntity> findByDay(String day);
    List<LogReserveEntity> findByDayAndType(String day, boolean type);
    List<LogReserveEntity> findBySender(String sender);
    List<LogReserveEntity> findBySenderAndDay(String sender, String day);
    List<LogReserveEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
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
