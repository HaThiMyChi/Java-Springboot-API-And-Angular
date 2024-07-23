package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    // id la khoa chinh va tự tăng lên 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id") // Neu no trung voi table thi thoi khoi can, con neu ko giong thi can
    private Long id;

    @Column(name="name", nullable = false)
    private String name;
}
