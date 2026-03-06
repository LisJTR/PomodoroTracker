package com.lis.pomodoro.categories.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lis.pomodoro.categories.entity.Category;
import com.lis.pomodoro.categories.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
	
	@Mock
	private CategoryRepository categoryRepositoryFalse;
	
	@InjectMocks
	private CategoryServiceImpl categoryService;

	@Test
	void shouldCreateCategory() {
		
		Category category = new Category();
		category.setNombre("Estudiar");
		
		when(categoryRepositoryFalse.save(category)).thenReturn(category);
		
		Category RealData = categoryService.createCategories(category);
		
		assertEquals(category, RealData);
	}
	
	@Test
	void shouldGetAllCategories() {
		
		Category category1 = new Category();
		category1.setNombre("Estudiar");
		Category category2 = new Category();
		category1.setNombre("Meditar");
		
		List<Category> categories = List.of(category1,category2);
		
		when(categoryRepositoryFalse.findAll()).thenReturn(categories);
		List<Category> listData = categoryService.getAllCategories();
		
		assertEquals(categories, listData);
	}
	
	@Test
	void shouldDeleteCategory() {
		
		Long id = 1L;
		
		categoryService.deleteCategory(id);
		
		verify(categoryRepositoryFalse).deleteById(id);
		
		
	}
	
}
