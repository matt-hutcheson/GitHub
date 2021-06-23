package Models;

public class Commit {
    private String description;
    private String uniqueId;

    public Commit(String description, String uniqueId) {
        this.description = description;
        this.uniqueId = uniqueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
