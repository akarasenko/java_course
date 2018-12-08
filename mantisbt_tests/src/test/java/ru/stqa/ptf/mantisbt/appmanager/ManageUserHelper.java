package ru.stqa.ptf.mantisbt.appmanager;

import org.openqa.selenium.By;

public class ManageUserHelper extends HelperBase {

    public ManageUserHelper(ApplicationManager app) {
        super(app);
    }
    public void initPasswordChange(String username) {
        click(By.linkText("Manage"));
        click(By.linkText("Manage Users"));
        click(By.linkText(username));
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finishPasswordChange(String link, String newPassword) {
        wd.get(link);
        type(By.name("password"), newPassword);
        type(By.name("password_confirm"), newPassword);
        click(By.cssSelector("input[value='Update User']"));
    }
}
