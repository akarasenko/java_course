package ru.stqa.pft.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RestTest extends TestBase {

    private int issueIdForCheck = 0;

    @BeforeTest
    public void createIssueForCheck() throws IOException {
        Issue issue = new Issue().withSubject("new test subject").withDescription("new test description");
        issueIdForCheck = createIssue(issue);
    }

    @Test
    public void testSkipTest() throws IOException {
        skipIfNotFixed(issueIdForCheck);
        System.out.println("Test was run");
    }
}
