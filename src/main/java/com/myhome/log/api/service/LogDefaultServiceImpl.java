package com.myhome.log.api.service;

import com.myhome.log.db.entity.LogDefaultEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<LogDefaultEntity> findByDayStartToEnd(String startDay, String endDay) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogDefaultEntity> resultList = new ArrayList<>();

        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+(startCal.get(Calendar.MONTH)+1)+"-"+startCal.get(Calendar.DATE);
                resultList.addAll(modelMapper.map(cloudCheckService.findByDay(dateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(cloudService.findByDay(dateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(iotService.findByDay(dateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(reserveService.findByDay(dateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(weatherService.findByDay(dateStr), new TypeToken<List<LogDefaultEntity>>(){}.getType()));

                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<LogDefaultEntity> findByDayStartToEndAndType(String startDay, String endDay, boolean type) {
        SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<LogDefaultEntity> resultList = new ArrayList<>();

        try {
            Date startDate = startDateFormat.parse(startDay);
            Date endDate = endDateFormat.parse(endDay);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);
            while(startCal.compareTo(endCal) <= 0){
                String dateStr = startCal.get(Calendar.YEAR)+"-"+startCal.get(Calendar.MONTH)+"-"+startCal.get(Calendar.DATE);
                resultList.addAll(modelMapper.map(cloudCheckService.findByDayAndType(dateStr, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(cloudService.findByDayAndType(dateStr, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(iotService.findByDayAndType(dateStr, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(reserveService.findByDayAndType(dateStr, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                resultList.addAll(modelMapper.map(weatherService.findByDayAndType(dateStr, type), new TypeToken<List<LogDefaultEntity>>(){}.getType()));
                startCal.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        return cloudCheckService.countByDay(day)
                + cloudService.countByDay(day)
                + iotService.countByDay(day)
                + reserveService.countByDay(day)
                + weatherService.countByDay(day);
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

}
