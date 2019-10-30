package training;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LaunchChrome 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\PROJECTS\\DATA\\seleniumCucumber\\Selenium-Hybrid-Framework-3.0.tar\\Selenium-Hybrid-Framework-3.0\\Selenium-Hybrid-Framework-3.0\\selenium-hybrid-framework\\Utilities\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	     	options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.get("https://rally1.rallydev.com/#/34494668566ud/backlog");
		
		/*driver.findElement(By.id("bmwradio")).click();
		System.out.println(driver.findElement(By.id("carselect")).isEnabled());
		WebElement drpdwn = driver.findElement(By.id("carselect"));
		Select s1 = new Select(drpdwn);
		s1.selectByVisibleText("Benz");
		s1.selectByValue("bmw");
		
		s1.selectByIndex(2);
		WebElement drpdwn=driver.findElement(By.id("carselect"));
        Select s1=new Select(drpdwn);
        s1.selectByVisibleText("Benz");
        s1.selectByValue("bmw");
        s1.selectByIndex(2);*/
        
        System.out.println("Label Text:"+driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[@for='honda']")).getText());
        driver.findElement(By.linkText("Login")).click();
       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));*/
        driver.findElement(By.id("alertbtn")).click();
       System.out.println("Text:"+ driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
		

	}

}
