package com.project.shopapp.controller;

import com.project.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated
public class CategoryController {
    // Hien thi tat ca cac categories
    @GetMapping("") //http://localhost:8088/api/v1/categories?page=1&limit=10
    // Nếu tham số truyền vào là 1 object thì sao ? =>Data Transfer object = Request object
    public ResponseEntity<String>getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("getAllCategories, page = %d, limit = %d", page, limit));
    }


    @PostMapping("")
    // ? truyen vao no nhan kieu string hay list... do o duoi minh muon tra ve nhan ca kieu string va  list
    public ResponseEntity<?>insertCategories(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) {
        if(result.hasErrors()) {
            List<String> errorMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();

            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok("This is category " +categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updateCategories(@PathVariable long id) {
        return ResponseEntity.ok("Insert category width id = "+id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCategories(@PathVariable long id) {
        return ResponseEntity.ok("Delete category width id = "+id);
    }
}
