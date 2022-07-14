package week4day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sneapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.className("catText")).click();
		driver.findElement(By.className("linkTest")).click();
		Thread.sleep(2000);
		String noOfShoes = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span")).getText();
		System.out.println("Number of Sports Shoes: " + noOfShoes);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//div[@class='sorting-sec animBounce']//ul/li)[2]")).click();
		Thread.sleep(2000);
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='product-price-row clearfix']//span[contains(@id,'display-price')]"));
		List<Integer> pricesList = new ArrayList<Integer>();
		List<Integer> sortedList = new ArrayList<Integer>();
		for (WebElement priceList : priceElements) {
			pricesList.add(Integer.parseInt(priceList.getText().substring(3).replace(",", "").trim()));
		}
		sortedList.addAll(pricesList);
		Collections.sort(sortedList);
		if (pricesList.equals(sortedList))
			System.out.println("\'Low to High Price\' Items are sorted correctly");
		else {
			System.out.println("\'Low to High Price\' Items are sorted incorrectly");
			System.out.println(pricesList);
		} 
		Thread.sleep(1000);
		WebElement fromVal = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1500");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		Thread.sleep(2000);
		WebElement checkboxBlue = driver.findElement(By.xpath("//label[contains(@for,'Blue')]"));
		checkboxBlue.click();
//		Thread.sleep(5000);
//		System.out.println("Blue Color Checkbox is Selected: "+ checkboxBlue.isSelected());
		List<WebElement> productElements = driver.findElements(By.xpath("//p[@class='product-title']"));
		productElements.get(0).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listallWindows1 = new ArrayList<String>(windowHandles1);
		Thread.sleep(2000);
		driver.switchTo().window(listallWindows1.get(1));
		String finalPrice = driver.findElement(By.xpath("//span[@class='pdp-final-price']")).getText();
		String discountPercent = driver.findElement(By.xpath("//span[@class='pdp-final-price']//following-sibling::span[contains(@class,'Discount')]")).getText();
		System.out.println("Final Price of Product: "+finalPrice);
		System.out.println("Discount Percentage: "+discountPercent);
		File scrshot = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./scrshots/IMG-0001.png");
		FileUtils.copyFile(scrshot, destination);
		System.out.println("Screenshot Captured ");
	}
}
	   
	   
	   
	   
	
	
	
	
	
	




