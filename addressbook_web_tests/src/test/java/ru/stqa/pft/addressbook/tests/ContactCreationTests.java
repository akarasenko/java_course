package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() {
        app.goTo().HomePage();

        File photo = new File("src/test/resources/photo.png");

        ContactData dataToAdd = new ContactData()
                .withFirstName("firstName")
                .withMobilePhone("123456789")
                .withGroup("testgroup")
                .withPhoto(photo);

        Contacts before = app.contact().all();

        app.contact().add(dataToAdd);
        app.goTo().HomePage();

        assertThat(app.contact().size(), equalTo(before.size() + 1));

        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(dataToAdd.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void currentDirectory()
    {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        // C:\Users\User\Documents\java_course\addressbook_web_tests\
        File photo = new File("src/test/resources/photo.png");
        System.out.println(photo.exists());
    }
}
