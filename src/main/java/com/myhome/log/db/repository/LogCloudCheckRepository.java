package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogCloudCheckEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogCloudCheckRepository extends MongoRepository<LogCloudCheckEntity, Long> {
    LogCloudCheckEntity findById(long id);
    List<LogCloudCheckEntity> findByType(boolean type);
    List<LogCloudCheckEntity> findByDay(String day);
    List<LogCloudCheckEntity> findByDayAndType(String day, boolean type);
    List<LogCloudCheckEntity> findBySender(String sender);
    List<LogCloudCheckEntity> findBySenderAndDay(String sender, String day);
    List<LogCloudCheckEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
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
