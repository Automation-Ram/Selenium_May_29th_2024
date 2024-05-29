package org.qa.intermediate;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowPopUp {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://omayo.blogspot.com/");
		String parentWin = driver.getWindowHandle();
		driver.findElement(By.linkText("Open a popup window")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			if (driver.getTitle().equals("New Window")) {
				driver.close();
			}
		}
		driver.switchTo().window(parentWin);

	}

}
