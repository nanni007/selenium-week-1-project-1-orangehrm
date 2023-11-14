import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Project_2_OrangeHrm {

    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Enter correct browser");
        }

        driver.get(baseUrl);  //opens the url in the browser
        driver.manage().window().maximize(); //maximising the browser
        System.out.println("Title of the page is: " + driver.getTitle()); //printing the title of the page
        System.out.println("Page source is: " + driver.getPageSource()); //printing the page source
        driver.findElement(By.className("orangehrm-login-forgot")).click();
        System.out.println("Current url is: " + driver.getCurrentUrl()); //printing the current URL
        driver.navigate().back(); //navigating back to log in page
        driver.navigate().refresh(); //refreshing the page
        WebElement usernameField = driver.findElement(By.name("username")); //Entering the username
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));  //entering the password
        passwordField.sendKeys("admin123");
        WebElement loginLink = driver.findElement(By.className("orangehrm-login-action"));
        loginLink.click();
        driver.close();
    }
}
