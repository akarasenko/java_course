package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData dataToAdd = new ContactData(
                "firstName",
                "123456789",
                "testgroup");

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().addContact(dataToAdd);
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        dataToAdd.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(dataToAdd);

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }
}
