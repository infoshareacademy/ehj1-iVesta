package pl.ergohestia.ehj1.ivesta;

import pl.ergohestia.ehj1.ivesta.UI.MenuCLI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");


    public static void main(final String[] args) {
        new Main().run();
    }

    private void run(){
        MenuCLI menuService = new MenuCLI();

        log.info("App starting.");

        SYSOUT.info("Witaj w aplikacji iVesta!");

        menuService.printMainMenu();
        menuService.handleMainMenu();

        log.info("Exit successful.");
    }
}
