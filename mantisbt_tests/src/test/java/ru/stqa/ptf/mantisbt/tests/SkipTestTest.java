package ru.stqa.ptf.mantisbt.tests;

import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class SkipTestTest extends TestBase {

    @Test
    public void testSkipTests() throws RemoteException, ServiceException, MalformedURLException {
        // считаем, что выполенение теста зависит от
        int issueId = 1;
        skipIfNotFixed(issueId);
        System.out.println("Test was run");
    }
}
