package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactrUsPage {

	//Declaration
	@FindBy(xpath ="//img[contains(@src,'contactus')]")
	private WebElement contactUsIcon;
	
	@FindBy(name ="name")
	private WebElement fullNameTF;
	
	@FindBy(name = "sender")
	private WebElement emailTF;
	
	@FindBy(name ="subject")
	private WebElement subjectTF;
	
	@FindBy(name ="messgae")
	private WebElement messageTextArea;
	
	@FindBy(xpath ="//button[text()='Send us mail]")
	private WebElement sendUsMailButton;
	
	//Initialization
	public ContactrUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	
	/**
	 * This method returns contact us page icon
	 * @return
	 */
	public WebElement getContactUsIcon() {
		return contactUsIcon;
	}
	
	/**
	 * This method is used to send contact details to skillrary
	 * @param fullname
	 * @param email
	 * @param subject
	 * @param message
	 */
	public void sendContactInfo(String fullname, String email, String subject, String message) {
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
		sendUsMailButton.click();
	}
}
