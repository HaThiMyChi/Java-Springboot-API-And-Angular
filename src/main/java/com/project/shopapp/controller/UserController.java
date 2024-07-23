package com.project.shopapp.controller;

import com.project.shopapp.services.IUserService;
import com.project.shopapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.project.shopapp.dtos.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/users")

public class UserController {
    private final IUserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO,
                                        BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }
            if(!userDTO.getPassword().equals(userDTO.getRetypePassword())) {
                return ResponseEntity.badRequest().body("Password does not match!");
            }
            userService.createUser(userDTO);
            return ResponseEntity.ok("Register successfully!");
        } catch(Exception e) {
            // Hai cai nay giong nhau
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(
            @Valid @RequestBody UserLoginDTO userLoginDTO
    ) {
        // Kiem tra thong tin dang nhap va sinh token
        // Tra ve token trong response
        String token = userService.login(userLoginDTO.getPhoneNumber(), userLoginDTO.getPassword());
//        return ResponseEntity.ok("Some token");
        return ResponseEntity.ok(token);
    }

}
