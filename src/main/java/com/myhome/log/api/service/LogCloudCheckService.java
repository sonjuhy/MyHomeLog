package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogCloudCheckEntity;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface LogCloudCheckService {
    LogCloudCheckEntity insert(LogDefaultDto dto);
    List<LogCloudCheckEntity> findAll();

    // Order
    // default (type, day, sender)
    LogCloudCheckEntity findById(long id);
    List<LogCloudCheckEntity> findByType(boolean type);
    List<LogCloudCheckEntity> findByDay(String day);
    List<LogCloudCheckEntity> findByDayAndType(String day, boolean type);
    List<LogCloudCheckEntity> findBySender(String sender);
    List<LogCloudCheckEntity> findBySenderAndType(String sender, boolean type);
    List<LogCloudCheckEntity> findBySenderAndDay(String sender, String day);
    List<LogCloudCheckEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    // between (type, sender)
    List<LogCloudCheckEntity> findByDayBetween(String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException;

    // limit (before methods)
    List<LogCloudCheckEntity> findAllBy(Pageable pageable);
    List<LogCloudCheckEntity> findAllByDay(String day, Pageable pageable);
    List<LogCloudCheckEntity> findAllByType(boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllByDayAndType(String day, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySender(String sender, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

    // Reverse (all Order methods)
    // default (type, day, sender)
    List<LogCloudCheckEntity> findByOrderByUnixTimeDesc();
    List<LogCloudCheckEntity> findByTypeOrderByUnixTimeDesc(boolean type);
    List<LogCloudCheckEntity> findByDayOrderByUnixTimeDesc(String day);
    List<LogCloudCheckEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type);
    List<LogCloudCheckEntity> findBySenderOrderByUnixTimeDesc(String sender);
    List<LogCloudCheckEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type);
    List<LogCloudCheckEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day);
    List<LogCloudCheckEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type);
    // between (type, sender)
    List<LogCloudCheckEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    List<LogCloudCheckEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException;
    // limit (before methods)
    List<LogCloudCheckEntity> findAllByOrderByUnixTimeDesc(Pageable pageable);
    List<LogCloudCheckEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable);
    List<LogCloudCheckEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable);
    List<LogCloudCheckEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable);
    List<LogCloudCheckEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException;
    List<LogCloudCheckEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException;

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
