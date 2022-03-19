package Services;

import java.util.Scanner;

public class UserService {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        userService.mainMenu();
        System.out.print("Pozycja z menu: ");
        int item = scanner.nextInt();

        userService.submenu(item);

    }

    private void mainMenu() {
        System.out.println("Witaj w aplikacji iVesta!\n");
        System.out.println("Wybierz jedną z poniższych opcji:");
        System.out.println("1. Wyświetl kierowców.");
        System.out.println("2. Wyświetl samochody.");
        System.out.println("3. Zaplanuj trasę.");
    }

    private void submenu(int item) {
        if (item == 1) {
            System.out.println("Wyświetlenie kierowców");
        } else if (item == 2) {
            System.out.println("Wyświetlenie samochodów");
        } else if (item == 2) {
            System.out.println("Zaplanuj trasę");
        }
    }


}
