package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogCloudEntity;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface LogCloudService {
    // Insert
    LogCloudEntity insert(LogDefaultDto dto);

    // Select
    // default (type, day, sender)
    LogCloudEntity findById(long id);
    List<LogCloudEntity> findAll();
    List<LogCloudEntity> findByType(boolean type);
    List<LogCloudEntity> findByDay(String day);
    List<LogCloudEntity> findByDayAndType(String day, boolean type);
    List<LogCloudEntity> findBySender(String sender);
    List<LogCloudEntity> findBySenderAndType(String sender, boolean type);
    List<LogCloudEntity> findBySenderAndDay(String sender, String day);
    List<LogCloudEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    // between (type, sender)
    List<LogCloudEntity> findByDayBetween(String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException;

    // limit (before methods)
    List<LogCloudEntity> findAllBy(Pageable pageable);
    List<LogCloudEntity> findAllByDay(String day, Pageable pageable);
    List<LogCloudEntity> findAllByType(boolean type, Pageable pageable);
    List<LogCloudEntity> findAllByDayAndType(String day, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllBySender(String sender, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Reverse (all Order methods)
    // default (type, day, sender)
    List<LogCloudEntity> findByOrderByUnixTimeDesc();
    List<LogCloudEntity> findByTypeOrderByUnixTimeDesc(boolean type);
    List<LogCloudEntity> findByDayOrderByUnixTimeDesc(String day);
    List<LogCloudEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type);
    List<LogCloudEntity> findBySenderOrderByUnixTimeDesc(String sender);
    List<LogCloudEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type);
    List<LogCloudEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day);
    List<LogCloudEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type);
    // between (type, sender)
    List<LogCloudEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    // limit (before methods)
    List<LogCloudEntity> findAllByOrderByUnixTimeDesc(Pageable pageable);
    List<LogCloudEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable);
    List<LogCloudEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable);
    List<LogCloudEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable);
    List<LogCloudEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable);
    List<LogCloudEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

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
