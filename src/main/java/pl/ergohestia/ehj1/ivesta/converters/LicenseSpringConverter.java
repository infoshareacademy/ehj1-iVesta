package pl.ergohestia.ehj1.ivesta.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.ergohestia.ehj1.ivesta.exception.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;



@Component
@ConfigurationPropertiesBinding
public class LicenseSpringConverter implements Converter<String,LicenseType> {

    private final LicenseHibernateConverter licenseHibernateConverter = new LicenseHibernateConverter();

    @Override
    public LicenseType convert(String license) {

        return switch (license) {
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
            default -> throw new ResourceNotFound("License not valid");
        };
    }
}
