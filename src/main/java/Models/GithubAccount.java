package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class GithubAccount {
    private String username;
    private String name;
    private HashMap<String, Repository> repositories;
    private AccountType accountType;

    public GithubAccount(String username, String name) {
        this.username = username;
        this.name = name;
        this.repositories = new HashMap<>();
        this.accountType = AccountType.FREE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Repository> getRepositories() {
        return repositories;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void upgrade() {
        this.accountType = AccountType.PRO;
    }

    public void downgrade() {
        this.accountType = AccountType.FREE;
    }

    public void addRepository(Repository repository) {
        this.repositories.put(repository.getName(), repository);
    }

    public Repository getRepositoryByName(String name) {
        return this.repositories.get(name);
    }

    public Repository getRepoWithHighestCommitCount() {
        Repository highestRepo = null;
        int max = -1;
        for (Repository repository : this.repositories.values()) {
            if (repository.getNoOfCommits() > max) {
                highestRepo = repository;
                max = repository.getNoOfCommits();
            }
        }
        return highestRepo;
    }
}
