package ru.stqa.pft.addressbook.appmamager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    /*
    public void selectGroup(int index) {
             wd.findElements(By.name("selected[]")).get(index).click();
    }
    */

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void goToGroupPage() {
        click(By.linkText("group page"));
    }

    public void ininGroupModification() {
        click(By.name("edit"));
    }

    public void subminGroupModification() {
        click(By.name("update"));
    }

    /*
    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
    */

    public void add(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        goToGroupPage();
    }

    /*
    public void modify(int indexToModify, GroupData modefiedData) {
        selectGroup(indexToModify);
        ininGroupModification();
        fillGroupForm(modefiedData);
        subminGroupModification();
        goToGroupPage();
    }
  */

    public void modify(GroupData group, GroupData modefiedData) {
        selectGroupById(group.getId());
        ininGroupModification();
        fillGroupForm(modefiedData);
        subminGroupModification();
        goToGroupPage();
    }

    public int size() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            GroupData group = new GroupData()
                    .withId(id)
                    .withName(name);
            groups.add(group);
        }
        return groups;
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            GroupData group = new GroupData()
                    .withId(id)
                    .withName(name);
            groups.add(group);
        }
        return groups;
    }

    /*
    public void delete(int indexToDelete) {
        selectGroup(indexToDelete);
        deleteSelectedGroups();
        goToGroupPage();
    }
    */

    public void delete(GroupData groupToDelete) {
        selectGroupById(groupToDelete.getId());
        deleteSelectedGroups();
        goToGroupPage();
    }
}
