package com.project.shopapp.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 350)
    private String name;

    private Float price;

    // nullable = true ko yeu cau phai nhap ngay kieu no dc de null, mac dinh de true roi nen ko can de
    @Column(name="thumbnail", length = 300)
    private String thumbnail;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
