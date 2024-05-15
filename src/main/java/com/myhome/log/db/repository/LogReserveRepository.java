package com.myhome.log.db.repository;

import com.myhome.log.db.entity.LogReserveEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.text.ParseException;
import java.util.List;

public interface LogReserveRepository extends MongoRepository<LogReserveEntity, Long> {
    // Order
    // default (type, day, sender)
    LogReserveEntity findById(long id);
    List<LogReserveEntity> findByType(boolean type);
    List<LogReserveEntity> findByDay(String day);
    List<LogReserveEntity> findByDayAndType(String day, boolean type);
    List<LogReserveEntity> findBySender(String sender);
    List<LogReserveEntity> findBySenderAndType(String sender, boolean type);
    List<LogReserveEntity> findBySenderAndDay(String sender, String day);
    List<LogReserveEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    // between (type, sender)
    List<LogReserveEntity> findByDayBetween(String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException;

    // limit (before methods)
    List<LogReserveEntity> findAllBy(Pageable pageable);
    List<LogReserveEntity> findAllByDay(String day, Pageable pageable);
    List<LogReserveEntity> findAllByType(boolean type, Pageable pageable);
    List<LogReserveEntity> findAllByDayAndType(String day, boolean type, Pageable pageable);
    List<LogReserveEntity> findAllBySender(String sender, Pageable pageable);
    List<LogReserveEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable);
    List<LogReserveEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable);
    List<LogReserveEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Reverse (all Order methods)
    // default (type, day, sender)
    List<LogReserveEntity> findByOrderByUnixTimeDesc();
    List<LogReserveEntity> findByTypeOrderByUnixTimeDesc(boolean type);
    List<LogReserveEntity> findByDayOrderByUnixTimeDesc(String day);
    List<LogReserveEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type);
    List<LogReserveEntity> findBySenderOrderByUnixTimeDesc(String sender);
    List<LogReserveEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type);
    List<LogReserveEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day);
    List<LogReserveEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type);
    // between (type, sender)
    List<LogReserveEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    List<LogReserveEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    // limit (before methods)
    List<LogReserveEntity> findAllByOrderByUnixTimeDesc(Pageable pageable);
    List<LogReserveEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable);
    List<LogReserveEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable);
    List<LogReserveEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable);
    List<LogReserveEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable);
    List<LogReserveEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable);
    List<LogReserveEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable);
    List<LogReserveEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable);
    List<LogReserveEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogReserveEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

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
