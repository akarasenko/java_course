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
        List<GroupData> before = app.group().list();

        int indexToModify = 0;
        int id = before.get(indexToModify).getId();

        GroupData modefiedData = new GroupData()
                .withId(indexToModify)
                .withName("newgroup")
                .withHeader("newheader")
                .withFooter("newfooter");

        app.group().modify(indexToModify, modefiedData);

        List<GroupData> after = app.group().list();
        after.get(indexToModify).withId(id);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }


}
