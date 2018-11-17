package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

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
    public void testContactDeletion() {
        Contacts before = app.contact().all();

        ContactData contactToDelete = before.iterator().next();

        app.contact().delete(contactToDelete);
        app.goTo().HomePage();

        Contacts after = app.contact().all();

        assertThat(after.size(), equalTo(before.size() - 1 ));
        assertThat(after, equalTo(before.witout(contactToDelete)));;
    }


}
