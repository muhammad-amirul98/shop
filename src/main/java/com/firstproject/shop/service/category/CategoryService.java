package com.firstproject.shop.service.category;

import com.firstproject.shop.exceptions.CategoryNotFoundException;
import com.firstproject.shop.model.Category;
import com.firstproject.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    final private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).
                orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id).
                ifPresentOrElse(categoryRepository::delete, () -> {
                    throw new CategoryNotFoundException("Category Not Found!");
                }
                );
    }
}
