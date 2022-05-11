package pl.ergohestia.ehj1.ivesta.converters;

import pl.ergohestia.ehj1.ivesta.model.LicenseType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LicenseHibernateConverter implements AttributeConverter<LicenseType, String> {
    @Override
    public String convertToDatabaseColumn(LicenseType licenseType) {
        if (licenseType == null)
            return null;
        return switch (licenseType) {
            case A -> "A";
            case B -> "B";
            case C -> "C";
            case D -> "D";
            case A1 -> "A1";
            case B1 -> "B1";
            case C1 -> "C1";
            case D1 -> "D1";
            case B_E -> "B+E";
            case C_E -> "C+E";
            case D_E -> "D+E";
            case C1_E -> "C1+E";
            case D1_E -> "D1+E";
            default -> null;
        };
    }

    @Override
    public LicenseType convertToEntityAttribute(String s) {
        if (s == null)
            return null;
        return switch (s) {
            case "A" -> LicenseType.A;
            case "B" -> LicenseType.B;
            case "C" -> LicenseType.C;
            case "D" -> LicenseType.D;
            case "A1" -> LicenseType.A1;
            case "B1" -> LicenseType.B1;
            case "C1" -> LicenseType.C1;
            case "D1" -> LicenseType.D1;
            case "A2" -> LicenseType.A2;
            case "AM" -> LicenseType.AM;
            case "B+E" -> LicenseType.B_E;
            case "C+E" -> LicenseType.C_E;
            case "D+E" -> LicenseType.D_E;
            case "C1+E" -> LicenseType.C1_E;
            case "D1+E" -> LicenseType.D1_E;
            default -> null;
        };
    }
}
