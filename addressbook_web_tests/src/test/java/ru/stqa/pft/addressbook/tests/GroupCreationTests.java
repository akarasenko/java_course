package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(before.size()+1, after.size());
    }

}
