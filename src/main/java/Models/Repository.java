package Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Repository {
    private String name;
    private String description;
    private RepositoryType repositoryType;
    private ArrayList<Commit> commits;

    public Repository(String name, String description, RepositoryType repositoryType) {
        this.name = name;
        this.description = description;
        this.repositoryType = repositoryType;
        this.commits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(RepositoryType repositoryType) {
        this.repositoryType = repositoryType;
    }

    public void addCommit(Commit commit) {
        this.commits.add(commit);
    }

    public int getNoOfCommits() {
        return this.commits.size();
    }

    public Commit getCommitById(String id) {
        for (Commit commit : this.commits) {
            if (commit.getUniqueId().equals(id)) {
                return commit;
            }
        }
        return null;
    }

    public void rollBack(String commitId) {
        if (this.getCommitById(commitId) != null) {
            int index = this.commits.indexOf(this.getCommitById(commitId));
            this.commits = new ArrayList<>(this.commits.subList(0, index +1));
        }
    }
}
