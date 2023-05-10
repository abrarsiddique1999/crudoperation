package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Category;
import com.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories/all")
	public ResponseEntity<List<Category>> getAllCategories() throws Exception {
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@PostMapping("/categories")
	public ResponseEntity<Category> addCategories(@RequestBody Category category) throws Exception {
		return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoriesById(@PathVariable int id) throws Exception {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategories(@PathVariable int id, @RequestBody Category category)
			throws Exception {
		return new ResponseEntity<Category>(categoryService.updateCategoryById(id, category), HttpStatus.OK);
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteCategories(@PathVariable int id) throws Exception {
		return new ResponseEntity<String>(categoryService.deleteCategoryById(id), HttpStatus.OK);
	}

}
