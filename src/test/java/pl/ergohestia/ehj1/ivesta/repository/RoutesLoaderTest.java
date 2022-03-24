package pl.ergohestia.ehj1.ivesta.repository;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.Route;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoutesLoaderTest {

    private RoutesLoader sut = new RoutesLoader();
    private static final Path TEST_PATH = Path.of(("src/test/resources/testRoutes.csv"));

    @Test
    void shouldGetListOfRoutesFromCSV() {
        // given

        // when
        List<Route> result = sut.getListOfRoutesFromCSV(TEST_PATH);
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getDestinationCity()).isEqualTo("Gdańsk");

    }
}