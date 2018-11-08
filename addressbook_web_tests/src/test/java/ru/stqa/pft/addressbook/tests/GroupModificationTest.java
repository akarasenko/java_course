package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();

        GroupData modefiedData = new GroupData(before.get(0).getId(), "newName", "newHeader", "newFooter");

        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().ininGroupModification();
        app.getGroupHelper().fillGroupForm(modefiedData);
        app.getGroupHelper().subminGroupModification();
        app.getGroupHelper().retutnToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);

        /*
        before.remove(0);
        before.add(modefiedData);
        */

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }

}
