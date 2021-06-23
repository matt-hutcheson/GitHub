package Models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GithubAccountTest {
    private GithubAccount account;
    private Repository repository;

    @Before
    public void before() {
        account = new GithubAccount("Handsome Bob", "BobsHub");
        repository = new Repository("TestRepo", "Test Repository", RepositoryType.PUBLIC);
        account.addRepository(repository);
    }

    @Test
    public void hasUsername() {
        assertEquals("Handsome Bob", account.getUsername());
    }

    @Test
    public void hasName() {
        assertEquals("BobsHub", account.getName());
    }

    @Test
    public void hasType() {
        assertEquals(AccountType.FREE, account.getAccountType());
    }

    @Test
    public void canSetUsername() {
        assertEquals("Handsome Bob", account.getUsername());
        account.setUsername("Ugly Bob");
        assertEquals("Ugly Bob", account.getUsername());
    }

    @Test
    public void canSetName() {
        assertEquals("BobsHub", account.getName());
        account.setName("RobertsHub");
        assertEquals("RobertsHub", account.getName());
    }

    @Test
    public void canUpgrade() {
        assertEquals(AccountType.FREE, account.getAccountType());
        account.upgrade();
        assertEquals(AccountType.PRO, account.getAccountType());
    }

    @Test
    public void canDowngrade() {
        account.upgrade();
        assertEquals(AccountType.PRO, account.getAccountType());
        account.downgrade();
        assertEquals(AccountType.FREE, account.getAccountType());
    }

    @Test
    public void canGetRepositories() {
        HashMap<String, Repository> testHash = new HashMap<>();
        testHash.put(repository.getName(), repository);
        assertEquals(testHash, account.getRepositories());
    }

    @Test
    public void canGetRepositoryByName() {
        assertEquals(repository, account.getRepositoryByName("TestRepo"));
    }

    @Test
    public void canGetHighestCommitRepo() {
        Commit commit = new Commit("Test commit", "12345mv");
        repository.addCommit(commit);
        Repository repository2 = new Repository("testRepo2", "test repo 2", RepositoryType.PUBLIC);
        repository2.addCommit(commit);
        repository2.addCommit(commit);
        repository2.addCommit(commit);
        account.addRepository(repository2);
        assertEquals(account.getRepoWithHighestCommitCount(), repository2);
    }
}
