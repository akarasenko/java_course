package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().size() == 0) {
            app.group().add(new GroupData()
                    .withName("testgroup")
                    .withHeader("testheader")
                    .withFooter("testfooter"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();

        GroupData groupToModify = before.iterator().next();

        GroupData modifiedData = new GroupData()
                .withId(groupToModify.getId())
                .withName("newgroup")
                .withHeader("newheader")
                .withFooter("newfooter");

        app.group().modify(groupToModify, modifiedData);

        Set<GroupData> after = app.group().all();
        before.remove(groupToModify);
        before.add(modifiedData);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }


}
