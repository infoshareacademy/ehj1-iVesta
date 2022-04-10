package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.repository.DateValidator;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProperDateValidatorTest {

    private final ProperDateValidator sut = new ProperDateValidator();


    @Test
    void shouldIsValid() {
        // given
        DateValidator validator = new ProperDateValidator();

        // when

        // then
        assertTrue(validator.isValid("20190228"));
        assertFalse(validator.isValid("20190230"));

    }
}