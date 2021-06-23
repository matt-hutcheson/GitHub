package Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {
    private Commit commit;

    @Before
    public void before() {
        commit = new Commit("initial commit", "1234abcd");
    }

    @Test
    public void has_message() {
        assertEquals("initial commit", commit.getDescription());
    }
}
