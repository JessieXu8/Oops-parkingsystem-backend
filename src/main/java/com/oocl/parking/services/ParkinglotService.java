package com.oocl.parking.services;

import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Orders;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.repositories.OrderRepository;
import com.oocl.parking.repositories.ParkinglotRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("parkinglotService")
public class ParkinglotService {


    private ParkinglotRepository parkinglotRepository;

    @Autowired
    private OrderRepository orderRepository;

    private static Logger logger = Logger.getLogger(ParkinglotService.class);

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository){
        this.parkinglotRepository = parkinglotRepository;
    }


    public List<ParkinglotDto> getAllParkinglots(Pageable page, String status) {
        if(status != null)
            return parkinglotRepository.findByStatus(page, status).stream()
                    .map(ParkinglotDto::new).collect(Collectors.toList());

        return parkinglotRepository.findAll(page)
                .stream().map(ParkinglotDto::new).collect(Collectors.toList());
    }


    public ParkinglotDto save(Parkinglot parkinglot) {
        if(parkinglot.getId() != null || parkinglotRepository.findByName(parkinglot.getName()).orElse(null) != null)
            return null;
        parkinglotRepository.save(parkinglot);
        return new ParkinglotDto(parkinglot);
    }


    public ParkinglotDto getById(long id) {
        Parkinglot parkinglot = parkinglotRepository.findById(id).orElse(null);
        if(parkinglot == null){
            return null;
        }
        return new ParkinglotDto(parkinglot);
    }


    public boolean changeStatusById(Long id) {
        Parkinglot parkinglot = parkinglotRepository.findById(id).orElse(null);
        if(parkinglot == null || !parkinglot.isEmpty() || parkinglot.getUser() != null){
            return false;
        }
        String status = "";
        if(parkinglot.getStatus().equals("open")) {
            status = "logout";
//            parkinglot.setStatus("logout");
        }else{
            status = "open";
//            parkinglot.setStatus("open");
        }
        parkinglotRepository.changeStatus(id, status);//save(parkinglot);
        return true;
    }

    public ParkinglotDto park(Long id) {
        logger.info("parkinglot id:"+id);
        Parkinglot parkinglot = parkinglotRepository.findById(id).orElse(null);
        logger.info("before parking car parkinglot id:"+parkinglot.getId()+"parkinglot name"+parkinglot.getName()+"parkinglot carCount"+parkinglot.getCountOfCars());
        logger.info("parkinglot size:"+parkinglot.getSize());
        if(parkinglot == null || parkinglot.isFull()){
            logger.info("parkinglot is full:");
           return null;
        }
        parkinglot.park();
//        orderRepository
        Parkinglot save = parkinglotRepository.save(parkinglot);
        logger.info("after parking car parkinglot id:"+save.getId()+"parkinglot name"+save.getName()+"parkinglot carCount"+save.getCountOfCars());
        logger.info("parkinglot size:"+save.getSize());
        return new ParkinglotDto(save);
    }

    public boolean unpark(Long id, Long parkingLotId) {
        Parkinglot parkinglot = parkinglotRepository.findById(parkingLotId).orElse(null);

        if(parkinglot == null || parkinglot.isEmpty()){
            throw new BadRequestException("停车场为空");
        }
        logger.info("before order parkinglot countof car:"+parkinglot.getCountOfCars());
        parkinglot.unpark();
        Orders order = orderRepository.findById(id).get();
        order.setStatus("订单完成");
        orderRepository.save(order);
        parkinglotRepository.save(parkinglot);
        return true;
    }

    public List<ParkinglotDto> getDashboard(Pageable page, String status) {

        return parkinglotRepository.findByStatusAndUserNotNull(page, status).stream()
                .map(ParkinglotDto::new).collect(Collectors.toList());
    }

    public ParkinglotDto changeNameById(Long id, String name, int size) {
        Parkinglot parkinglot =parkinglotRepository.findById(id).orElse(null);
        if(parkinglot == null || (parkinglot.getSize() != size && !parkinglot.isEmpty())){
            return null;
        }
        Parkinglot p = parkinglotRepository.findByName(name).orElse(null    );
        if( p!=null && p.getId().equals(id)){
            throw new BadRequestException("停车场名称不能重复");
        }
        parkinglotRepository.changeNameAndSizeById(id, size, name);
        parkinglot = parkinglotRepository.findById(id).get();
        return new ParkinglotDto(parkinglot);
    }

    public List<ParkinglotDto> getNoUserParkinglots(Pageable page, String status) {
        return parkinglotRepository.findAllByStatusAndUserNull(status, page)
                .stream().map(ParkinglotDto::new).collect(Collectors.toList());
    }

    public List<ParkinglotDto> getPakinglotsCombineSearch(Pageable page, String name, String tel, int bt, int st) {
        return parkinglotRepository.findAllBySizeGreaterThanEqual(page, bt)
                .stream().filter(parkinglot ->
                    (matchName(parkinglot, name) && matchTel(parkinglot, tel)) && parkinglot.getSize()<st
                ).map(ParkinglotDto::new).collect(Collectors.toList());
    }

    private boolean matchName(Parkinglot parkinglot, String name){
        return name == null || parkinglot.getName().equals(name);
    }
    private boolean matchTel(Parkinglot parkinglot, String tel){
        return tel == null || parkinglot.getUser().getPhone().equals(tel);
    }

    public List<Orders> getOrdersByLotId(Long id) {
        return orderRepository.findAllByParkinglotId(id).stream().filter(order->
            order.getParkinglotId() != null
                    && order.getType().equals("存车")
                    && order.getStatus().equals("停取中")
        ).collect(Collectors.toList());

    }
}
