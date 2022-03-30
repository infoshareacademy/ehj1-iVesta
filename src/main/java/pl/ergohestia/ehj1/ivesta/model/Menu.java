package pl.ergohestia.ehj1.ivesta.model;

import java.util.List;

public class Menu {

    public List<String> menuItems;

    public Menu(String... menuItem) {
        this.menuItems = List.of(menuItem);
    }

}
