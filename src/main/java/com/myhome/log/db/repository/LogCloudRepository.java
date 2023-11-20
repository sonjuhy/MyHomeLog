package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogCloudEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogCloudRepository extends MongoRepository<LogCloudEntity, Long> {
    LogCloudEntity findById(long id);
    List<LogCloudEntity> findByType(boolean type);
    List<LogCloudEntity> findByDay(String day);
    List<LogCloudEntity> findByDayAndType(String day, boolean type);
    List<LogCloudEntity> findBySender(String sender);
    List<LogCloudEntity> findBySenderAndDay(String sender, String day);
    List<LogCloudEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    List<LogCloudEntity> findByService(String service);
    List<LogCloudEntity> findByServiceAndDay(String service, String day);
    List<LogCloudEntity> findByServiceAndDayAndType(String service, String day, boolean type);
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
