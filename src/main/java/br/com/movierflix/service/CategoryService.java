package br.com.movierflix.service;

import br.com.movierflix.entity.Category;
import br.com.movierflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(Category newCategory) {
        return this.categoryRepository.save(newCategory);
    }

    public Optional<Category> findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    public void deleteById(Long id) {
         this.categoryRepository.deleteById(id);
    }
}
