import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver localDriver;
	
	public LoginPage(WebDriver driver) {
		localDriver = driver;
	}
	
	WebElement loginButton = localDriver.findElement(By.id("sign-in-button"));
	
	public void login(WebDriver driver, String username, String password) {
		HeaderMenu header = new HeaderMenu();
		header.clickLoginLink(driver);
		WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
		usernameField.sendKeys(username);
		WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
		passwordField.sendKeys(password);
		loginButton.click();		
	}
	
	public boolean compareBtnColor(WebDriver driver, String expectedColor) {
		String btnColor = loginButton.getCssValue("background-color");
		if(expectedColor.equals(btnColor)) {
			return true;
		} else {
			return false;
		}
	}
}
