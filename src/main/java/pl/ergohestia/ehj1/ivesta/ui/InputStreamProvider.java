package pl.ergohestia.ehj1.ivesta.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputStreamProvider {

    private static InputStream inputStream = System.in;
    private static Scanner scanner = new Scanner(inputStream);
    private static InputStreamProvider inputStreamProvider;
    private InputStreamProvider() {
    }

    public static InputStreamProvider getInstance() {
        if (inputStreamProvider == null) {
            inputStreamProvider = new InputStreamProvider();
        }
        return inputStreamProvider;
    }

    public static void setInputStream(InputStream inputStream) {
        InputStreamProvider.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public Scanner getScanner(){
        return scanner;
    }
}
