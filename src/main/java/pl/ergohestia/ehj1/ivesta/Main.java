package pl.ergohestia.ehj1.ivesta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.ui.MenuService;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");


    public static void main(final String[] args) {
        new Main().run();
    }

    private void run(){
        MenuService menuService = new MenuService().init();

        log.info("App starting.");

        SYSOUT.info("Witaj w aplikacji iVesta!");

        log.info("Exit successful.");

        menuService.menu();
    }
}
