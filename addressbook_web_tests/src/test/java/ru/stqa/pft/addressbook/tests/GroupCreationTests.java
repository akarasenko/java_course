package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().GroupPage();

        Groups before = app.group().all();

        GroupData addedData = new GroupData()
                .withName("testgroup")
                .withHeader("testheader")
                .withFooter("testfooter");

        app.group().add(addedData);

        assertThat(app.group().size(), equalTo(before.size() + 1));

        Groups after = app.group().all();

        assertThat(after, equalTo(
                after.withAdded(addedData.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));
    }


}
