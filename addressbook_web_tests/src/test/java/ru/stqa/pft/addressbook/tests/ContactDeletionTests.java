package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

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
        Set<ContactData> before = app.contact().all();

        ContactData contactToDelete = before.iterator().next();

        app.contact().delete(contactToDelete);
        app.goTo().HomePage();

        before.remove(contactToDelete);
        Set<ContactData> after = app.contact().all();

        Assert.assertEquals(before, after);
    }


}
