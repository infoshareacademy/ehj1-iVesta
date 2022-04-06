package pl.ergohestia.ehj1.ivesta.ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import pl.ergohestia.ehj1.ivesta.model.Menu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @Mock
    private Menu menu;

    @Mock
    Logger SYSOUT;

    @Mock
    InputScannerProvider inputScannerProvider;

    @InjectMocks
    private MenuService sut;

    @Captor
    private ArgumentCaptor<String> captor;


    @Test
    void shouldLoggerLog() {
        // given
        int correctChose = 1;
        String outputMessage = correctChose + " test";

        List<String> testMenu = List.of(outputMessage, "2 test", "3 test");
        InputStream testInputStream = prepareInputStream("test", 999999, -1, correctChose);
        Scanner testScanner = new Scanner(testInputStream);

        // when
        when(menu.getMenuItems()).thenReturn(testMenu);
        when(inputScannerProvider.getScanner()).thenReturn(testScanner);

        sut.menu();

        verify(SYSOUT, atLeastOnce()).info(captor.capture());
        String lastCapturedMessage = captor.getAllValues().get(captor.getAllValues().size() - 1);

        String result = lastCapturedMessage.substring(lastCapturedMessage.length() - 6);

        // then
        assertThat(result).isEqualTo(outputMessage);
    }

    @Test
    void shouldPrintMenu() {
        // given
        int noMenuItems = 3;
        List<String> testMenu = List.of("1 test", "2 test", "3 test");
        InputStream testInputStream = prepareInputStream(1);
        Scanner testScanner = new Scanner(testInputStream);

        // when
        when(menu.getMenuItems()).thenReturn(testMenu);
        when(inputScannerProvider.getScanner()).thenReturn(testScanner);

        sut.menu();
        verify(SYSOUT, atLeastOnce()).info(captor.capture());
        List<String> result = captor.getAllValues().subList(0, noMenuItems);

        // then
        assertThat(result).isEqualTo(testMenu);

    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append(System.lineSeparator());
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}