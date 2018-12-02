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

    @Transient
    private String homePhone;

    @Transient
    private String workPhone;

    @Transient
    private String allPhones;

    @Transient
    private String address;

    @Expose
    @Type(type = "text")
    @Column(name = "email")
    private String eMail;

    @Transient
    private String eMailTwo;

    @Transient
    private String eMailThree;

    @Transient
    private String allEMails;

    @Transient
    private String group;

    @Transient
    private String photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(eMailTwo, that.eMailTwo) &&
                Objects.equals(eMailThree, that.eMailThree) &&
                Objects.equals(group, that.group) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, mobilePhone, homePhone, workPhone, address, eMail, eMailTwo, eMailThree, group, photo);
    }

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

    public File getPhoto() {
        if (photo == null) {
            return null;
        }
        return new File(photo); }

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

}
