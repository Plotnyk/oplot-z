package app.model.search.criteria;

/**
 * Filtering criteria for search branch operation
 * @author Plotnyk
 */
public class BranchCriteria {
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
    public static BranchCriteria byName(String name) {
        return new BranchCriteria(name);
    }

    public BranchCriteria() {
    }

    private BranchCriteria(final String name) {
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
