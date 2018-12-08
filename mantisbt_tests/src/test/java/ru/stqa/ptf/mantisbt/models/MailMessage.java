package ru.stqa.ptf.mantisbt.models;

import ru.stqa.ptf.mantisbt.appmanager.MailHelper;

public class MailMessage {
    public String to;
    public String text;

    public MailMessage(String to, String text){
        this.to = to;
        this.text = text;
    }
}
