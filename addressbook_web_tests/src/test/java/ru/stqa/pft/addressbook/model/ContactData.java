package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String allPhones;
    private String address;
    private String eMail;
    private String eMailTwo;
    private String eMailThree;
    private String allEMails;
    private String group;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
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
