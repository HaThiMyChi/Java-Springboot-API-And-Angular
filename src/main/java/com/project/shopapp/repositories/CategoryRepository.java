package com.project.shopapp.repositories;

import com.project.shopapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// ke thua truong id la kieu Long
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
