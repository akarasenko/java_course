package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().GroupPage();

        Set<GroupData> before = app.group().all();

        GroupData addedData = new GroupData()
                .withName("testgroup")
                .withHeader("testheader")
                .withFooter("testfooter");

        app.group().add(addedData);
        Set<GroupData> after = app.group().all();

        addedData.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt());
        before.add(addedData);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }


}
