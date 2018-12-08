package ru.stqa.ptf.mantisbt.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.mantisbt.models.Issue;
import ru.stqa.ptf.mantisbt.models.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SoapTest extends TestBase {

    @Test(enabled = false)
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
    }

    @Test
    public void createIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soap().getProjects();

        Issue issue = new Issue()
                .withSummary("test issue")
                .withDescription("test description")
                .withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);

        assertThat(issue.getDescription(), equalTo(created.getDescription()));

    }
}
