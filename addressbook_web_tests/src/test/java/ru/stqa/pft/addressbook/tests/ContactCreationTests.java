package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        app.getNavigationHelper().gotoContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("firstName", "middleName", "lastName", "nickName", "title", "company", "address", "123456789", "123456789", "123456789", "123456789", "qwe@qwe.su"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}
