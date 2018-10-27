package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getNavigationHelper().gotoContactCreation();
        app.getContactHelper().fillContactForm(
                true,
                new ContactData(
                        "firstName",
                        "middleName",
                        "lastName",
                        "123456789",
                        "123456789",
                        "qwe@qwe.su",
                        "testgroup"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}
