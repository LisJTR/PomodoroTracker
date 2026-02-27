package com.lis.pomodoro.categories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lis.pomodoro.categories.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
