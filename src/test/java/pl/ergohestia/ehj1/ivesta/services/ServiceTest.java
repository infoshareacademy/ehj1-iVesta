package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void shouldCheckIfStringIsNumeric() {
        //given
        String testString = "test";
        String testString1 = null;
        String testString2 = "12345";
        //then

        //when
        assertThat(Service.isNumeric(testString)).isFalse();
        assertThat(Service.isNumeric(testString1)).isFalse();
        assertThat(Service.isNumeric(testString2)).isTrue();
    }
}