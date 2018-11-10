package ru.stqa.pft.addressbook.appmamager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation(){
        click(By.linkText("add new"));
    }

    public void fillContactForm(boolean creation, ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
             new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt=\"Edit\"]"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void selectContact(int i) {
        wd.findElements(By.name("selected[]")).get(i).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void addContact(ContactData contact) {
        initContactCreation();
        fillContactForm(true, contact);
        submitContactCreation();
        retunToHomePage();
    }

    public void retunToHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact()
    {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();

        List<WebElement> elements = wd.findElements(By.cssSelector("tr"));

        for (int i = 0; i < elements.size(); i++) {
            if (i!=0)
            {
                var tableRow = elements.get(i).findElements(By.cssSelector("td"));
                int id = Integer.parseInt(tableRow.get(0).findElement(By.tagName("input")).getAttribute("value"));
                String name = tableRow.get(1).getText();
                ContactData contact = new ContactData(id, name, null, null, null, null, null, null);
                contacts.add(contact);
            }
        }
        return  contacts;
    }
}
