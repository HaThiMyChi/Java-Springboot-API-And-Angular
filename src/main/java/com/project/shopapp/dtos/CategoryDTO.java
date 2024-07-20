package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

// @Data nó đoc data ra vì nó private trường name, nó giống setter, getter
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    // Truong ID tu sinh duoi database
    // truong nay khong duoc de trong
    @NotEmpty(message = "Category's name cannot be empty")
    private String name;
}
