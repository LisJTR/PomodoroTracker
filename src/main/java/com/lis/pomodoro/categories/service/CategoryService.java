package com.lis.pomodoro.categories.service;

import java.util.List;

import com.lis.pomodoro.categories.entity.Category;

public interface CategoryService {

	Category createCategories(Category category);
	List<Category> getAllCategories();
	void deleteCategory(Long id);
	
}
