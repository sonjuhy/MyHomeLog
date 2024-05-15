package com.myhome.log.api.service;

import com.myhome.log.db.entity.LogDefaultEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogDefaultServiceImpl implements LogDefaultService{

    @Autowired
    LogCloudService cloudService;

    @Autowired
    LogCloudCheckService cloudCheckService;

    @Autowired
    LogReserveService reserveService;

    @Autowired
    LogIotService iotService;

    @Autowired
    LogWeatherService weatherService;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public LogDefaultEntity findById(String category, long id) {
        return switch (category) {
            case "cloud" -> modelMapper.map(cloudService.findById(id), LogDefaultEntity.class);
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findById(id), LogDefaultEntity.class);
            case "reserve" -> modelMapper.map(reserveService.findById(id), LogDefaultEntity.class);
            case "iot" -> modelMapper.map(iotService.findById(id), LogDefaultEntity.class);
            case "weather" -> modelMapper.map(weatherService.findById(id), LogDefaultEntity.class);
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByType(boolean type) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDay(String day) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDayAndType(String day, boolean type) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySender(String sender) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndType(String sender, boolean type) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDay(String sender, String day) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayAndType(String sender, String day, boolean type) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByService(String service) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAll(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAll(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAll(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAll(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAll(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndType(String service, boolean type) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findByType(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDay(String service, String day) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findByDay(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayAndType(String service, String day, boolean type) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findByDayAndType(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSender(String service, String sender) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findBySender(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndType(String service, String sender, boolean type) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findBySenderAndType(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDay(String service, String sender, String day) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findBySenderAndDay(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayAndType(String service, String sender, String day, boolean type) {
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findBySenderAndDayAndType(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByDayBetween(String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetween(boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderBetween(String sender, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeBetween(String sender, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceBetween(String service, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findByDayBetween(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeBetween(String service, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findByTypeAndDayBetween(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderBetween(String service, String sender, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findBySenderAndDayBetween(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeBetween(String service, String sender, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeLimit(boolean type, int page, int size) {
//        List<LogDefaultEntity> list = new ArrayList<>();
//        Pageable pageable = PageRequest.of(page, size);
//        list.addAll(modelMapper.map(cloudCheckService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
//        list.addAll(modelMapper.map(cloudService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
//        list.addAll(modelMapper.map(reserveService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
//        list.addAll(modelMapper.map(iotService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
//        list.addAll(modelMapper.map(weatherService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
//        list.sort(Comparator.comparing(LogDefaultEntity::getUnix_time));
//        list.subList(0, (page + 1) * size);
//        SortOperation sort = Aggregation.sort(Sort.by("unix_time"));
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("type").is(type)),
//                sort,
//                Aggregation.skip((long) (page + 1) *size),
//                Aggregation.limit(size)
//        );
//        List<LogDefaultEntity> list = mongoTemplate.aggregate(aggregation, "cloud_check_log", LogDefaultEntity.class).getMappedResults();
//        return list;
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByDayLimit(String day, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByDayAndTypeLimit(String day, boolean type, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderLimit(String sender, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeLimit(String sender, boolean type, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayLimit(String sender, String day, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayAndTypeLimit(String sender, String day, boolean type, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByServiceLimit(String service, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBy(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBy(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBy(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBy(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBy(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeLimit(String service, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByType(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayLimit(String service, String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByDay(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByDay(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByDay(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByDay(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByDay(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayAndTypeLimit(String service, String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByDayAndType(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByDayAndType(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByDayAndType(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByDayAndType(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByDayAndType(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderLimit(String service, String sender, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySender(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySender(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySender(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySender(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySender(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeLimit(String service, String sender, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndType(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndType(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndType(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndType(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndType(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayLimit(String service, String sender, String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndDay(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndDay(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndDay(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndDay(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndDay(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeLimit(String service, String sender, String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndDayAndType(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndDayAndType(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndDayAndType(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndDayAndType(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndDayAndType(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetweenLimit(String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetweenLimit(boolean type, String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderBetweenLimit(String sender, String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeBetweenLimit(String sender, boolean type, String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByServiceBetweenLimit(String service, String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeBetweenLimit(String service, boolean type, String startDate, String endDate, int page, int size) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderBetweenLimit(String service, String sender, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenLimit(String service, String sender, boolean type, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeReverse(boolean type) { // need to change OrderByUnixTime method
        List<LogDefaultEntity> list = findByType(type);
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<LogDefaultEntity> findByDayReverse(String day) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByDayAndTypeReverse(String day, boolean type) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderReverse(String sender) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeReverse(String sender, boolean type) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayReverse(String sender, String day) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayAndTypeReverse(String sender, String day, boolean type) {
        return null;
    }

    @Override
    public List<LogDefaultEntity> findByServiceReverse(String service) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findByOrderByUnixTimeDesc(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findByOrderByUnixTimeDesc(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findByOrderByUnixTimeDesc(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findByOrderByUnixTimeDesc(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findByOrderByUnixTimeDesc(), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeReverse(String service, boolean type) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findByTypeOrderByUnixTimeDesc(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findByTypeOrderByUnixTimeDesc(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findByTypeOrderByUnixTimeDesc(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findByTypeOrderByUnixTimeDesc(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findByTypeOrderByUnixTimeDesc(type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayReverse(String service, String day) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findByDayOrderByUnixTimeDesc(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findByDayOrderByUnixTimeDesc(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findByDayOrderByUnixTimeDesc(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findByDayOrderByUnixTimeDesc(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findByDayOrderByUnixTimeDesc(day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayAndTypeReverse(String service, String day, boolean type) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findByDayAndTypeOrderByUnixTimeDesc(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findByDayAndTypeOrderByUnixTimeDesc(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findByDayAndTypeOrderByUnixTimeDesc(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findByDayAndTypeOrderByUnixTimeDesc(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findByDayAndTypeOrderByUnixTimeDesc(day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderReverse(String service, String sender) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findBySenderOrderByUnixTimeDesc(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findBySenderOrderByUnixTimeDesc(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findBySenderOrderByUnixTimeDesc(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findBySenderOrderByUnixTimeDesc(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findBySenderOrderByUnixTimeDesc(sender), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeReverse(String service, String sender, boolean type) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findBySenderAndTypeOrderByUnixTimeDesc(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findBySenderAndTypeOrderByUnixTimeDesc(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findBySenderAndTypeOrderByUnixTimeDesc(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findBySenderAndTypeOrderByUnixTimeDesc(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findBySenderAndTypeOrderByUnixTimeDesc(sender, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayReverse(String service, String sender, String day) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findBySenderAndDayOrderByUnixTimeDesc(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findBySenderAndDayOrderByUnixTimeDesc(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findBySenderAndDayOrderByUnixTimeDesc(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findBySenderAndDayOrderByUnixTimeDesc(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findBySenderAndDayOrderByUnixTimeDesc(sender, day), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeReverse(String service, String sender, String day, boolean type) {
        return switch (service){
            case "cloudCheck"->modelMapper.map(cloudCheckService.findBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloud"->modelMapper.map(cloudService.findBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot"->modelMapper.map(iotService.findBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve"->modelMapper.map(reserveService.findBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather"->modelMapper.map(weatherService.findBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByBetweenReverse(String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetweenReverse(boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderBetweenReverse(String sender, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeBetweenReverse(String sender, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findBySenderAndTypeBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceBetweenReverse(String service, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeBetweenReverse(String service, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderBetweenReverse(String service, String sender, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenReverse(String service, String sender, boolean type, String startDate, String endDate) {
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeLimitReverse(boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDayLimitReverse(String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDayAndTypeLimitReverse(String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderLimitReverse(String sender, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeLimitReverse(String sender, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayLimitReverse(String sender, String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndDayAndTypeLimitReverse(String sender, String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();

        resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(iotService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceLimitReverse(String service, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByOrderByUnixTimeDesc(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByOrderByUnixTimeDesc(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByOrderByUnixTimeDesc(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByOrderByUnixTimeDesc(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByOrderByUnixTimeDesc(pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeLimitReverse(String service, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByTypeOrderByUnixTimeDesc(type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayLimitReverse(String service, String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByDayOrderByUnixTimeDesc(day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndDayAndTypeLimitReverse(String service, String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllByDayAndTypeOrderByUnixTimeDesc(day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderLimitReverse(String service, String sender, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderOrderByUnixTimeDesc(sender, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeLimitReverse(String service, String sender, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndTypeOrderByUnixTimeDesc(sender, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayLimitReverse(String service, String sender, String day, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndDayOrderByUnixTimeDesc(sender, day, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndDayAndTypeLimitReverse(String service, String sender, String day, boolean type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return switch (service) {
            case "cloud" -> modelMapper.map(cloudService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "cloudCheck" -> modelMapper.map(cloudCheckService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "reserve" -> modelMapper.map(reserveService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "iot" -> modelMapper.map(iotService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            case "weather" -> modelMapper.map(weatherService.findAllBySenderAndDayAndTypeOrderByUnixTimeDesc(sender, day, type, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType());
            default -> null;
        };
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetweenLimitReverse(String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findAllByDayBetween(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findAllByDayBetween(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findAllByDayBetween(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findAllByDayBetween(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findAllByDayBetween(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByTypeBetweenLimitReverse(boolean type, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findAllByTypeAndDayBetween(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findAllByTypeAndDayBetween(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findAllByTypeAndDayBetween(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findAllByTypeAndDayBetween(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findAllByTypeAndDayBetween(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderBetweenLimitReverse(String sender, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndDayBetween(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findBySenderAndTypeBetweenLimitReverse(String sender, boolean type, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(iotService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndTypeAndDayBetween(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceBetweenLimitReverse(String service, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllByDayBetweenOrderByUnixTimeDesc(startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllByDayBetweenOrderByUnixTimeDesc( startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndTypeBetweenLimitReverse(String service, boolean type, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllByTypeAndDayBetweenOrderByUnixTimeDesc(type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderBetweenLimitReverse(String service, String sender, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndDayBetweenOrderByUnixTimeDesc(sender, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByServiceAndSenderAndTypeBetweenLimitReverse(String service, String sender, boolean type, String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LogDefaultEntity> resultList = new ArrayList<>();
        try {
            String startDateStr = toMinusDay(startDate);
            String endDateStr = toPlusDay(endDate);

            switch (service){
                case "cloudCheck"->resultList.addAll(modelMapper.map(cloudCheckService.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "cloud"->resultList.addAll(modelMapper.map(cloudService.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "iot"->resultList.addAll(modelMapper.map(iotService.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "reserve"->resultList.addAll(modelMapper.map(reserveService.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                case "weather"->resultList.addAll(modelMapper.map(weatherService.findAllBySenderAndTypeAndDayBetweenOrderByUnixTimeDesc(sender, type, startDateStr, endDateStr, pageable), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public long countByType(boolean type) {
        return cloudCheckService.countByType(type)
         + cloudService.countByType(type)
         + iotService.countByType(type)
         + reserveService.countByType(type)
         + weatherService.countByType(type);
    }

    @Override
    public long countByDay(String day) {
        return cloudCheckService.countByDay(day)
                + cloudService.countByDay(day)
                + iotService.countByDay(day)
                + reserveService.countByDay(day)
                + weatherService.countByDay(day);
    }

    @Override
    public long countByDayAndType(String day, boolean type) {
        return cloudCheckService.countByDayAndType(day, type)
                + cloudService.countByDayAndType(day, type)
                + iotService.countByDayAndType(day, type)
                + reserveService.countByDayAndType(day, type)
                + weatherService.countByDayAndType(day, type);
    }

    @Override
    public long countByStartToEnd(String startDay, String endDay) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long result = 0;
        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+(startCal.get(Calendar.MONTH)+1)+"-"+startCal.get(Calendar.DATE);
                result += cloudService.countByDay(dateStr)
                        + cloudCheckService.countByDay(dateStr)
                        + iotService.countByDay(dateStr)
                        + reserveService.countByDay(dateStr)
                        + weatherService.countByDay(dateStr);
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long countByStartToEndAndType(String startDay, String endDay, boolean type) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long result = 0;
        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+(startCal.get(Calendar.MONTH)+1)+"-"+startCal.get(Calendar.DATE);
                result += cloudService.countByDayAndType(dateStr, type)
                        + cloudCheckService.countByDayAndType(dateStr, type)
                        + iotService.countByDayAndType(dateStr, type)
                        + reserveService.countByDayAndType(dateStr, type)
                        + weatherService.countByDayAndType(dateStr, type);
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long countBySender(String sender) {
        return cloudCheckService.countBySender(sender)
                + cloudService.countBySender(sender)
                + iotService.countBySender(sender)
                + reserveService.countBySender(sender)
                + weatherService.countBySender(sender);
    }

    @Override
    public long countBySenderAndDay(String sender, String day) {
        return cloudCheckService.countBySenderAndDay(sender, day)
                + cloudService.countBySenderAndDay(sender, day)
                + iotService.countBySenderAndDay(sender, day)
                + reserveService.countBySenderAndDay(sender, day)
                + weatherService.countBySenderAndDay(sender, day);
    }

    @Override
    public long countBySenderAndDayAndType(String sender, String day, boolean type) {
        return cloudCheckService.countBySenderAndDayAndType(sender, day, type)
                + cloudService.countBySenderAndDayAndType(sender, day, type)
                + iotService.countBySenderAndDayAndType(sender, day, type)
                + reserveService.countBySenderAndDayAndType(sender, day, type)
                + weatherService.countBySenderAndDayAndType(sender, day, type);
    }

    @Override
    public long countByService(String service) {
        return switch (service) {
            case "cloud" -> cloudService.count();
            case "cloudCheck" -> cloudCheckService.count();
            case "reserve" -> reserveService.count();
            case "iot" -> iotService.count();
            case "weather" -> weatherService.count();
            default -> -1;
        };
    }

    @Override
    public long countByServiceAndType(String service, boolean type) {
        return switch (service) {
            case "cloud" -> cloudService.countByType(type);
            case "cloudCheck" -> cloudCheckService.countByType(type);
            case "reserve" -> reserveService.countByType(type);
            case "iot" -> iotService.countByType(type);
            case "weather" -> weatherService.countByType(type);
            default -> -1;
        };
    }

    @Override
    public long countByServiceAndDay(String service, String day) {
        return switch (service) {
            case "cloud" -> cloudService.countByDay(day);
            case "cloudCheck" -> cloudCheckService.countByDay(day);
            case "reserve" -> reserveService.countByDay(day);
            case "iot" -> iotService.countByDay(day);
            case "weather" -> weatherService.countByDay(day);
            default -> -1;
        };
    }

    @Override
    public long countByServiceAndDayAndType(String service, String day, boolean type) {
        return switch (service) {
            case "cloud" -> cloudService.countByDayAndType(day, type);
            case "cloudCheck" -> cloudCheckService.countByDayAndType(day, type);
            case "reserve" -> reserveService.countByDayAndType(day, type);
            case "iot" -> iotService.countByDayAndType(day, type);
            case "weather" -> weatherService.countByDayAndType(day, type);
            default -> -1;
        };
    }

    @Override
    public long countByServiceAndSender(String service, String sender) {
        return switch (service) {
            case "cloud" -> cloudService.countBySender(sender);
            case "cloudCheck" -> cloudCheckService.countBySender(sender);
            case "reserve" -> reserveService.countBySender(sender);
            case "iot" -> iotService.countBySender(sender);
            case "weather" -> weatherService.countBySender(sender);
            default -> -1;
        };
    }

    @Override
    public long countByServiceAndSenderAndType(String service, String sender, boolean type) {
        return 0;
    }

    @Override
    public long countByServiceAndSenderAndDay(String service, String sender, String day) {
        return 0;
    }

    @Override
    public long countByServiceAndSenderAndDayAndType(String service, String sender, String day, boolean type) {
        return 0;
    }

    @Override
    public long countByServiceAndStartToEndDayAndType(String service, String start, String end, boolean type) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long result = 0;
        try {
            Date startDate = startDateFormat.parse(start);
            Date endDate = endDateFormat.parse(end);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            while(startCal.compareTo(endCal) <= 0){
                String day = startCal.get(Calendar.YEAR)+"-"+(startCal.get(Calendar.MONTH)+1)+"-"+startCal.get(Calendar.DATE);
                switch (service) {
                    case "cloud" -> result = cloudService.countByDay(day);
                    case "cloudCheck" -> result = cloudCheckService.countByDay(day);
                    case "reserve" -> result = reserveService.countByDay(day);
                    case "iot" -> result = iotService.countByDay(day);
                    case "weather" -> result = weatherService.countByDay(day);
                };
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteById(String category, long id) {
        switch (category) {
            case "cloud" -> cloudService.deleteById(id);
            case "cloudCheck" -> cloudCheckService.deleteById(id);
            case "reserve" -> reserveService.deleteById(id);
            case "iot" -> iotService.deleteById(id);
            case "weather" -> weatherService.deleteById(id);
        }
    }

    @Override
    public void deleteByDay(String day) {
        switch (day) {
            case "cloud" -> cloudService.deleteByDay(day);
            case "cloudCheck" -> cloudCheckService.deleteByDay(day);
            case "reserve" -> reserveService.deleteByDay(day);
            case "iot" -> iotService.deleteByDay(day);
            case "weather" -> weatherService.deleteByDay(day);
        }
    }

    @Override
    public void deleteBySender(String sender) {
        switch (sender) {
            case "cloud" -> cloudService.deleteBySender(sender);
            case "cloudCheck" -> cloudCheckService.deleteBySender(sender);
            case "reserve" -> reserveService.deleteBySender(sender);
            case "iot" -> iotService.deleteBySender(sender);
            case "weather" -> weatherService.deleteBySender(sender);
        }
    }

    @Override
    public void deleteByService(String service) {
        switch (service) {
            case "cloud" -> cloudService.deleteByService(service);
            case "cloudCheck" -> cloudCheckService.deleteByService(service);
            case "reserve" -> reserveService.deleteByService(service);
            case "iot" -> iotService.deleteByService(service);
            case "weather" -> weatherService.deleteByService(service);
        }
    }

    private String toMinusDay(String day){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDay = startDateFormat.parse(day);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDay);
            startCal.add(Calendar.DATE, -1);
            sb.append(
                    startCal.get(Calendar.YEAR))
                    .append("-")
                    .append(startCal.get(Calendar.MONTH) + 1)
                    .append("-")
                    .append(startCal.get(Calendar.DATE)
                    );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String toPlusDay(String day){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDay = startDateFormat.parse(day);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDay);
            startCal.add(Calendar.DATE, 1);
            sb.append(
                            startCal.get(Calendar.YEAR))
                    .append("-")
                    .append(startCal.get(Calendar.MONTH) + 1)
                    .append("-")
                    .append(startCal.get(Calendar.DATE)
                    );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
