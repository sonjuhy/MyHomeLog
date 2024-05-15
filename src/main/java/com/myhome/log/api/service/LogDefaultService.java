package com.myhome.log.api.service;

import com.myhome.log.db.entity.LogDefaultEntity;

import java.util.List;

public interface LogDefaultService {
    // Order
    // default (type, day, sender, service)
    LogDefaultEntity findById(String category, long id);
    List<LogDefaultEntity> findByType(boolean type);
    List<LogDefaultEntity> findByDay(String day);
    List<LogDefaultEntity> findByDayAndType(String day, boolean type);
    List<LogDefaultEntity> findBySender(String sender);
    List<LogDefaultEntity> findBySenderAndType(String sender, boolean type);
    List<LogDefaultEntity> findBySenderAndDay(String sender, String day);
    List<LogDefaultEntity> findBySenderAndDayAndType(String sender, String day, boolean type);
    List<LogDefaultEntity> findByService(String service);
    List<LogDefaultEntity> findByServiceAndType(String service, boolean type);
    List<LogDefaultEntity> findByServiceAndDay(String service, String day);
    List<LogDefaultEntity> findByServiceAndDayAndType(String service, String day, boolean type);
    List<LogDefaultEntity> findByServiceAndSender(String service, String sender);
    List<LogDefaultEntity> findByServiceAndSenderAndType(String service, String sender, boolean type);
    List<LogDefaultEntity> findByServiceAndSenderAndDay(String service, String sender, String day);
    List<LogDefaultEntity> findByServiceAndSenderAndDayAndType(String service, String sender, String day, boolean type);
    // between (type, sender, service)
    List<LogDefaultEntity> findByDayBetween(String startDate, String endDate);
    List<LogDefaultEntity> findByTypeBetween(boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findBySenderBetween(String sender, String startDate, String endDate);
    List<LogDefaultEntity> findBySenderAndTypeBetween(String sender, boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceBetween(String service, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndTypeBetween(String service, boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndSenderBetween(String service, String sender, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeBetween(String service, String sender, boolean type, String startDate, String endDate);
    // limit (before methods)
    List<LogDefaultEntity> findByTypeLimit(boolean type, int page, int size);
    List<LogDefaultEntity> findByDayLimit(String day, int page, int size);
    List<LogDefaultEntity> findByDayAndTypeLimit(String day, boolean type, int page, int size);
    List<LogDefaultEntity> findBySenderLimit(String sender, int page, int size);
    List<LogDefaultEntity> findBySenderAndTypeLimit(String sender, boolean type, int page, int size);
    List<LogDefaultEntity> findBySenderAndDayLimit(String sender, String day, int page, int size);
    List<LogDefaultEntity> findBySenderAndDayAndTypeLimit(String sender, String day, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceLimit(String service, int page, int size);
    List<LogDefaultEntity> findByServiceAndTypeLimit(String service, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndDayLimit(String service, String day, int page, int size);
    List<LogDefaultEntity> findByServiceAndDayAndTypeLimit(String service, String day, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderLimit(String service, String sender, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeLimit(String service, String sender, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndDayLimit(String service, String sender, String day, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeLimit(String service, String sender, String day, boolean type, int page, int size);
    // between (type, sender, service)
    List<LogDefaultEntity> findByTypeBetweenLimit(String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByTypeBetweenLimit(boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findBySenderBetweenLimit(String sender, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findBySenderAndTypeBetweenLimit(String sender, boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceBetweenLimit(String service, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndTypeBetweenLimit(String service, boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderBetweenLimit(String service, String sender, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenLimit(String service, String sender, boolean type, String startDate, String endDate, int page, int size);


    // Reverse
    // default (type, day, sender, service)
    List<LogDefaultEntity> findByTypeReverse(boolean type);
    List<LogDefaultEntity> findByDayReverse(String day);
    List<LogDefaultEntity> findByDayAndTypeReverse(String day, boolean type);
    List<LogDefaultEntity> findBySenderReverse(String sender);
    List<LogDefaultEntity> findBySenderAndTypeReverse(String sender, boolean type);
    List<LogDefaultEntity> findBySenderAndDayReverse(String sender, String day);
    List<LogDefaultEntity> findBySenderAndDayAndTypeReverse(String sender, String day, boolean type);
    List<LogDefaultEntity> findByServiceReverse(String service);
    List<LogDefaultEntity> findByServiceAndTypeReverse(String service, boolean type);
    List<LogDefaultEntity> findByServiceAndDayReverse(String service, String day);
    List<LogDefaultEntity> findByServiceAndDayAndTypeReverse(String service, String day, boolean type);
    List<LogDefaultEntity> findByServiceAndSenderReverse(String service, String sender);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeReverse(String service, String sender, boolean type);
    List<LogDefaultEntity> findByServiceAndSenderAndDayReverse(String service, String sender, String day);
    List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeReverse(String service, String sender, String day, boolean type);
    // between (type, sender, service)
    List<LogDefaultEntity> findByBetweenReverse(String startDate, String endDate);
    List<LogDefaultEntity> findByTypeBetweenReverse(boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findBySenderBetweenReverse(String sender, String startDate, String endDate);
    List<LogDefaultEntity> findBySenderAndTypeBetweenReverse(String sender, boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceBetweenReverse(String service, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndTypeBetweenReverse(String service, boolean type, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndSenderBetweenReverse(String service, String sender, String startDate, String endDate);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenReverse(String service, String sender, boolean type, String startDate, String endDate);
    // limit (before methods)
    List<LogDefaultEntity> findByTypeLimitReverse(boolean type, int page, int size);
    List<LogDefaultEntity> findByDayLimitReverse(String day, int page, int size);
    List<LogDefaultEntity> findByDayAndTypeLimitReverse(String day, boolean type, int page, int size);
    List<LogDefaultEntity> findBySenderLimitReverse(String sender, int page, int size);
    List<LogDefaultEntity> findBySenderAndTypeLimitReverse(String sender, boolean type, int page, int size);
    List<LogDefaultEntity> findBySenderAndDayLimitReverse(String sender, String day, int page, int size);
    List<LogDefaultEntity> findBySenderAndDayAndTypeLimitReverse(String sender, String day, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceLimitReverse(String service, int page, int size);
    List<LogDefaultEntity> findByServiceAndTypeLimitReverse(String service, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndDayLimitReverse(String service, String day, int page, int size);
    List<LogDefaultEntity> findByServiceAndDayAndTypeLimitReverse(String service, String day, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderLimitReverse(String service, String sender, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeLimitReverse(String service, String sender, boolean type, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndDayLimitReverse(String service, String sender, String day, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeLimitReverse(String service, String sender, String day, boolean type, int page, int size);
    // between (type, sender, service)
    List<LogDefaultEntity> findByTypeBetweenLimitReverse(String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByTypeBetweenLimitReverse(boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findBySenderBetweenLimitReverse(String sender, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findBySenderAndTypeBetweenLimitReverse(String sender, boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceBetweenLimitReverse(String service, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndTypeBetweenLimitReverse(String service, boolean type, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderBetweenLimitReverse(String service, String sender, String startDate, String endDate, int page, int size);
    List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenLimitReverse(String service, String sender, boolean type, String startDate, String endDate, int page, int size);

    // Count
    long countByType(boolean type);
    long countByDay(String day);
    long countByDayAndType(String day, boolean type);
    long countBySender(String sender);
    long countBySenderAndDay(String sender, String day);
    long countBySenderAndDayAndType(String sender, String day, boolean type);
    long countByService(String service);
    long countByServiceAndType(String service, boolean type);
    long countByServiceAndDay(String service, String day);
    long countByServiceAndDayAndType(String service, String day, boolean type);
    long countByServiceAndSender(String service, String sender);
    long countByServiceAndSenderAndType(String service, String sender, boolean type);
    long countByServiceAndSenderAndDay(String service, String sender, String day);
    long countByServiceAndSenderAndDayAndType(String service, String sender, String day, boolean type);

    // between
    long countByStartToEnd(String startDay, String endDay);
    long countByStartToEndAndType(String startDay, String endDay, boolean type);
    long countByServiceAndStartToEndDayAndType(String service, String start, String end, boolean type);

    // Delete
    void deleteById(String category, long id);
    void deleteByDay(String day);
    void deleteBySender(String sender);
    void deleteByService(String service);
}
