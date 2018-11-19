package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().HomePage();

        ContactData dataToAdd = new ContactData()
                .withFirstName("firstName")
                .withMobilePhone("123456789")
                .withGroup("testgroup");

        Contacts before = app.contact().all();

        app.contact().add(dataToAdd);
        app.goTo().HomePage();

        assertThat(app.contact().size(), equalTo(before.size() + 1));

        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(dataToAdd.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));
    }
}
