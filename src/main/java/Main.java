import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Services.MenuService;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
      
        MenuService menuService = new MenuService();

        menuService.printMainMenu();
        int menuItem = menuService.getMenuItem();
        menuService.handleMainManu(menuItem);
    }
}