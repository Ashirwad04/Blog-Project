package Blog.Project.services;

import Blog.Project.paylods.CategoryDto;

import java.util.List;

public interface CategoryService {


    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update

    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete


    public void deleteCategory(Integer categoryId);


    //get by id

    public CategoryDto getCategoryById(Integer categoryId);



    //get all
    public List<CategoryDto> getCategories();
}
