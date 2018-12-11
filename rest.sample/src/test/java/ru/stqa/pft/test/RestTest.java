package ru.stqa.pft.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class RestTest extends TestBase {

    @Test
    public void testSkipTest() throws IOException {
        int issueIdForCheck = 525;
        skipIfNotFixed(issueIdForCheck);
        System.out.println("Test was run");
    }
}
