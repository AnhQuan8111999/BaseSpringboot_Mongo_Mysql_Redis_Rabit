package com.ringme.SpringbootDemo1.controller;

import com.ringme.SpringbootDemo1.cofiguration.RabbitmqConfig;
import com.ringme.SpringbootDemo1.entity.rabbitmq.Order;
import com.ringme.SpringbootDemo1.entity.rabbitmq.OrderStatus;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class RabbitmqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static Logger logger= Logger.getLogger(RabbitmqController.class);
    @PostMapping("/")
    public String bookOrder(@RequestBody Order order){
        OrderStatus orderStatus=new OrderStatus("process","order successfull in" ,order);
        logger.info("input:"+ orderStatus);
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE,RabbitmqConfig.ROUTING_KEY,orderStatus);
        return "success !";
    }
}
