package uz.coding.appwarhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.coding.appwarhouse.entity.Category;
import uz.coding.appwarhouse.payload.ApiResponse;
import uz.coding.appwarhouse.payload.CategoryDto;
import uz.coding.appwarhouse.service.CategoryService;

import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/add")
    public ApiResponse addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public ApiResponse editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return categoryService.editCategory(id, categoryDto);
    }

    @GetMapping("/parentnull")
    public List<Category> getCategory(){
        return categoryService.getParentIdNull();
    }

    @GetMapping("/{id}")
    public Category getByIdCategory(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deletedCategory(@PathVariable Integer id){
        return categoryService.deletedCategory(id);
    }
}
