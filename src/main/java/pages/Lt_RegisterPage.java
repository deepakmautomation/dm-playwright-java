package pages;

import com.microsoft.playwright.Page;

public class Lt_RegisterPage {

	Page page;

	private final String firstName = "#input-firstname";
	private final String lastName = "//input[@id='input-lastname']";
	private final String continueButton = "input[value='Continue']";

	public Lt_RegisterPage(Page rPage) {
		this.page = rPage;
	}

	public void enterFirstName(String fname) {
		//page.fill(firstName, fname); // This also works.
		page.locator(firstName).fill(fname); 
		page.pause();
	}

	public void enterLastName(String lname) {
		page.locator(lastName).fill(lname);
	}
	
	public void clickContinue() {
		page.locator(continueButton).click();
	}
}
