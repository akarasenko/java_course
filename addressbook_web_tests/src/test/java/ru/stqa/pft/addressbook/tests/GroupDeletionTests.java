package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {
    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().size() == 0) {
            app.group().add(new GroupData()
                    .withName("testgroup")
                    .withHeader("testheader")
                    .withFooter("testfooter"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {
        Groups before = app.group().all();
        GroupData groupToDelete = before.iterator().next();
        app.group().delete(groupToDelete);

        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(
                 after.without(groupToDelete)));
    }
}
