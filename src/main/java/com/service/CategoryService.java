package com.service;

import java.util.List;

import com.entity.Category;

public interface CategoryService {

	Category addCategory(Category category);

	Category updateCategoryById(int id, Category category) throws Exception;

	String deleteCategoryById(int id) throws Exception;

	List<Category> getAllCategory() throws Exception;

	Category getCategoryById(int id) throws Exception;

}
