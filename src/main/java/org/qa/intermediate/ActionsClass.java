package org.qa.intermediate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);

		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement tar = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(src).moveToElement(tar).release().build().perform();

	}

}
