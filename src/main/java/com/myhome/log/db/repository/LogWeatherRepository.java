package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogWeatherEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.text.ParseException;
import java.util.List;

public interface LogWeatherRepository extends MongoRepository<LogWeatherEntity, Long> {
    // Order
    // default (type, day, sender)
    LogWeatherEntity findById(long id);
    List<LogWeatherEntity> findByType(boolean type);
    List<LogWeatherEntity> findByDay(String day);
    List<LogWeatherEntity> findByDayAndType(String day, boolean type);
    List<LogWeatherEntity> findBySender(String sender);
    List<LogWeatherEntity> findBySenderAndType(String sender, boolean type);
    List<LogWeatherEntity> findBySenderAndDay(String sender, String day);
    List<LogWeatherEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    // between (type, sender)
    List<LogWeatherEntity> findByDayBetween(String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException;

    // limit (before methods)
    List<LogWeatherEntity> findAllBy(Pageable pageable);
    List<LogWeatherEntity> findAllByDay(String day, Pageable pageable);
    List<LogWeatherEntity> findAllByType(boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllByDayAndType(String day, boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllBySender(String sender, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Reverse (all Order methods)
    // default (type, day, sender)
    List<LogWeatherEntity> findByOrderByUnixTimeDesc();
    List<LogWeatherEntity> findByTypeOrderByUnixTimeDesc(boolean type);
    List<LogWeatherEntity> findByDayOrderByUnixTimeDesc(String day);
    List<LogWeatherEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type);
    List<LogWeatherEntity> findBySenderOrderByUnixTimeDesc(String sender);
    List<LogWeatherEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type);
    List<LogWeatherEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day);
    List<LogWeatherEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type);
    // between (type, sender)
    List<LogWeatherEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    List<LogWeatherEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    // limit (before methods)
    List<LogWeatherEntity> findAllByOrderByUnixTimeDesc(Pageable pageable);
    List<LogWeatherEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable);
    List<LogWeatherEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable);
    List<LogWeatherEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable);
    List<LogWeatherEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogWeatherEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Count
    long countByType(boolean type);
    long countByDay(String day);
    long countByDayAndType(String day, boolean type);
    long countBySender(String sender);
    long countBySenderAndDay(String sender, String day);
    long countBySenderAndDayAndType(String sender, String day, boolean type);
    // between
    long countByDayBetween(String startDate, String endDate);
    long countByTypeAndDayBetween(boolean type, String startDate, String endDate);
    long countBySenderAndDayBetween(String sender, String startDate, String endDate);
    long countBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate);

    // Delete
    void deleteById(long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
