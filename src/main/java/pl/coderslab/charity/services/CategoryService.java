package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> allCategory(){
        List<CategoryDto> categories = new ArrayList<>();
        List<Category> all = categoryRepository.findAll();
        for (Category category:all){
            CategoryDto categoryDto = toDto(category);
            categories.add(categoryDto);
        }
        return categories;
    }
    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setId(category.getId());
        return categoryDto;
    }
}
