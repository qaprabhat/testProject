package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/ist/Desktop/Automation_Test/Workspace_c/SmartfrenAutomation/Driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://192.168.4.235/siteforge/login.jsp");
		driver.findElement(By.id("username")).sendKeys("prabhat.kumar");;

	}

}
