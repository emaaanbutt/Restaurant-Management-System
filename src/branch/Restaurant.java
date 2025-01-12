package branch;


import java.util.List;



// Restaurant1 class
public class Restaurant {
    private String name;
    private List<Branch> branches;

    public Restaurant()
    {

    }
    public Restaurant(String name,  List<Branch> branches) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }


        if (branches == null || branches.isEmpty()) {
            throw new IllegalArgumentException("Branches cannot be null or empty");
        }


        this.name = name;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }


    public List<Branch> getBranches() {
        return branches;
    }

    public void addBranch(Branch branch) {

        if (branch == null) {
            throw new IllegalArgumentException("Branch cannot be null");
        }
        this.branches.add(branch);
    }
}
