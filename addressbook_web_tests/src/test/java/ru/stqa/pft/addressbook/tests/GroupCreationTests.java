package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        List<GroupData> before = app.getGroupHelper().getGroupList();

        GroupData addedData = new GroupData("testgroup", "mytestgroup", "testheader");

        app.getGroupHelper().addGroup(addedData);
        List<GroupData> after = app.getGroupHelper().getGroupList();

        int max = 0;
        for (GroupData group : after)
        {
            if (group.getId() >= max)
            {
                max = group.getId();
            }

        }

        addedData.setId(max);

        before.add(addedData);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }



}
