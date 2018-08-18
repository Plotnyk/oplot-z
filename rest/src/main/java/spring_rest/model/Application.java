package spring_rest.model;

/**
 * Application that fits into some AppCategory
 */
public class Application {

    private Long id;
    private Long categoryId;
    private String name;
    private String packageName;
    private String picture128name;
    private String picture512name;

    public Application(Long id, Long categoryId, String name, String packageName, String picture128name, String picture512name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.packageName = packageName;
        this.picture128name = picture128name;
        this.picture512name = picture512name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPicture128name() {
        return picture128name;
    }

    public void setPicture128name(String picture128name) {
        this.picture128name = picture128name;
    }

    public String getPicture512name() {
        return picture512name;
    }

    public void setPicture512name(String picture512name) {
        this.picture512name = picture512name;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", picture128name='" + picture128name + '\'' +
                ", picture512name='" + picture512name + '\'' +
                '}';
    }
}
