package IRCTC_PROJECT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC_Train_Search {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement alert = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
			alert.click();
			System.out.println("Popup handle at start");

		} catch (Exception e) {
			System.out.println("No Popup");
		}
		WebElement from = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//p-autocomplete[@id='origin']//input[@role='searchbox']")));
		from.click();
		from.sendKeys("hyd");

		List<WebElement> suggestions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role=\"listbox\"]//li[@role=\"option\"]")));
		suggestions.get(1).click();
		WebElement to = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//p-autocomplete[@id='destination']//input[@role='searchbox']")));
		to.click();
		to.sendKeys("Kolk");
		List<WebElement> anosuggestions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role=\"listbox\"]//li[@role=\"option\"]")));
		anosuggestions.get(1).click();
		try {
			WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
			submit.click();
			WebElement newpopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//span[@class='ui-button-text ui-clickable']")));
			newpopup.click();

		} catch (Exception e) {
			WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
			submit.click();

		}

	}
}
