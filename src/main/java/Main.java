import UI.MenuCLI;

public class Main {
    public static void main(String[] args) {
        MenuCLI menuService = new MenuCLI();

        menuService.printMainMenu();
        menuService.handleMainMenu();
    }
}
