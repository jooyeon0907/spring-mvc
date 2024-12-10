package com.example.WebSample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {



    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id){
        log.info("Get some order");
        return "orderId:" + id + ", orderAmount:1000";
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id){
        log.info("Delete some order");
        return "Delete orderId:" + id;
    }

    @GetMapping("/order")
    public String getOrderWithRequestParam(
            @RequestParam(value = "orderId", required = false, defaultValue = "defaultId") String id,
            @RequestParam("orderAmount") Integer amount){
        log.info("Get some order");
        return "orderId:" + id + ", orderAmount:" + amount;
    }

    @PutMapping("/order")
    public String createOrder(){
        log.info("Create order");
        return "order created -> orderId:2, orderAmount:1000";
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader("userAccountId") String userAccountId){
        log.info("Create order : " + createOrderRequest +
                ", amount : " + userAccountId);
        return "orderId:" + createOrderRequest.getOrderId() +
                ", orderAmount:" + createOrderRequest.getOrderAmount();
    }

    @Data
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;
    }


}
