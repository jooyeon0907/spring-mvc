package com.example.WebSample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/order/1")
    public String getOrder(){
        log.info("Get some order");
        return "orderId:2, orderAmount:1000";
    }

    @PostMapping("/order")
    public String createOrder(){
        log.info("Create order");
        return "order created -> orderId:2, orderAmount:1000";
    }
}
