package ru.stqa.ptf.mantisbt.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.ptf.mantisbt.models.Issue;
import ru.stqa.ptf.mantisbt.models.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

    private final ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }

    public Set<Project> getProjects() throws RemoteException, MalformedURLException, ServiceException {
        ProjectData[] projects = getMantisConnect().mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects)
                .stream()
                .map((p) -> new Project()
                        .withId(p.getId().intValue()).withName(p.getName()))
                .collect(Collectors.toSet());
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();

        String category = mc.mc_project_get_categories("administrator", "root",
                BigInteger.valueOf(issue.getProject().getId()))[0];

        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
        issueData.setCategory(category);

        BigInteger id = mc.mc_issue_add("administrator", "root", issueData);
        IssueData created = mc.mc_issue_get("administrator", "root", id);
        return new Issue()
                .withId(created.getId().intValue())
                .withSummary(created.getSummary())
                .withDescription(created.getDescription())
                .withProject(new Project().withId(created.getProject().getId().intValue())
                                          .withName(created.getProject().getName()))
                .withCategory(created.getCategory());
    }

    private MantisConnectPortType getMantisConnect() throws MalformedURLException, ServiceException {
        return new MantisConnectLocator()
                .getMantisConnectPort(new URL("http://localhost/mantisbt-1.2.19/api/soap/mantisconnect.php"));

    }
}
