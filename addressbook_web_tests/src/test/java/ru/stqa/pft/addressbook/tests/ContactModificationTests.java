package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeTest
    public void unsurePreconditions() {
        app.goTo().HomePage();

        if (!app.contact().isThereAContact()) {
            app.contact().add(new ContactData()
                    .withFirstName("firstName")
                    .withMobilePhone("123456789"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();

        ContactData contactToModify = before.iterator().next();

        ContactData modifiedData = new ContactData()
                .withId(contactToModify.getId())
                .withFirstName("newFirstName");

        app.contact().modify(contactToModify, modifiedData);
        app.goTo().HomePage();

        assertThat(app.contact().size(), equalTo(before.size()));

        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.witout(contactToModify).withAdded(modifiedData)));
    }


}
