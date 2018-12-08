package ru.stqa.ptf.mantisbt.appmanager;

import org.openqa.selenium.By;
import ru.stqa.ptf.mantisbt.tests.TestBase;

public class AutorizationHelper extends HelperBase {
    public AutorizationHelper(ApplicationManager app){
        super(app);
    }

    public void in(String username, String password){
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void out(){
        click(By.linkText("Logout"));
    }
}
