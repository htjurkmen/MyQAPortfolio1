import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
	public boolean checkProfileName(WebDriver driver, String profileName) {
		WebElement alabala = driver.findElement(By.xpath("//app-profile//h2[contains(text()," + profileName + ")]"));		
		if(alabala != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getProfileNameText(WebDriver driver, String profileName) {
		WebElement alabala = driver.findElement(By.xpath("//app-profile//h2[contains(text()," + profileName + ")]"));		
		return alabala.getText();
	}

}
