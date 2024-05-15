package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogCloudEntity;
import com.myhome.log.db.repository.LogCloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogCloudServiceImpl implements LogCloudService{

    @Autowired
    LogCloudRepository repository;

    @Override
    public LogCloudEntity insert(LogDefaultDto dto) {
        return repository.insert(dtoToEntity(dto));
    }

    @Override
    public List<LogCloudEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LogCloudEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogCloudEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogCloudEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogCloudEntity> findByDayAndType(String day, boolean type) {
        return repository.findByDayAndType(day, type);
    }

    @Override
    public List<LogCloudEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndType(String sender, boolean type) {
        return repository.findBySenderAndType(sender, type);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDay(String sender, String day) {
        return repository.findBySenderAndDay(sender, day);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.findBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public List<LogCloudEntity> findByDayBetween(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetween(startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetween(type, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetween(sender, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetween(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findAllBy(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDay(String day, Pageable pageable) {
        return repository.findAllByDay(day, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByType(boolean type, Pageable pageable) {
        return repository.findAllByType(type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDayAndType(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndType(day, type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySender(String sender, Pageable pageable) {
        return repository.findAllBySender(sender, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable) {
        return null;
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDay(sender, day, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndType(sender, day, type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetween(startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetween(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetween(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndTypeAndDayBetween(sender, type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findByOrderByUnixTimeDesc() {
        return repository.findByOrderByUnixTimeDesc();
    }

    @Override
    public List<LogCloudEntity> findByTypeOrderByUnixTimeDesc(boolean type) {
        return repository.findByTypeOrderByUnixTimeDesc(type);
    }

    @Override
    public List<LogCloudEntity> findByDayOrderByUnixTimeDesc(String day) {
        return repository.findByDayOrderByUnixTimeDesc(day);
    }

    @Override
    public List<LogCloudEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type) {
        return repository.findByDayAndTypeOrderByUnixTimeDesc(day, type);
    }

    @Override
    public List<LogCloudEntity> findBySenderOrderByUnixTimeDesc(String sender) {
        return repository.findBySenderOrderByUnixTimeDesc(sender);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type) {
        return repository.findBySenderAndTypeOrderByUnixTimeDesc(sender, type);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day) {
        return null;
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type) {
        return null;
    }

    @Override
    public List<LogCloudEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetweenOrderByUnixTimeDesc(startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudEntity> findAllByOrderByUnixTimeDesc(Pageable pageable) {
        return repository.findAllByOrderByUnixTimeDesc(pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable) {
        return repository.findAllByDayOrderByUnixTimeDesc(day, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable) {
        return repository.findAllByTypeOrderByUnixTimeDesc(type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable) {
        return repository.findAllBySenderOrderByUnixTimeDesc(sender, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetweenOrderByUnixTimeDesc(startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
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

    private LogCloudEntity dtoToEntity(LogDefaultDto dto){
        LogCloudEntity entity = new LogCloudEntity(
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
