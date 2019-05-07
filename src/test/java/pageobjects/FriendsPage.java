/**
 * 
 */
package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author ravibadugu
 *
 */
public class FriendsPage {
	
	public FriendsPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	@iOSFindBy(id="Following")
//	public WebElement VerifyFollowingPageTittle;
//	public FriendsPage VerifyingFollowingPageTittle() {
//		VerifyFollowingPageTittle.getText();
//		VerifyFollowingPageTittle.isDisplayed();
//		return this;
//	}
	
	@iOSFindBy(id="Edit settings")
	public IOSElement TapOnAccountIcon;
	public FriendsPage TappingOnAccountIcon() {
		TapOnAccountIcon.click();
		return this;
	}
	
	@iOSFindBy(id="Friends")
	public IOSElement TapOnFriends;
	public FriendsPage TappingOnFriends() {
		TapOnFriends.click();
		return this;
	}
	
	@iOSFindBy(id="Account")
	public IOSElement TapOnBackButtonToAccount;
	public FriendsPage TappingOnBackButtonToAccount() {
		TapOnBackButtonToAccount.click();
		return this;
	}
	
	@iOSFindBy(id="Close")
	public IOSElement TapOnCloseButtonFromAccount;
	public FriendsPage TappingOnCloseButtonFromAccount() {
		TapOnCloseButtonFromAccount.click();
		return this;
	}
	
	@iOSFindBy(id="Following")
	public IOSElement TapOnFollowingButton;
	public FriendsPage TappingOnFollowingButton() {
		TapOnFollowingButton.click();
		return this;
	}
	
	@iOSFindBy(id="Followers")
	public IOSElement TapOnFollowersButton;
	public FriendsPage TappingOnFollowersButton() {
		TapOnFollowersButton.click();
		return this;
	}
	
	@iOSFindBy(id="Requests")
	public IOSElement TapOnRequestsButton;
	public FriendsPage TappingOnRequestsButton() {
		TapOnRequestsButton.click();
		return this;
	}
	
	@iOSFindBy(id="Add")
	public IOSElement TapOnAddButton;
	public FriendsPage TappingOnAddButton() {
		TapOnAddButton.click();
		return this;
	}
	
	@iOSFindBy(id="Following")
	public IOSElement TapOnBackButtonToFriendsPage;
	public FriendsPage TappingOnBackButtonToFriendsPage() {
		TapOnBackButtonToFriendsPage.click();
		return this;
	}
	
	@iOSFindBy(id="Find People")
	public IOSElement VerifyFindPeoplePageTittle;
	public FriendsPage VerifyingFindPeoplePageTittle() {
		VerifyFindPeoplePageTittle.getText();
		VerifyFindPeoplePageTittle.isDisplayed();
		return this;
	}
	
	@iOSFindBy(id="Find people to follow")
	public IOSElement TapOnFindPeopleTextBox;
	public FriendsPage TappingOnFindPeopleTextBox() {
		TapOnFindPeopleTextBox.click();
		return this;
	}
	
	@iOSFindBy(id="Find people to follow")
	public IOSElement ClearOnFindPeopleTextBox;
	public FriendsPage ClearingOnFindPeopleTextBox() {
		ClearOnFindPeopleTextBox.clear();
		return this;
	}
	
	@iOSFindBy(id="Find people to follow")
	public IOSElement EnterFindPeopleTextBox;
	public FriendsPage EnteringFindPeopleTextBox() {
		EnterFindPeopleTextBox.sendKeys("Ravi Badugu");
		return this;
	}
	
	@iOSFindBy(id="Done")
	public IOSElement TapOnDoneNextToFindPeopleTextBox;
	public FriendsPage TappingOnDoneNextToFindPeopleTextBox() {
		TapOnDoneNextToFindPeopleTextBox.click();
		return this;
	}
	
	@iOSFindBy(id="add")
	public IOSElement TapOnAddButtonNextToResult;
	public FriendsPage TappingOnAddButtonNextToResult() {
		TapOnAddButtonNextToResult.click();
		return this;
	}
	
	@iOSFindBy(id="Ravi Badugu")
	public IOSElement VerifySearchResult;
	public FriendsPage VerifyingSearchResult() {
		VerifySearchResult.getText();
		VerifySearchResult.isDisplayed();
		return this;
	}


}
