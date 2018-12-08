package ru.stqa.ptf.mantisbt.models;

import biz.futureware.mantis.rpc.soap.client.IssueData;

public class Issue {

    private int id;
    private String summary;
    private String description;
    private Project project;
    private String category;
    private String status;

    public Issue(){}

    public Issue(IssueData issueData){
        id = issueData.getId().intValue();
        summary = issueData.getSummary();
        description = issueData.getDescription();
        category = issueData.getCategory();
        status = issueData.getStatus().toString();
    }

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Issue withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Issue withStatus(String status) {
        this.status = status;
        return this;
    }
}
