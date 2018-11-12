package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.getGroupHelper().getGroupList();

        int indexToModify = 0;
        int id = before.get(indexToModify).getId();

        GroupData modefiedData = new GroupData(indexToModify, "newName", "newHeader", "newFooter");

        app.getGroupHelper().modifyGroup(indexToModify, modefiedData);

        List<GroupData> after = app.getGroupHelper().getGroupList();
        after.get(indexToModify).setId(id);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }


}
