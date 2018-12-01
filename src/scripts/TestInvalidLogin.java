package scripts;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin(){
		LoginPage lp =  new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		System.out.println(rowCount);
		//enter username
		for (int row = 1; row < rowCount; row++) {
			String username = Lib.getCellValue("InvalidLogin", row, 0);
			lp.setUsername(username);
			//enter password
			String password = Lib.getCellValue("InvalidLogin", row, 1);
			lp.setPassword(password);
			//click on login button
			lp.clickLogin();
		}
	}
}
