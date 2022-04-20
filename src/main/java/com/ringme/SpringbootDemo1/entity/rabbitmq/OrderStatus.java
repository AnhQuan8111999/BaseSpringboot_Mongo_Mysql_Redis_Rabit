package com.ringme.SpringbootDemo1.entity.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus {

    private String status; // completed,progress
    private String message;
    private Order order;
}
