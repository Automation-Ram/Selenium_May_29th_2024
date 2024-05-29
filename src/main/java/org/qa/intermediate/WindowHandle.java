package org.qa.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver(co);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		String parentWin = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		Set<String> handles = driver.getWindowHandles();
		List<String> hlist = new ArrayList<String>(handles);

		if (switchToRightWindow("Facebook", hlist)) {
			System.out.println(driver.getCurrentUrl());
		}

	}

	public static boolean switchToRightWindow(String windowTitle, List<String> hlist) {
		for (String e : hlist) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("FIND");
				return true;
			}
		}
		return false;
	}

}
