package br.com.movierflix.mapper;

import br.com.movierflix.entity.Category;
import br.com.movierflix.request.CategoryRequest;
import br.com.movierflix.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();

    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }
}
