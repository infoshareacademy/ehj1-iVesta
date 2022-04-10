package pl.ergohestia.ehj1.ivesta.services;

import pl.ergohestia.ehj1.ivesta.repository.DateValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProperDateValidator implements DateValidator {

    DateTimeFormatter dateFormatter;
    public ProperDateValidator() {
        this.dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, this.dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
