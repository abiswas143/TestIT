package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin(){
		LoginPage lp =  new LoginPage(driver);
		//enter username
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		lp.setUsername(username);
		//enter password
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
		/*String aHPTitle = driver.getTitle();
		if (aHPTitle.equals("I dont know")) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed..");
		}*/
		//Explicit wait to wait till the home page is loaded
		WebDriverWait wait = new WebDriverWait(driver, 13);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		String aHPTitle = driver.getTitle();
		Assert.assertEquals(aHPTitle, "actiTIME - Enter Time-Track");
	}
}
