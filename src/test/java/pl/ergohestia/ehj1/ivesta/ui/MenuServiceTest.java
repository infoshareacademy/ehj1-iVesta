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

    // TODO refatctor and change name
    @Test
    void shouldName() {

        String test1 = "1 test";
        List<String> testMenu = List.of(test1, "2 test", "3 test");
        when(menu.getMenuItems()).thenReturn(testMenu);

        InputStream testInputStream = prepareInputStream("test", 999999, -1, 1);
        Scanner testScanner = new Scanner(testInputStream);

        when(inputScannerProvider.getScanner()).thenReturn(testScanner);

        sut.menu();

        verify(SYSOUT, atLeastOnce()).info(captor.capture());
        String lastCapturedMessage = captor.getAllValues().get(captor.getAllValues().size()-1);

        String testMessage = lastCapturedMessage.substring(lastCapturedMessage.length() - 6);
        assertThat(testMessage).isEqualTo(test1);
    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append(System.lineSeparator());
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}