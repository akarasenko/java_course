package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().GroupPage();

        List<GroupData> before = app.group().list();

        GroupData addedData = new GroupData("testgroup", "mytestgroup", "testheader");

        app.group().add(addedData);
        List<GroupData> after = app.group().list();

        addedData.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(addedData);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }


}
