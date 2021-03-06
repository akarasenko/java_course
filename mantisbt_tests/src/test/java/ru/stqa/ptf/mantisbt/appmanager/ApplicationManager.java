package ru.stqa.ptf.mantisbt.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private Properties properties;
    private WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHelper;
    public FtpHelper ftp;
    private MailHelper mail;
    private ManageUserHelper manageUser;
    private AutorizationHelper log;
    private DbHelper db;
    private SoapHelper soap;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public WebDriver getDriver() {
        if (wd == null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
            // wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }

    public FtpHelper ftp() {
        if (ftp == null) {
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public MailHelper mail() {
        if (mail == null) {
            mail = new MailHelper(this);
        }
        return mail;
    }

    public ManageUserHelper manageUser() {
        if (manageUser == null) {
            manageUser = new ManageUserHelper(this);
        }
        return manageUser;
    }

    public AutorizationHelper log() {
        if (log == null) {
            log = new AutorizationHelper(this);
        }
        return log;
    }

    public DbHelper db() {
        if (db == null) {
            db = new DbHelper();
        }
        return db;
    }

    public SoapHelper soap() {
        if (soap == null) {
            soap = new SoapHelper(this);
        }
        return soap;
    }
}

