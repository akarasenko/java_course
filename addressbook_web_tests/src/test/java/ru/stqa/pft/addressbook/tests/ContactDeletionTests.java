package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
