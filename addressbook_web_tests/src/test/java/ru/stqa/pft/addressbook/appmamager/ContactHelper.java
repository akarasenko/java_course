package ru.stqa.pft.addressbook.appmamager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(boolean creation, ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("mobile"), contactData.getMobilePhone());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void retunToHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void add(ContactData contact) {
        initContactCreation();
        fillContactForm(true, contact);
        submitContactCreation();
        retunToHomePage();
    }

    public void delete(ContactData contact) {
        selectById(contact.getId());
        deleteContact();
        submitContactDeletion();
    }

    public void modify(ContactData contact, ContactData modifiedData) {
        initContactModification(contact.getId());
        fillContactForm(false, modifiedData);
        submitContactModification();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();

        List<WebElement> elements = wd.findElements(By.cssSelector("tr"));

        for (int i = 0; i < elements.size(); i++) {
            if (i != 0) {
                List<WebElement> tableRow = elements.get(i).findElements(By.cssSelector("td"));
                int id = Integer.parseInt(tableRow.get(0).findElement(By.tagName("input")).getAttribute("value"));
                String name = tableRow.get(2).getText();
                ContactData contact = new ContactData().withId(id).withFirstName(name);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public Set<ContactData> all() {
        HashSet<ContactData> contacts = new HashSet<ContactData>();

        List<WebElement> elements = wd.findElements(By.cssSelector("tr"));

        for (int i = 0; i < elements.size(); i++) {
            if (i != 0) {
                List<WebElement> tableRow = elements.get(i).findElements(By.cssSelector("td"));
                int id = Integer.parseInt(tableRow.get(0).findElement(By.tagName("input")).getAttribute("value"));
                String name = tableRow.get(2).getText();
                ContactData contact = new ContactData().withId(id).withFirstName(name);
                contacts.add(contact);
            }
        }
        return contacts;
    }

}
