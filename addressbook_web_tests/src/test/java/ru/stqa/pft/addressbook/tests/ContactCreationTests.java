package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().HomePage();

        ContactData dataToAdd = new ContactData()
                .withFirstName("firstName")
                .withMobilePhone("123456789")
                .withGroup("testgroup");

        Set<ContactData> before = app.contact().all();

        app.contact().add(dataToAdd);
        app.goTo().HomePage();

        Set<ContactData> after = app.contact().all();

        dataToAdd.withId(after.stream().mapToInt((o) -> o.getId()).max().getAsInt());
        before.add(dataToAdd);

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }
}
