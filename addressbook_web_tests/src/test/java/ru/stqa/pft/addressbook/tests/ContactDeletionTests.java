package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeTest
    public void unsurePreconditions() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().addContact(new ContactData(
                    "firstName",
                    "123456789",
                    "testgroup"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomePage();

        before.remove(before.size() - 1);
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(before, after);
    }
}
