package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ergohestia.ehj1.ivesta.model.Menu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @Mock
    private Menu menu;

    @Mock
    private Logger SYSOUT;

    @InjectMocks
    private MenuService sut = new MenuService();

    @Captor
    private ArgumentCaptor<String> captor;


    @Test
    void shouldName() {

        List<String> testMenu = List.of("1 test", "2 test", "3 test");
        when(menu.getMenuItems()).thenReturn(testMenu);

        //dziala
        InputStream testInputStream = prepareInputStream("test", 999999, -1, 1);
        InputStreamProvider.getInstance();
        InputStreamProvider.setInputStream(testInputStream);

        sut.menu();

//        verify(SYSOUT).info(captor.capture());
//        String value = captor.getValue();
//        System.out.println(value);
////        List<String> allValues = captor.getAllValues();
//
//        assertThat(true);
    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append(System.lineSeparator());
//            testInput.append(input).append("\n");
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}