package com.leo.bootstrap;

import com.leo.euclid.mapper.EuclidMapper;
import com.leo.euclid.model.Euclid;
import com.leo.trafficdata.mapper.TrafficDataMapper;
import com.leo.trafficdata.model.TrafficData;
import com.leo.util.TimeSlotUtils;
import com.leo.weatherdata.mapper.WeatherDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hanruofei on 16/6/7.
 */
public class DidiEuclidSlave {
    private static final Logger logger = LoggerFactory.getLogger(DidiEuclidSlave.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        EuclidMapper euclidMapper = (EuclidMapper) applicationContext.getBean("euclidMapper");
        WeatherDataMapper weatherDataMapper = (WeatherDataMapper) applicationContext.getBean("weatherDataMapper");
        TrafficDataMapper trafficDataMapper = (TrafficDataMapper) applicationContext.getBean("trafficDataMapper");

        //update weather
//        List<WeatherData> weatherDatas = weatherDataMapper.selectAll();
//
//        List<Euclid> euclids = weatherDatas.stream().map(n -> {
//            Euclid euclid = new Euclid();
//            TimeSlotUtils.TimeDimension timeDimension = TimeSlotUtils.getPiece(n.getWeaterTime());
//            euclid.setDate(timeDimension.getTimestamp());
//            euclid.setTimePiece(timeDimension.getPiece());
//            euclid.setWeather(n.getWeather());
//            euclid.setPm(n.getPm());
//            euclid.setTemperature(n.getTemperature());
//            return euclid;
//        }).collect(Collectors.toList());
//
//        int i = euclidMapper.updateBatchByDate(euclids);
//        System.out.println(i);

        //update tj_level
        List<TrafficData> trafficDatas = trafficDataMapper.selectAll();
        List<Euclid> euclids = trafficDatas.stream().map(n -> {
            Euclid euclid = new Euclid();
            TimeSlotUtils.TimeDimension timeDimension = TimeSlotUtils.getPiece(n.getTrafficTime());
            euclid.setDate(timeDimension.getTimestamp());
            euclid.setTimePiece(timeDimension.getPiece());
            euclid.setStartHash(n.getDistrictHash());
            euclid.setTjLevel(n.getTjLevel());
            return euclid;
        }).collect(Collectors.toList());


        int i = euclidMapper.updateBatchByHash(euclids);
        System.out.println(i);

    }

}
