package com.example.comsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String orderTopic = "t.drink.order";

    private final ObjectMapper objectMapper;
    private final OrderService foodOrderService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, OrderService foodOrderService) {
        this.objectMapper = objectMapper;
        this.foodOrderService = foodOrderService;
    }

    @KafkaListener(topics = orderTopic,groupId = "default")
    public void consumeMessage(String message) throws JsonProcessingException {
        System.out.println(message);
        OrderDto foodOrderDto = objectMapper.readValue(message, OrderDto.class);
        foodOrderService.persistFoodOrder(foodOrderDto);
    }

}
