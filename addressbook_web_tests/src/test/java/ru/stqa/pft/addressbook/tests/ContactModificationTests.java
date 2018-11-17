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
            app.contact().add(new ContactData()
                    .withFirstName("firstName")
                    .withMobilePhone("123456789")
                    .withGroup("testgroup"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();

        int indexToModify = before.size() - 1;

        ContactData modifiedData = new ContactData()
                .withId(before.get(indexToModify).getId())
                .withFirstName("newFirstName");

        app.contact().modify(indexToModify, modifiedData);
        app.goTo().HomePage();

        List<ContactData> after = app.contact().list();

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }


}
