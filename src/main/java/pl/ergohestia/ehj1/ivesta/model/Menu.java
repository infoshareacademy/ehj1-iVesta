package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Menu {

    public List<String> menuItems;

    public Menu(String... menuItem) {
        this.menuItems = List.of(menuItem);
    }

}
