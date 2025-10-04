package IRCTC_PROJECT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TRAIN_SEARCH {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.irctc.co.in/nget/train-search");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement alert = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
		alert.click();
		WebElement from = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@role='searchbox'])[1]")));
		from.sendKeys("HYDERABAD");
		Actions bb = new Actions(driver);
		for (int i = 1; i <= 2; i++) {
			bb.sendKeys(Keys.ARROW_DOWN).perform();

		}
		bb.sendKeys(Keys.ENTER).perform();
		System.out.println("Departure Station Test Passed" + from);
		WebElement to = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//p-autocomplete[@id='destination']//input[@role='searchbox']")));
		to.sendKeys("KOLKATA");
		Actions cc = new Actions(driver);
		for (int i = 1; i <= 1; i++) {
			cc.sendKeys(Keys.ARROW_DOWN).perform();
		}
		cc.sendKeys(Keys.ENTER).perform();
		WebElement journeydate = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//p-calendar[@id='jDate']//input[@type='text']")));
		journeydate.click();
		WebElement month = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p-calendar[@id='jDate']//span//div//div//div//div")));
		Boolean status = true;

		while (true) {
			String expected = "November2025";
			WebElement monthYear = driver.findElement(By.xpath(
					"//body/app-root/app-home/div[@id='divMain']/div/app-main-page/div/div/div/div/div/app-jp-input/div/form/div/div/div/p-calendar[@id='jDate']/span/div/div/div[1]"));
			monthYear.getText();
			if (monthYear.equals("November2025")) {
				break;
			} else {
				WebElement next = driver.findElement(By.xpath("//a[2]//span[1]"));
				next.click();
				break;
			}
		}
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='5']")));
		date.click();

		WebElement classes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//body/app-root/app-home/div[@id='divMain']/div/app-main-page/div/div/div/div/div/app-jp-input/div/form/div/div/div/p-dropdown[@id='journeyClass']/div[1]")));
		classes.click();
		Actions ac = new Actions(driver);
		for (int i = 1; i <= 3; i++) {
			ac.sendKeys(Keys.ARROW_UP).perform();

		}
		ac.sendKeys(Keys.ENTER).perform();

		WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

	}

}
