package app.model.search.criteria;

/**
 * Filtering criteria for search company operation
 * @author Plotnyk
 */
public class CompanyCriteria {
    /**
     * Branch name
     */
    private String name;

    /**
     * Station's address: street, zipCode, building number
     */
    private String address;

    /**
     * Returns filtering criteria to search company that
     * contains specified name parameter
     * @param name
     * @return
     */
    public static CompanyCriteria byName(String name) {
        return new CompanyCriteria(name);
    }

    public CompanyCriteria() {
    }

    private CompanyCriteria(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
