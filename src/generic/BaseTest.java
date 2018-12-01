package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	@BeforeMethod
	public void launchApplication(){
		driver = new FirefoxDriver();
		driver.get(Lib.getPropertyValue("URL"));
		String implicitTimeOut = Lib.getPropertyValue("ImplicitTimeOut");
driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitTimeOut),
		TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		
		if (ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreenshots(driver, res.getName());
		}
		driver.close();
}}
