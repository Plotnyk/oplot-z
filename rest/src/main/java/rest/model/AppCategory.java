package rest.model;

/**
 * Application category.
 * For example: Games, Multimedia, Productivity, Tools, Health, Lifestyle, etc
 */
public class AppCategory {

    private Long id;
    private String name;

    public AppCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AppCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
