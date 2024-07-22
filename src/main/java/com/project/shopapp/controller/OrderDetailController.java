package com.project.shopapp.controller;

import com.project.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    // Them moi 1 order detail
    @PostMapping
    public ResponseEntity<?>createOrderDetail(
            @Valid @RequestBody OrderDetailDTO newOrderDetail
            ) {
        return ResponseEntity.ok("Create OrderDetail here");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getOrderDetail(
            @Valid @PathVariable("id") Long id
            ) {
        return ResponseEntity.ok("getOrderDetail with id = " +id);
    }

    // Lấy danh sách các order details của 1 order nào đó
    @GetMapping("/order/{orderId}")
    public  ResponseEntity<?>getOrderDetails(@Valid @PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok("getOrderDetails with orderId = " +orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateOrderDetail(
            @Valid @PathVariable("id") Long id,
            @RequestBody OrderDetailDTO newOrderDetailData
    ) {
        return ResponseEntity.ok("UpdateOrderDetail with id = " +id
                + ", newOrderDetailData: " + newOrderDetailData);
    }

    @DeleteMapping("/{id}")
    // Khi bạn sử dụng ResponseEntity<Void>, điều này có nghĩa là API sẽ không trả về nội dung trong phần body của HTTP response,
    // mà chỉ trả về một mã trạng thái HTTP
    public ResponseEntity<Void>deleteOrderDetail(
            @Valid @PathVariable("id") Long id
    ) {
        return ResponseEntity.noContent().build();
    }

}
