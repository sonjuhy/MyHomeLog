package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogIotEntity;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface LogIotService {
    LogIotEntity insert(LogDefaultDto dto);
    List<LogIotEntity> findAll();
    // Order
    // default (type, day, sender)
    LogIotEntity findById(long id);
    List<LogIotEntity> findByType(boolean type);
    List<LogIotEntity> findByDay(String day);
    List<LogIotEntity> findByDayAndType(String day, boolean type);
    List<LogIotEntity> findBySender(String sender);
    List<LogIotEntity> findBySenderAndType(String sender, boolean type);
    List<LogIotEntity> findBySenderAndDay(String sender, String day);
    List<LogIotEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    // between (type, sender)
    List<LogIotEntity> findByDayBetween(String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException;

    // limit (before methods)
    List<LogIotEntity> findAllBy(Pageable pageable);
    List<LogIotEntity> findAllByDay(String day, Pageable pageable);
    List<LogIotEntity> findAllByType(boolean type, Pageable pageable);
    List<LogIotEntity> findAllByDayAndType(String day, boolean type, Pageable pageable);
    List<LogIotEntity> findAllBySender(String sender, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable);
    List<LogIotEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Reverse (all Order methods)
    // default (type, day, sender)
    List<LogIotEntity> findByOrderByUnixTimeDesc();
    List<LogIotEntity> findByTypeOrderByUnixTimeDesc(boolean type);
    List<LogIotEntity> findByDayOrderByUnixTimeDesc(String day);
    List<LogIotEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type);
    List<LogIotEntity> findBySenderOrderByUnixTimeDesc(String sender);
    List<LogIotEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type);
    List<LogIotEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day);
    List<LogIotEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type);
    // between (type, sender)
    List<LogIotEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    List<LogIotEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    // limit (before methods)
    List<LogIotEntity> findAllByOrderByUnixTimeDesc(Pageable pageable);
    List<LogIotEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable);
    List<LogIotEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable);
    List<LogIotEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable);
    List<LogIotEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable);
    List<LogIotEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable);
    List<LogIotEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogIotEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Count
    long count();
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
