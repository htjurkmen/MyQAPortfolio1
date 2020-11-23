import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderMenu {
	public void clickProfileLink(WebDriver driver) {
		WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
		profileLink.click();
	}
	
	public void clickLoginLink(WebDriver driver) {
		WebElement loginLink = driver.findElement(By.id("nav-link-login"));
		loginLink.click();
	}

}
