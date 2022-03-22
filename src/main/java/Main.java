import Services.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();

        menuService.printMainMenu();
        int menuItem = menuService.getMenuItem();
        menuService.handleMainManu(menuItem);
    }
}
