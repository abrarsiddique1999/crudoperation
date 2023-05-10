package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategoryById(int id, Category category) throws Exception {
		Category c = categoryRepo.findById(id).orElseThrow(() -> new Exception("Category Not found with Id :" + id));

		categoryRepo.delete(c);

		return categoryRepo.save(category);
	}

	@Override
	public String deleteCategoryById(int id) throws Exception {
		Category c = categoryRepo.findById(id).orElseThrow(() -> new Exception("Category Not found with Id :" + id));
		categoryRepo.delete(c);
		return "Category Deleted From Database";
	}

	@Override
	public List<Category> getAllCategory() throws Exception {
		List<Category> categories = categoryRepo.findAll();
		if (categories.isEmpty()) {
			throw new Exception("There is No Categories are Present in the DataBase ");
		}
		return categories;
	}

	@Override
	public Category getCategoryById(int id) throws Exception {

		return categoryRepo.findById(id).orElseThrow(() -> new Exception("Category Not found with Id :" + id));
	}

}
