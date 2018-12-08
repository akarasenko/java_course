package ru.stqa.ptf.mantisbt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantisbt.models.MailMessage;
import ru.stqa.ptf.mantisbt.models.User;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTest extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException {
        List<User> users = app.db().getUsers();
        // в БД два юзера, первый - администратор, второму - меняем пароль
        User user = users.get(1);

        String newPassword = "123456q";
        app.log().in(app.getProperty("web.login"), app.getProperty("web.password"));
        app.manageUser().initPasswordChange(user.username);
        app.log().out();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String link = findConformationLink(mailMessages, user.email);
        app.manageUser().finishPasswordChange(link, newPassword);

        assertTrue(app.newSession().login(user.username, newPassword));
    }

    private String findConformationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
 }
