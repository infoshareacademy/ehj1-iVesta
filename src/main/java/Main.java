import UI.MenuCLI;

public class Main {
    public static void main(String[] args) {
        MenuCLI menuService = new MenuCLI();

        menuService.printMainMenu();
        int menuItem = menuService.getMenuItem();
        menuService.handleMainManu(menuItem);
    }
}
