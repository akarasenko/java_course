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
        app.goTo().HomePage();

        if (!app.contact().isThereAContact()) {
            app.contact().add(new ContactData(
                    "firstName",
                    "123456789",
                    "testgroup"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();

        int indexToModify = before.size() - 1;

        ContactData modifiedData = new ContactData(
                before.get(indexToModify).getId(),
                "newFirstName",
                null,
                null);

        app.contact().modify(indexToModify, modifiedData);
        app.goTo().HomePage();

        List<ContactData> after = app.contact().list();

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }


}
