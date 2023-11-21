package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogWeatherEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogWeatherRepository extends MongoRepository<LogWeatherEntity, Long> {
    LogWeatherEntity findById(long id);
    List<LogWeatherEntity> findByType(boolean type);
    List<LogWeatherEntity> findByDay(String day);
    List<LogWeatherEntity> findByDayAndType(String day, boolean type);
    List<LogWeatherEntity> findBySender(String sender);
    List<LogWeatherEntity> findBySenderAndDay(String sender, String day);
    List<LogWeatherEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
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
