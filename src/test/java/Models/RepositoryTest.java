package Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {
    private Repository repository;
    private Commit testCommit;
    private Commit testCommit2;

    @Before
    public void before() {
        repository = new Repository("Blackjack", "Card game", RepositoryType.PUBLIC);
        testCommit = new Commit("initial commit", "1234abcd");
        testCommit2 = new Commit("setup framework", "4321dcba");
        repository.addCommit(testCommit);
        repository.addCommit(testCommit2);
    }

    @Test
    public void hasName() {
        assertEquals("Blackjack", repository.getName());
    }

    @Test
    public void canSetName() {
        assertEquals("Blackjack", repository.getName());
        repository.setName("Poker");
        assertEquals("Poker", repository.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals("Card game", repository.getDescription());
    }

    @Test
    public void canSetDescription() {
        assertEquals("Card game", repository.getDescription());
        repository.setDescription("Card Shark");
        assertEquals("Card Shark", repository.getDescription());
    }

    @Test
    public void hasType() {
        assertEquals(RepositoryType.PUBLIC, repository.getRepositoryType());
    }

    @Test
    public void canSetType() {
        assertEquals(RepositoryType.PUBLIC, repository.getRepositoryType());
        repository.setRepositoryType(RepositoryType.PRIVATE);
        assertEquals(RepositoryType.PRIVATE, repository.getRepositoryType());
    }

    @Test
    public void canFindCommitById() {
        assertEquals(testCommit, repository.getCommitById("1234abcd"));
    }

    @Test
    public void commitsStartsEmpty() {
        Repository testRepository = new Repository("Test", "TestRepo", RepositoryType.PUBLIC);
        assertEquals(0, testRepository.getNoOfCommits());
    }

    @Test
    public void canAddCommits() {
        Repository testRepository = new Repository("Test", "TestRepo", RepositoryType.PUBLIC);
        testRepository.addCommit(testCommit2);
        assertEquals(1, testRepository.getNoOfCommits());
    }
}
