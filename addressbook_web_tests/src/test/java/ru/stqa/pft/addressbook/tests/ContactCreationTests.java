package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getNavigationHelper().gotoContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("firstName", "middleName", "lastName", null, null, null, null, "123456789", "123456789", "123456789", null, "qwe@qwe.su"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}
