package movie.movieService.model;

import movie.movieService.model.category.Category;


public class MovieModel {
    private Long id;
    private String name;
    private Enum<Category> categoryEnum;

    public MovieModel(Long id, String name, Enum<Category> categoryEnum) {
        this.id = id;
        this.name = name;
        this.categoryEnum = categoryEnum;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Enum<Category> getCategoryEnum() {
        return categoryEnum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryEnum(Enum<Category> categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
