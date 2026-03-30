package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestBase {

	public static Properties prop;
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Page launchBrowser(String browserName) {
		playwright = Playwright.create();
		if(browserName.equalsIgnoreCase("chromium")) {
			browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}else if(browserName.equalsIgnoreCase("firefox")) {
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}else if(browserName.equalsIgnoreCase("edge")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}else if(browserName.equalsIgnoreCase("chrome")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		}else{
			System.out.println("Invalid Browser, Please use the correct browser");
		}
		
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		
		return page;
	}
}
