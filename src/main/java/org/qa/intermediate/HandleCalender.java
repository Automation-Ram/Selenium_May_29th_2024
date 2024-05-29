package org.qa.intermediate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleCalender {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		WebElement clickOp = driver.findElement(By.id("datepicker"));
		clickOp.click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		selectDate("19", "November", "2024");

	}

	public static String[] getMonthYear(String monthYear) {
		return monthYear.split(" ");
	}

	public static void selectDate(String exday, String exMonth, String exYear) {
		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		while (!(getMonthYear(monthYear)[0].equals(exMonth) && getMonthYear(monthYear)[1].equals(exYear))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYear);
		}
		driver.findElement(By.xpath("//a[text()='" + exday + "']")).click();
	}

}
