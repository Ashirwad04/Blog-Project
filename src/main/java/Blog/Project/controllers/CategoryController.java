package Blog.Project.controllers;


import Blog.Project.paylods.ApiResponse;
import Blog.Project.paylods.CategoryDto;
import Blog.Project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto category){
        CategoryDto createCategory = this.categoryService.createCategory(category);

        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }


    //update

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid  @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);

        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //delete

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully",true),HttpStatus.OK);
    }



    //get by id
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getByIdCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryService.getCategoryById(catId);

        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }


    //get all

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
       List<CategoryDto> categories=  this.categoryService.getCategories();
       return ResponseEntity.ok(categories);

    }









}
