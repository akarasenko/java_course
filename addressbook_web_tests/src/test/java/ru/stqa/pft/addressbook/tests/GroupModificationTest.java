package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().ininGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("newName", "newHeader", "newFooter"));
        app.getGroupHelper().subminGroupModification();
        app.getGroupHelper().retutnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(before.size(), after.size());
    }

}
