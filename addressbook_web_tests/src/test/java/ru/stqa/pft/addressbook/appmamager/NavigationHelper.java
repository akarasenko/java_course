package ru.stqa.pft.addressbook.appmamager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoContactCreation() {
        click(By.linkText("add new"));
    }

    public void retutnToHomePage() {
        click(By.linkText("home"));
    }
}
