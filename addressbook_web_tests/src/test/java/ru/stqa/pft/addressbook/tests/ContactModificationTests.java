package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModofication();
        app.getContactHelper().fillContactForm(new ContactData("firstName", "middleName", "lastName", "nickName", "title", "company", "address", "123456789", "123456789", "123456789", "123456789", "qwe@qwe.su"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().retutnToHomePage();
    }
}
