package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().addGroup(new GroupData("testgroup", "mytestgroup", "testheader"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().retutnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    before.remove(0);

   /*
   for (int i = 0; i < before.size(); i++)
    {
      Assert.assertEquals(before.get(i), after.get(i));
    }
  */

    Assert.assertEquals(before, after);

    Assert.assertEquals(before.size(), after.size());
  }

}
