package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    private String firstname;

    @Expose
    @Type(type = "text")
    @Column(name = "mobile")
    private String mobilePhone;

    @Type(type = "text")
    @Column(name = "home")
    private String homePhone;

    @Type(type = "text")
    @Column(name = "work")
    private String workPhone;

    @Transient
    private String allPhones;

    @Type(type = "text")
    @Column(name = "address")
    private String address;

    @Type(type = "text")
    @Expose
    @Column(name = "email")
    private String eMail;

    @Type(type = "text")
    @Column(name = "email2")
    private String eMailTwo;

    @Type(type = "text")
    @Column(name = "email3")
    private String eMailThree;

    @Transient
    private String allEMails;

    @Transient
    private String group;

    @Type(type = "text")
    @Column(name = "photo")
    private String photo;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGroup() {
        return group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAddress() {
        return address;
    }

    public String getEMail() {
        return eMail;
    }

    public String getEMailTwo() {
        return eMailTwo;
    }

    public String getEMailThree() {
        return eMailThree;
    }

    public String getAllEMails() {
        return allEMails;
    }

    public File getPhoto() { return new File(photo); }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstname = firstName;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ContactData withEMailTwo(String eMailTwo) {
        this.eMailTwo = eMailTwo;
        return this;
    }

    public ContactData withEMailThree(String eMailThree) {
        this.eMailThree = eMailThree;
        return this;
    }

    public ContactData withAllEMails(String allEMails) {
        this.allEMails = allEMails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;
        ContactData that = (ContactData) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
