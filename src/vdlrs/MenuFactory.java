package vdlrs;

import javafx.scene.image.Image;

public class MenuFactory {
    String title;
    Image icon;

    public MenuFactory(String title, Image icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public Image getIcon() {
        return icon;
    }
}
