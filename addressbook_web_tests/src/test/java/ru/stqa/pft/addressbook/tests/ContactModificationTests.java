package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.Set;

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
        Set<ContactData> before = app.contact().all();

        ContactData contactToModify = before.iterator().next();

        ContactData modifiedData = new ContactData()
                .withId(contactToModify.getId())
                .withFirstName("newFirstName");

        app.contact().modify(contactToModify, modifiedData);
        app.goTo().HomePage();

        Set<ContactData> after = app.contact().all();

        before.remove(contactToModify);
        before.add(modifiedData);

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }


}
