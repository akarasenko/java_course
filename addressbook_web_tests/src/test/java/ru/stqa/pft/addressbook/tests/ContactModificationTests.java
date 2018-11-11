package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        int indexToModify = 1;

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
        ContactData modifiedData = new ContactData(
                before.get(indexToModify).getId(),
                "newFirstName",
                "newMiddleName",
                "newLastName",
                null,
                null,
                null,
                null);

        app.getContactHelper().initContactModification(indexToModify);
        app.getContactHelper().fillContactForm(false, modifiedData);
        app.getContactHelper().submitContactModification();

        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }
}
