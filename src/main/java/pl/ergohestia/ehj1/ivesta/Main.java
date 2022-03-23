package pl.ergohestia.ehj1.ivesta;

import Services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");


    public static void main(final String[] args) {
        new Main().run();
    }

    private void run(){
        MenuService menuService = new MenuService();

        log.info("App starting.");

        SYSOUT.info("Witaj w aplikacji iVesta!");

        menuService.printMainMenu();
        int menuItem = menuService.getMenuItem();
        menuService.handleMainManu(menuItem);

        log.info("Exit successful.");
    }


}
