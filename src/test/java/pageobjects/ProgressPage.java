package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProgressPage {

//	private static final SwipeElementDirection Right = null;
//	private static final SwipeElementDirection left = null;
	IOSDriver<IOSElement> driver;

	public ProgressPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 25, TimeUnit.SECONDS), this);
	}
	
	// Navigation

	@iOSFindBy(id = "Progress")
	public WebElement NavProgressButton;
	
	// Major buttons

	@iOSFindBy(id = "Add goal")
	public IOSElement AddGoalButton;

	@iOSFindBy(id = "Set goal")
	public IOSElement SetGoalButton;

	@iOSFindBy(id = "Back")
	public IOSElement BackButton;

	@iOSFindBy(id = "Close")
	public IOSElement CloseButton;
	
	@iOSFindBy(id = "Done")
	public IOSElement DoneButton;
	
	@iOSFindBy(id = "Edit")
	public IOSElement EditButton;
	
	// Progress page

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeOther[@name='Progress']")
	public IOSElement ProgressPageHeaderTitle;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[@visible='true']")
	public IOSElement ProgressWidget;

	// Selecting widgets 
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement WeightInSelectingWidgetScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sleep']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapSleepInSelectingWidgetScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Calories Intake']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapCaloriesIntakeInSelectingWidgetScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Activity']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapActivityInSelectingWidgetScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Steps']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapStepsInSelectAnActivityScreen;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swimming']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement SwimmingInSelectAnActivityScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Duration']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapDurationToTrackYourProgress;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Distance']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapDistanceToTrackYourProgress;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Workout']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapWorkoutInSelectAnActivityScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cycling']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapCyclingInSelectAnActivityScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Running']/preceding-sibling::XCUIElementTypeImage")
	public IOSElement TapRunningInSelectAnActivityScreen;
	
	// Widgets on Progress page
	
	@iOSFindBy(id = "Weight")
	public IOSElement WeightInSelectWidgetScreenOption;
	
	@iOSFindBy(id = "Sleep")
	public IOSElement SleepInSelectWidgetScreenOption;
	
	@iOSFindBy(id = "Calories Intake")
	public IOSElement CaloriesIntakeInSelectWidgetScreenOption;
	
	@iOSFindBy(id = "Activity")
	public IOSElement ActivityInSelectWidgetScreenOption;
	
	@iOSFindBy(id = "Steps")
	public IOSElement StepsInSelectWidgetScreenOption;

	public ProgressPage VerifyingTargetOnWidget(String txt) {
		switch (txt) {
		case "Weight":
			TargetOnWeightWidget.isDisplayed();
			break;
		case "Sleep":
			TargetOnSleepWidget.isDisplayed();
			break;
		case "Calories Intake":
			TargetOnCaloriesWidget.isDisplayed();
			break;
		}
		return this;
	}

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight']/following-sibling::XCUIElementTypeStaticText[@name='Target']")
	public IOSElement TargetOnWeightWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sleep']/following-sibling::XCUIElementTypeStaticText[@name='Target']")
	public IOSElement TargetOnSleepWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Calories Intake']/following-sibling::XCUIElementTypeStaticText[@name='Target']")
	public IOSElement TargetOnCaloriesWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight']/following-sibling::XCUIElementTypeStaticText[@name='Latest']")
	public IOSElement LastPeriodTextWeightWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sleep']/following-sibling::XCUIElementTypeStaticText[@name='Last night']")
	public IOSElement LastPeriodTextSleepWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Calories Intake']/following-sibling::XCUIElementTypeStaticText[@name='Latest']")
	public IOSElement LastPeriodTextCaloriesWidget;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Steps']/following-sibling::XCUIElementTypeStaticText[@name='Today']")
	public IOSElement LastPeriodTextStepsWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight']/following-sibling::XCUIElementTypeStaticText[1]")
	public IOSElement LastPeriodWeightValue;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sleep']/following-sibling::XCUIElementTypeStaticText[1]")
	public IOSElement LastPeriodSleepValue;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Calories Intake']/following-sibling::XCUIElementTypeStaticText[1]")
	public IOSElement LastPeriodCaloriesValue;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Steps']/following-sibling::XCUIElementTypeStaticText[1]")
	public IOSElement LastPeriodStepsValue;
	
	// Context menu Progress page

	@iOSFindBy(xpath = "//XCUIElementTypeOther[.//XCUIElementTypeStaticText[@name='Sleep']]/following-sibling::XCUIElementTypeButton[@name='icon more']")
	public IOSElement ContextMenuSleepWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[.//XCUIElementTypeStaticText[@name='Weight']]/following-sibling::XCUIElementTypeButton[@name='icon more']")
	public IOSElement ContextMenuWeightWidget;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[.//XCUIElementTypeStaticText[@name='Calories Intake']]/following-sibling::XCUIElementTypeButton[@name='icon more']")
	public IOSElement ContextMenuCaloriesWidget;
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[.//XCUIElementTypeStaticText[@name='Steps']]/following-sibling::XCUIElementTypeButton[@name='icon more']")
	public IOSElement ContextMenuStepsWidget;

	@iOSFindBy(id = "icon more")
	public IOSElement IconMoreOnWidget;
	
	@iOSFindBy(id = "Log Data")
	public IOSElement TapLogDataOptionInConMenuOnWidget;
	
	@iOSFindBy(id = "Connect Tracker")
	public IOSElement TapConnectTrackerOptionInConMenuOnWidget;

	@iOSFindBy(id = "Edit goal")
	public IOSElement TapEditgoalOptionInConMenuOnWidget;

	@iOSFindBy(id = "Remove")
	public IOSElement TapRemoveOptionInConMenuOnWidget;

	@iOSFindBy(id = "Cancel")
	public IOSElement TapCancelOptionInConMenuOnWidget;
	
	// Weight widget

	@iOSFindBy(id = "ruler-segment")
	public IOSElement GoalSlider;

	public ProgressPage SlidingGoal() {
		TouchAction myAction = new TouchAction(driver);
		// mention the X,Y offset and start and end points
		myAction.press(0, 225).moveTo(-20, 225).release().perform();
		System.out.println(GoalSlider.getAttribute("value"));
		// GoalSlider.swipe(Right, 6000);
		System.out.println(GoalSlider.getCenter());
		return this;
	}

	// public void currentSlider() throws InterruptedException {
	// Thread.sleep(2000);
	// IOSElement currentGoalSlider = (IOSElement)
	// driver.findElement(By.id("ruler-segment"));
	// IOSElement currentValue = (IOSElement) driver.findElement(By.id("75 kg"));
	//
	// moveSliderInDirection(currentValue, currentGoalSlider, 60);
	// }
	//
	// private void moveSliderInDirection(IOSElement currentValue, IOSElement
	// currentGoalSlider, int desiredTestValue) {
	// Actions move = new Actions(driver);
	// move.click(currentGoalSlider).build().perform();
	//
	// do { Integer.parseInt(currentValue.getText());
	// if (Integer.parseInt(currentValue.getText()) != desiredTestValue &&
	// (Integer.parseInt(currentValue.getText()) > desiredTestValue)) {
	// move.sendKeys(Keys.ARROW_RIGHT).build().perform();
	// } else if (Integer.parseInt(currentValue.getText()) != desiredTestValue &&
	// (Integer.parseInt(currentValue.getText()) < desiredTestValue)) {
	// move.sendKeys(Keys.ARROW_LEFT).build().perform();
	// }
	// } while (Integer.parseInt(currentValue.getText())!=desiredTestValue);
	// }

	// Calories widget

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CALORIES\"]/preceding-sibling::XCUIElementTypeTextField")
	public IOSElement LogCaloriesInputField;
	
	// Steps widget
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"STEPS\"]/preceding-sibling::XCUIElementTypeTextField")
	public IOSElement LogStepsInputField;
	
	// Log data

	@iOSFindBy(id = "Save")
	public IOSElement SaveBtnInLogDataScreen;

	@iOSFindBy(id = "Change day / time")
	public IOSElement ChangeDayTimeInLogDataScreen;
	
	// Sleep widget

	@iOSFindBy(id = "WENT TO SLEEP YESTERDAY")
	public IOSElement VerifyText1InLogSleepScreen;

	@iOSFindBy(id = "WOKE UP TODAY")
	public IOSElement VerifyText2InLogSleepScreen;

	// Widget details screen

	@iOSFindBy(id = "Week")
	public IOSElement WeekSwitchInGraphViewScreen;

	@iOSFindBy(id = "2 Months")
	public IOSElement TwoMonthsSwitchInGraphViewScreen;

	@iOSFindBy(id = "Log data")
	public IOSElement LogdataBTNInGraphViewScreen;

	@iOSFindBy(id = "Connect tracker")
	public IOSElement ConnecttrackerBTNInGraphViewScreen;

	@iOSFindBy(id = "Edit goal")
	public IOSElement EditgoalBTNInWidgetDetScrnConMenu;

	@iOSFindBy(id = "View all data")
	public IOSElement ViewalldataBTNInWidgetDetScrnConMenu;

	@iOSFindBy(id = "Cancel")
	public IOSElement CancelBTNInWidgetDetScrnConMenu;
	
	@iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label,'a Fact')]")
	public IOSElement FactSectionOnWidgetDetail;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@label='Edit'])[1]")
	public IOSElement FirstEditDatapointButton;
	
	@iOSFindBy(id = "Delete")
	public IOSElement DeleteDatapointButton;

}
