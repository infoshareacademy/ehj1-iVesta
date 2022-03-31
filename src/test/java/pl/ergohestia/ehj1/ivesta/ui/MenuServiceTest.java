package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.Appender;
import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @Mock
    private Menu menu;

    @Mock
    private Logger SYSOUT;

    @Mock
    InputStreamProvider inputStreamProvider;

//    @Spy
    @InjectMocks
    private MenuService sut = new MenuService();

    @Captor
    private ArgumentCaptor<String> captor;


    @Test
    void shouldName() {

        List<String> testMenu = List.of("1 test", "2 test", "3 test");
        when(menu.getMenuItems()).thenReturn(testMenu);

        //dziala
        InputStream in = prepareInputStream("test", 999999, 1, -1);
//        InputStream in = prepareInputStream("test", 1, 999999, -1);

        //dziala
//        List<String> inputList = Arrays.asList("test", "1","9999", "-1");
//        byte[] bytes = inputList.stream().collect(Collectors.joining("\n", "", "\n")).getBytes();
//        InputStream in = new ByteArrayInputStream(bytes);

        when(inputStreamProvider.getInputStream()).thenReturn(in);
        sut.menu();

        verify(SYSOUT).info(captor.capture());
        String value = captor.getValue();
        System.out.println(value);
//        List<String> allValues = captor.getAllValues();

        assertThat(true);
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