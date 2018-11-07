package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().ininGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("newName", "newHeader", "newFooter"));
        app.getGroupHelper().subminGroupModification();
        app.getGroupHelper().retutnToGroupPage();

        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
    }

}
