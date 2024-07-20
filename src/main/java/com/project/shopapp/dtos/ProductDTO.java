package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data // toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    @NotBlank(message = "Title is required")

    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    private String name;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Max(value = 10000000, message = "Price must be less than or equal to 10,000,000")
    private Float price;

    private String thumbnail;

    private String description;

    @JsonProperty("category_id")
//    boi vi ben database no ten category_id, ma ben java thi ko cho tao bien co dau _ (neu ten field khong giong
//        voi field o database thi khai bao JsonProperty, con neu giong thi khoi can
    private String categoryID;

    private List<MultipartFile> files;
}
