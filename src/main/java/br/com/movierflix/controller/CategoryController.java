package br.com.movierflix.controller;

import br.com.movierflix.dto.CategoryDTO;
import br.com.movierflix.entity.Category;
import br.com.movierflix.response.CategoryResponse;
import br.com.movierflix.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("movierflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryResponse> getAllCategories() {
        return this.categoryService.findAll();
    }

    @PostMapping()
    public CategoryResponse createCategory(@RequestBody  Category categoryToAdd) {
        return this.categoryService.create(categoryToAdd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> category = this.categoryService.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
       if (this.categoryService.findById(id).isPresent()) {
           this.categoryService.deleteById(id);
           return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso!");
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
    }


}
