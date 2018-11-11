package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String mobilePhone;
    private String group;

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

    public ContactData(int id, String firstName, String mobilePhone, String group) {
        this.id = id;
        this.firstName = firstName;
        this.mobilePhone = mobilePhone;
        this.group = group;
    }

    public ContactData(String firstName, String mobilePhone, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.mobilePhone = mobilePhone;
        this.group = group;
    }

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

    public void setId(int id) {
        this.id = id;
    }

}
