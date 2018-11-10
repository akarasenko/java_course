package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().addContact(new ContactData(
                    "firstName",
                    "middleName",
                    "lastName",
                    "123456789",
                    "123456789",
                    "qwe@qwe.su",
                    "testgroup"));
        }

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
