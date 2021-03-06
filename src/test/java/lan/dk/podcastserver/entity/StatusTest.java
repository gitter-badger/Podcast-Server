package lan.dk.podcastserver.entity;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kevin on 14/06/15 for HackerRank problem
 */
public class StatusTest {

    @Test
    public void should_check_value() {
        /* Given */ String nd = "Not Downloaded", other = "Other";
        /* When */  Boolean isSame = Status.NOT_DOWNLOADED.is(nd), isNotSame = Status.NOT_DOWNLOADED.is(other);
        /* Then */
            assertThat(isSame).isTrue();
            assertThat(isNotSame).isFalse();
    }
    
    @Test
    public void should_find_byValue() {
        assertThat(Status.byValue("Not Downloaded"))
                .isNotNull()
                .isEqualTo(Status.NOT_DOWNLOADED);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_raised_exception_if_not_found() {
        Status.byValue("_");
    }

}