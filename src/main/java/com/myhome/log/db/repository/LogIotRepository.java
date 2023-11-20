package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogIotEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogIotRepository extends MongoRepository<LogIotEntity, Long> {
    LogIotEntity findById(long id);
    List<LogIotEntity> findByType(boolean type);
    List<LogIotEntity> findByDay(String day);
    List<LogIotEntity> findByDayAndType(String day, boolean type);
    List<LogIotEntity> findBySender(String sender);
    List<LogIotEntity> findBySenderAndDay(String sender, String day);
    List<LogIotEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    List<LogIotEntity> findByService(String service);
    List<LogIotEntity> findByServiceAndDay(String service, String day);
    List<LogIotEntity> findByServiceAndDayAndType(String service, String day, boolean type);
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
