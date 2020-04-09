package pl.coderslab.charity.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repositories.CategoryRepository;

import java.util.Optional;

@Component
public class CategoryConverter implements Converter<Long, Category> {
    private final CategoryRepository categoryRepository;

    public CategoryConverter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category convert(Long aLong) {

        Optional<Category> byId = categoryRepository.findById(aLong);
        return byId.get();
    }
}
