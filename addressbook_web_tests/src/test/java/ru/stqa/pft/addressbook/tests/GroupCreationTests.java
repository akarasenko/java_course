package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(before+1, after);
    }

}
