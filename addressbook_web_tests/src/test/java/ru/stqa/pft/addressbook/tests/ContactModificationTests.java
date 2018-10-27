package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
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
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(
                false,
                new ContactData(
                        "newFirstName",
                        "newMiddleName",
                        "newLastName",
                        null,
                        null,
                        null,
                        null));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}
