package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().addContact(new ContactData(
                "firstName",
                "middleName",
                "lastName",
                "123456789",
                "123456789",
                "qwe@qwe.su",
                "testgroup"));
    }
}
