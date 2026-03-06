package com.lis.pomodoro.categories.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lis.pomodoro.categories.entity.Category;
import com.lis.pomodoro.categories.repositories.CategoryRepository;
import com.lis.pomodoro.categories.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category createCategories(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}

	

	

}
