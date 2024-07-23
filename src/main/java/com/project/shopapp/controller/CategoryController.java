package com.project.shopapp.controller;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated

@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("")
    // ? truyen vao no nhan kieu string hay list... do o duoi minh muon tra ve nhan ca kieu string va  list
    public ResponseEntity<?>createCategories(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) {
        if(result.hasErrors()) {
            List<String> errorMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();

            return ResponseEntity.badRequest().body(errorMessage);
        }
        categoryService.createCategory(categoryDTO);

//        return ResponseEntity.ok("This is category " +categoryDTO);
        return ResponseEntity.ok("Insert category successfully");
    }

    // Hien thi tat ca cac categories
    @GetMapping("") //http://localhost:8088/api/v1/categories?page=1&limit=10
    // Nếu tham số truyền vào là 1 object thì sao ? =>Data Transfer object = Request object
    public ResponseEntity<List<Category>>getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        List<Category> categories = categoryService.getAllCategories();
//        return ResponseEntity.ok(String.format("getAllCategories, page = %d, limit = %d", page, limit));
        return ResponseEntity.ok(categories);
    }



    @PutMapping("/{id}")
    public ResponseEntity<String>updateCategories(@PathVariable Long id,
                                                  @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok("Update category successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCategories(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category width id = "+ id + "successfully");
    }
}
