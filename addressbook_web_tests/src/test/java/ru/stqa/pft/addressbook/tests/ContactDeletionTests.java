package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeTest
    public void unsurePreconditions() {
        app.goTo().HomePage();

        if (!app.contact().isThereAContact()) {
            app.contact().add(new ContactData()
                    .withFirstName("firstName")
                    .withMobilePhone("123456789")
                    .withGroup("testgroup"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();

        int indexToDelete = before.size() - 1;

        app.contact().delete(indexToDelete);
        app.goTo().HomePage();

        before.remove(before.size() - 1);
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(before, after);
    }


}
