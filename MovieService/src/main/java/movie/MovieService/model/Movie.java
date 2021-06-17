package movie.movieService.model;


import movie.movieService.model.category.Category;
import org.springframework.lang.NonNull;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private Long id;

    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NonNull
    private boolean isAvailable = false;

    public Movie(Long id, String title, Category category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;

        this.isAvailable=isAvailable;
    }


    public Movie() {

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(boolean b) {
        this.isAvailable=b;
    }
    public boolean getAvailable(){
        return isAvailable;
    }
}