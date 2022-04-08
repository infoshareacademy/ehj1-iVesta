package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.repository.DateValidator;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateValidatorUsingLocalDateTest {

    private DateValidatorUsingLocalDate sut = new DateValidatorUsingLocalDate(DateTimeFormatter.BASIC_ISO_DATE);


    @Test
    void shouldIsValid() {
        // given
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

        // when

        // then
        assertTrue(validator.isValid("20190228"));
        assertFalse(validator.isValid("20190230"));

    }
}