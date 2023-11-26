package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogWeatherEntity;
import com.myhome.log.db.entity.LogWeatherEntity;
import com.myhome.log.db.repository.LogWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class LogWeatherServiceImpl implements LogWeatherService{

    @Autowired
    LogWeatherRepository repository;

    @Override
    public LogWeatherEntity insert(LogDefaultDto dto) {
        return repository.insert(dtoToEntity(dto));
    }

    @Override
    public List<LogWeatherEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LogWeatherEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogWeatherEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogWeatherEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogWeatherEntity> findByDayAndType(String day, boolean type) {
        return repository.findByDayAndType(day, type);
    }

    @Override
    public List<LogWeatherEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndType(String sender, boolean type) {
        return repository.findBySenderAndType(sender, type);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDay(String sender, String day) {
        return repository.findBySenderAndDay(sender, day);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.findBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public List<LogWeatherEntity> findByDayBetween(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetween(startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetween(type, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetween(sender, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetween(sender, type, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findAllBy(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDay(String day, Pageable pageable) {
        return repository.findAllByDay(day, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByType(boolean type, Pageable pageable) {
        return repository.findAllByType(type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDayAndType(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndType(day, type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySender(String sender, Pageable pageable) {
        return repository.findAllBySender(sender, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable) {
        return null;
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDay(sender, day, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndType(sender, day, type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetween(startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetween(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetween(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndTypeAndDayBetween(sender, type, startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findByOrderByUnixTimeDesc() {
        return repository.findByOrderByUnixTimeDesc();
    }

    @Override
    public List<LogWeatherEntity> findByTypeOrderByUnixTimeDesc(boolean type) {
        return repository.findByTypeOrderByUnixTimeDesc(type);
    }

    @Override
    public List<LogWeatherEntity> findByDayOrderByUnixTimeDesc(String day) {
        return repository.findByDayOrderByUnixTimeDesc(day);
    }

    @Override
    public List<LogWeatherEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type) {
        return repository.findByDayAndTypeOrderByUnixTimeDesc(day, type);
    }

    @Override
    public List<LogWeatherEntity> findBySenderOrderByUnixTimeDesc(String sender) {
        return repository.findBySenderOrderByUnixTimeDesc(sender);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type) {
        return repository.findBySenderAndTypeOrderByUnixTimeDesc(sender, type);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day) {
        return null;
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type) {
        return null;
    }

    @Override
    public List<LogWeatherEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetweenOrderByUnixTimeDesc(startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogWeatherEntity> findAllByOrderByUnixTimeDesc(Pageable pageable) {
        return repository.findAllByOrderByUnixTimeDesc(pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable) {
        return repository.findAllByDayOrderByUnixTimeDesc(day, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable) {
        return repository.findAllByTypeOrderByUnixTimeDesc(type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable) {
        return repository.findAllBySenderOrderByUnixTimeDesc(sender, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetweenOrderByUnixTimeDesc(startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogWeatherEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate, pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }


    @Override
    public long countByType(boolean type) {
        return repository.countByType(type);
    }

    @Override
    public long countByDay(String day) {
        return repository.countByDay(day);
    }

    @Override
    public long countByDayAndType(String day, boolean type) {
        return repository.countByDayAndType(day, type);
    }

    @Override
    public long countBySender(String sender) {
        return repository.countBySender(sender);
    }

    @Override
    public long countBySenderAndDay(String sender, String day) {
        return repository.countBySenderAndDay(sender, day);
    }

    @Override
    public long countBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.countBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public long countByDayBetween(String startDate, String endDate) {
        return repository.countByDayBetween(startDate, endDate);
    }

    @Override
    public long countByTypeAndDayBetween(boolean type, String startDate, String endDate) {
        return repository.countByTypeAndDayBetween(type, startDate, endDate);
    }

    @Override
    public long countBySenderAndDayBetween(String sender, String startDate, String endDate) {
        return repository.countBySenderAndDayBetween(sender, startDate, endDate);
    }

    @Override
    public long countBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) {
        return repository.countBySenderAndTypeAndDayBetween(sender, type, startDate, endDate);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByDay(String day) {
        repository.deleteByDay(day);
    }

    @Override
    public void deleteBySender(String sender) {
        repository.deleteBySender(sender);
    }

    @Override
    public void deleteByService(String service) {
        repository.deleteByService(service);
    }

    private LogWeatherEntity dtoToEntity(LogDefaultDto dto){
        LogWeatherEntity entity = new LogWeatherEntity(
                dto.getId(),
                dto.getUnixTime(),
                dto.isType(),
                dto.getSender(),
                dto.getService(),
                dto.getDay(),
                dto.getTime(),
                dto.getContent());
        return entity;
    }
}
