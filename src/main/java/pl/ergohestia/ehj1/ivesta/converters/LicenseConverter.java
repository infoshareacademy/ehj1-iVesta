package pl.ergohestia.ehj1.ivesta.converters;

import pl.ergohestia.ehj1.ivesta.model.LicenseType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LicenseConverter implements AttributeConverter<LicenseType, String> {
    @Override
    public String convertToDatabaseColumn(LicenseType licenseType) {
        if (licenseType == null)
            return null;

        return switch (licenseType) {
            case B_E -> "B+E";
            case C1_E -> "C1+E";
            case C_E -> "C+E";
            case D_E -> "D+E";
            case D1_E -> "D1+E";
            default -> null;
        };

    }

    @Override
    public LicenseType convertToEntityAttribute(String s) {
        if (s == null)
            return null;
        return switch (s) {
            case "B+E" -> LicenseType.B_E;
            case "C1+E" -> LicenseType.C1_E;
            case "C+E" -> LicenseType.C_E;
            case "D+E" -> LicenseType.D_E;
            case "D1_E" -> LicenseType.D1_E;
            default -> null;

        };
    }
}
