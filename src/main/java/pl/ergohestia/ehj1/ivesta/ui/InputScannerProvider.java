package pl.ergohestia.ehj1.ivesta.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputScannerProvider {

    private static InputStream inputStream = System.in;
    private static Scanner scanner = new Scanner(inputStream);

    public InputScannerProvider() {
    }

    static void setInputStream(InputStream inputStream) {
        InputScannerProvider.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public Scanner getScanner(){
        return scanner;
    }
}
