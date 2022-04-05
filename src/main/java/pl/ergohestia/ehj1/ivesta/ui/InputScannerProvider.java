package pl.ergohestia.ehj1.ivesta.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputScannerProvider {

    private InputStream inputStream = System.in;
    private Scanner scanner = new Scanner(inputStream);

    public InputScannerProvider() {
    }

    void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public Scanner getScanner(){
        return scanner;
    }
}
