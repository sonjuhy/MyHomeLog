package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogCloudCheckEntity;
import com.myhome.log.db.entity.LogCloudCheckEntity;
import com.myhome.log.db.repository.LogCloudCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class LogCloudCheckServiceImpl implements LogCloudCheckService{

    @Autowired
    LogCloudCheckRepository repository;

    @Override
    public LogCloudCheckEntity insert(LogDefaultDto dto) {
        return repository.insert(dtoToEntity(dto));
    }

    @Override
    public List<LogCloudCheckEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LogCloudCheckEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogCloudCheckEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogCloudCheckEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogCloudCheckEntity> findByDayAndType(String day, boolean type) {
        return repository.findByDayAndType(day, type);
    }

    @Override
    public List<LogCloudCheckEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndType(String sender, boolean type) {
        return repository.findBySenderAndType(sender, type);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDay(String sender, String day) {
        return repository.findBySenderAndDay(sender, day);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        return repository.findBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public List<LogCloudCheckEntity> findByDayBetween(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetween(startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findByTypeAndDayBetween(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetween(type, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDayBetween(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetween(sender, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetween(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBy(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDay(String day, Pageable pageable) {
        return repository.findAllByDay(day, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByType(boolean type, Pageable pageable) {
        return repository.findAllByType(type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDayAndType(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndType(day, type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySender(String sender, Pageable pageable) {
        return repository.findAllBySender(sender, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndType(String sender, boolean type, Pageable pageable) {
        return null;
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDay(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDay(sender, day, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDayAndType(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndType(sender, day, type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDayBetween(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetween(startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByTypeAndDayBetween(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetween(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDayBetween(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetween(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndTypeAndDayBetween(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndTypeAndDayBetween(sender, type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findByOrderByUnixTimeDesc() {
        return repository.findByOrderByUnixTimeDesc();
    }

    @Override
    public List<LogCloudCheckEntity> findByTypeOrderByUnixTimeDesc(boolean type) {
        return repository.findByTypeOrderByUnixTimeDesc(type);
    }

    @Override
    public List<LogCloudCheckEntity> findByDayOrderByUnixTimeDesc(String day) {
        return repository.findByDayOrderByUnixTimeDesc(day);
    }

    @Override
    public List<LogCloudCheckEntity> findByDayAndTypeOrderByUnixTimeDesc(String day, boolean type) {
        return repository.findByDayAndTypeOrderByUnixTimeDesc(day, type);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderOrderByUnixTimeDesc(String sender) {
        return repository.findBySenderOrderByUnixTimeDesc(sender);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type) {
        return repository.findBySenderAndTypeOrderByUnixTimeDesc(sender, type);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDayOrderByUnixTimeDesc(String sender, String day) {
        return null;
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type) {
        return null;
    }

    @Override
    public List<LogCloudCheckEntity> findByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate) throws ParseException {
        return repository.findByDayBetweenOrderByUnixTimeDesc(startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate) throws ParseException {
        return repository.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndTypeBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate) throws ParseException {
        return repository.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDate, endDate);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByOrderByUnixTimeDesc(Pageable pageable) {
        return repository.findAllByOrderByUnixTimeDesc(pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDayOrderByUnixTimeDesc(String day, Pageable pageable) {
        return repository.findAllByDayOrderByUnixTimeDesc(day, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByTypeOrderByUnixTimeDesc(boolean type, Pageable pageable) {
        return repository.findAllByTypeOrderByUnixTimeDesc(type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDayAndTypeOrderByUnixTimeDesc(String day, boolean type, Pageable pageable) {
        return repository.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderOrderByUnixTimeDesc(String sender, Pageable pageable) {
        return repository.findAllBySenderOrderByUnixTimeDesc(sender, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndTypeOrderByUnixTimeDesc(String sender, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDayOrderByUnixTimeDesc(String sender, String day, Pageable pageable) {
        return repository.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(String sender, String day, boolean type, Pageable pageable) {
        return repository.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByDayBetweenOrderByUnixTimeDesc(String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByDayBetweenOrderByUnixTimeDesc(startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllByTypeAndDayBetweenOrderByUnixTimeDesc(boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndDayBetweenOrderByUnixTimeDesc(String sender, String startDate, String endDate, Pageable pageable) throws ParseException {
        return repository.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDate, endDate, pageable);
    }

    @Override
    public List<LogCloudCheckEntity> findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(String sender, boolean type, String startDate, String endDate, Pageable pageable) throws ParseException {
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

    private LogCloudCheckEntity dtoToEntity(LogDefaultDto dto){
        LogCloudCheckEntity entity = new LogCloudCheckEntity(
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
