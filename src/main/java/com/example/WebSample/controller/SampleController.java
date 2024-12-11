package com.example.WebSample.controller;

import com.example.WebSample.dto.ErrorResponse;
import com.example.WebSample.exception.ErroCode;
import com.example.WebSample.exception.WebSampleException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestController // 웹에서 요청이 들어오는 것을 받아주기위해 @RestController 어노테이션 추가
public class SampleController {

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        log.info("Get some order : "  +id);

        if ("500".equals(id)) {
            throw new WebSampleException
					(ErroCode.TOO_BIG_ID_ERROR,
					"500 is not valid order Id");
        }

        if ("3".equals(id)) {
            throw new WebSampleException
					(ErroCode.TOO_SMALL_ID_ERROR,
					"3 is not valid order Id");
        }

        if ("4".equals(id)) {
            throw new SQLIntegrityConstraintViolationException(
					"Duplicated insertion was tired."
			);
        }

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
        log.info("getOrderWithRequestParam");
        return "orderId:" + id + ", orderAmount:" + amount;
    }

    @PutMapping("/order")
    public String createOrder(){
        log.info("Put Create order");
        return "order created -> orderId:2, orderAmount:1000";
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader("userAccountId") String userAccountId){
        log.info("Post Create order : " + createOrderRequest +
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
