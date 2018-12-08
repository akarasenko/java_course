package ru.stqa.ptf.mantisbt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantisbt.models.MailMessage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException {
        String username = "user1";
        String email = "qwe@qwe.su";
        String password = "123qwe";
        app.registration().start(username, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String link = findConformationLink(mailMessages, email);
        app.registration().finish(link, password);
        assertTrue(app.newSession().login(username,password));
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
