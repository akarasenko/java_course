package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().ininGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("newName", "newHeader", "newFooter"));
        app.getGroupHelper().subminGroupModification();
        app.getGroupHelper().retutnToGroupPage();
    }

}
