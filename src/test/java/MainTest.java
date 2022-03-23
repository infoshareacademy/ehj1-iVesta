import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.Main;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    private Main sut;

    @Test
    void shouldReturnTrue() {
        // given

        // when
        boolean result = true;
        // then
        assertThat(result).isTrue();
    }
}