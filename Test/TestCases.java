import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestCases {

	WebDriver driver;

	@Test
	void SuccessfullLogin() {
		Helper.navigateToPage(driver, "http://training.skillo-bg.com:4300/posts/all");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(driver, "Teddy100", "Teddy100");
		HeaderMenu headerMenu = new HeaderMenu();
		headerMenu.clickProfileLink(driver);
		ProfilePage profile = new ProfilePage();
		Assertions.assertTrue(profile.checkProfileName(driver, "Teddy100"));		
		Assertions.assertEquals("Teddy100", profile.getProfileNameText(driver, "Teddy100"));	
	}
	
	@Test
	void CheckIfLoginButtonIsBlue() {
		Helper.navigateToPage(driver, "http://training.skillo-bg.com:4300/posts/all");
		HeaderMenu headerMenu = new HeaderMenu();
		headerMenu.clickLoginLink(driver);	
		LoginPage loginPage = new LoginPage(driver);		
		Assertions.assertTrue(loginPage.compareBtnColor(driver, "rgba(33, 150, 243, 1)"));
	}

	@Test
	void newPostFromHeaderMenu() {
		driver.get("http://training.skillo-bg.com:4300/posts/all");
		WebElement loginLink = driver.findElement(By.id("nav-link-login"));
		loginLink.click();
		WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
		usernameField.sendKeys("Teddy100");
		WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
		passwordField.sendKeys("Teddy100");
		WebElement loginButton = driver.findElement(By.id("sign-in-button"));
		loginButton.click();
		
		WebElement newPostLink = driver.findElement(By.id("nav-link-new-post"));
		newPostLink.click();
		WebElement postText = driver.findElement(By.xpath("//app-create-post//h3[contains(text(),'Post a picture to share with your awesome follower')]"));
		Assertions.assertEquals("Post a picture to share with your awesome followers", postText.getText());
		Assertions.assertTrue(postText.isDisplayed());
		
		WebElement dropAnImageText = driver.findElement(By.xpath("//app-create-post//label[contains(text(),'Drop an Image here')]"));
		Assertions.assertEquals("Drop an Image here", dropAnImageText.getText());
		Assertions.assertTrue(dropAnImageText.isDisplayed());
		
		WebElement createPostBtn = driver.findElement(By.id("create-post"));
		Assertions.assertTrue(createPostBtn.isDisplayed());
		Assertions.assertTrue(createPostBtn.isEnabled());
	}

	@AfterEach
	void cleanUp() {
		driver.close();
	}

	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\skillo\\Downloads\\chromedriver_latest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
}
