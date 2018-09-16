package app.rest.dao;


//import org.springframework.stereotype.Component;
import app.rest.model.AppCategory;

import java.util.ArrayList;
import java.util.List;

//@Component
public class AppCategoriesDao {

    private static List<AppCategory> categories;

    {
        categories = new ArrayList<>();
        categories.add(new AppCategory(1L, "Games"));
        categories.add(new AppCategory(2L, "Multimedia"));
        categories.add(new AppCategory(3L, "Productivity"));
        categories.add(new AppCategory(4L, "Tools"));
        categories.add(new AppCategory(5L, "Health"));
        categories.add(new AppCategory(6L, "Lifestyle"));
    }

    public List<AppCategory> list() {
        return categories;
    }

    public AppCategory get(Long id) {

        for (AppCategory c : categories) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public AppCategory create(AppCategory category) {
        category.setId(System.currentTimeMillis());
        categories.add(category);
        return category;
    }

    public Long delete(Long id) {

        for (AppCategory c : categories) {
            if (c.getId().equals(id)) {
                categories.remove(c);
                return id;
            }
        }

        return null;
    }

    public AppCategory update(AppCategory updatedCategory) {

        for (AppCategory appCategory : categories) {
            if (appCategory.getId().equals(updatedCategory.getId())) {
                categories.remove(appCategory);
                categories.add(updatedCategory);
                return updatedCategory;
            }
        }

        return null;
    }

}
