/**
 * 
 */
package pageobjects;

/**
 * @author ravibadugu
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ActionPlanPage {
	
	
	public  ActionPlanPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Plans")
	public IOSElement navPlansButton;
	
	@iOSFindBy(id="Start new plan")
	public IOSElement startNewPlanButton;
	
	@iOSFindBy(id="Join Action Plan")
	public IOSElement JoinActionPlanButton;
	
	@iOSFindBy(id="Share")
	public IOSElement ShareActionPlanButton;
	
	@iOSFindBy(id="Done today")
	public IOSElement DoneTodayButton;
	
	@iOSFindBy(id="Change habit")
	public IOSElement ChangeHabitButton;
	
	@iOSFindBy(id="Show description")
	public IOSElement ShowDescriptionButton;
	
	@iOSFindBy(id="Hide description")
	public IOSElement HideDescriptionButton;
	
	@iOSFindBy(id="Leave Action Plan")
	public IOSElement LeaveActionPlanText;

	@iOSFindBy(id="Are you sure you want to leave the Action Plan?")
	public IOSElement LeaveAPPopUpText;
	
	@iOSFindBy(id="Leave")
	public IOSElement LeavePopUpButton;
	
	@iOSFindBy(id="Checked off today")
	public IOSElement checkedOffTodayButton;
	
	@iOSFindBy(id="tick")
	public IOSElement tickButton;
	
	@iOSFindBy(id="Commit to this")
	public IOSElement CommitToThisButton;

}