package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().HomePage();

        ContactData dataToAdd = new ContactData()
                .withFirstName("firstName")
                .withMobilePhone("123456789")
                .withGroup("testgroup");

        List<ContactData> before = app.contact().list();

        app.contact().add(dataToAdd);
        app.goTo().HomePage();

        List<ContactData> after = app.contact().list();

        dataToAdd.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(dataToAdd);

        Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
    }
}
