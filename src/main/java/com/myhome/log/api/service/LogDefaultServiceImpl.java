package com.myhome.log.api.service;

import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.db.entity.LogDefaultEntity;
import com.myhome.log.db.repository.LogDefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogDefaultServiceImpl implements LogDefaultService{

    @Autowired
    LogDefaultRepository repository;

    @Override
    public LogDefaultEntity insert(LogDefaultDto dto) {
        return repository.insert(dto.dtoToEntity());
    }

    @Override
    public LogDefaultEntity findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<LogDefaultEntity> findByType(boolean type) {
        return repository.findByType(type);
    }

    @Override
    public List<LogDefaultEntity> findByDay(String day) {
        return repository.findByDay(day);
    }

    @Override
    public List<LogDefaultEntity> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<LogDefaultEntity> findByService(String service) {
        return repository.findByService(service);
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
}
