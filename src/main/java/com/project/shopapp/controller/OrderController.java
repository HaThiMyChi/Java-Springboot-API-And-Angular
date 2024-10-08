package com.project.shopapp.controller;


import com.project.shopapp.dtos.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders") // bien nay duoc dat trong bien moi truong cho de quan ly trong file application.yml
public class OrderController {
    @PostMapping("")
    public ResponseEntity<?>createOrder(@Valid @RequestBody OrderDTO orderDTO,
        BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String>errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok("CreateOrder successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}") // Thêm biến đường dẫn "user_id"
    // GET http://localhost:9005/api/v1/orders/4
    public ResponseEntity<?>getOrders(@Valid @PathVariable("user_id") Long userID) {
        try {
            return ResponseEntity.ok("Lay ra danh sach order tu user_id");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    // GET http://localhost:9005/api/v1/orders/2
    // Cong viec cua admin
    public ResponseEntity<?>updateOrder(
            @Valid @PathVariable long id,
            @Valid @RequestBody OrderDTO orderDTO
    ) {
        return ResponseEntity.ok("Cap nhat thong tin 1 order");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteOrder(@Valid @PathVariable Long id) {
        // xoa mem => cap nhat truong active = false
        return ResponseEntity.ok("Order deleted successfully.");
    }
}
