package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();

        int indexToModify = before.size() - 1;

        ContactData modifiedData = new ContactData(
                before.get(indexToModify).getId(),
                "newFirstName",
                null,
                null);

        app.getContactHelper().initContactModification(indexToModify);
        app.getContactHelper().fillContactForm(false, modifiedData);
        app.getContactHelper().submitContactModification();

        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }
}
