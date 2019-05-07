/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.LoginPage;
import pageobjects.PreOnboarding;
import pageobjects.ProgressPage;
import pageobjects.RewardsPage;
import pageobjects.TrackersPage;
import pageobjects.CommonMethods;
import step_definitions.CommonSteps;;

/**
 * @author ravibadugu
 *
 */
public class ProgressSteps {
	
	public IOSDriver<IOSElement> driver;
	LoginPage login;
	PreOnboarding preon; 
	ProgressPage progress;
	TrackersPage trackers;
	Actions actions;
	TouchAction ta;
	MultiTouchAction mta;
	Dimension dimensions; 
	CommonMethods common;
	
	String LastPeriodValueBeforeAdd = "";
	String RandomlySelectedWidget = "";
	
	public ProgressSteps()
    {
		driver = Launcher.driver;
		login = new LoginPage(driver);
    	preon = new PreOnboarding(driver);
    	progress = new ProgressPage(driver);
    	trackers = new TrackersPage(driver);
    	actions = new Actions(driver);
    	ta = new TouchAction(driver);
    	mta = new MultiTouchAction(driver);
    	dimensions = driver.manage().window().getSize();
    	common = new CommonMethods(driver);
    }

	@When("^I select \'(.*?)\' widget$")
	public void I_select_widget_option(String widgetname) throws Throwable {
		System.out.println("Executing: When I select "+widgetname+" widget");
		// common.TapOn(ProgressPage.TapProgressButton);
		switch (widgetname) {
		case "Weight":
			common.AssertTextOfElement(progress.WeightInSelectWidgetScreenOption, widgetname);
			common.TapOn(progress.WeightInSelectingWidgetScreen);
			break;
		case "Sleep":
			common.AssertTextOfElement(progress.SleepInSelectWidgetScreenOption, widgetname);
			common.TapOn(progress.TapSleepInSelectingWidgetScreen);
			break;
		case "Calories Intake":
			common.AssertTextOfElement(progress.CaloriesIntakeInSelectWidgetScreenOption, widgetname);
			common.TapOn(progress.TapCaloriesIntakeInSelectingWidgetScreen);
			break;
		case "Steps":
			common.AssertTextOfElement(progress.ActivityInSelectWidgetScreenOption, "Activity");
			common.TapOn(progress.ActivityInSelectWidgetScreenOption);
			common.AssertTextOfElement(progress.StepsInSelectWidgetScreenOption, widgetname);
			common.TapOn(progress.StepsInSelectWidgetScreenOption);
			break;
		}		
	}

	@When("^I set the \'(.*?)\' goal to achieve and tap on Set Goal$")
	public void I_set_the_Weight_goal_to_achieve_and_tap_on_Set_Goal(String widgetname) throws Throwable {
		System.out.println("Executing: When I set the "+widgetname+" goal to achieve and tap on Set Goal");
		//progress.currentSlider();
		switch (widgetname) {
		case "Weight":
			common.TapOn(progress.SetGoalButton);
			break;
		case "Sleep":
			common.TapOn(progress.SetGoalButton);
			break;
		case "Calories Intake":
			common.TapOn(progress.SetGoalButton);
			break;
		case "Steps":
			common.TapOn(progress.SetGoalButton);
			break;
		}
	}

	@Then("^I should see the \'(.*?)\' widget in Progress Page with Target Goal and Latest data in the widget$")
	public void I_should_see_the_widget_in_Progress_Page_with_Target_Goal_and_Latest_data_in_the_widget(String widgetname) throws Throwable {
		System.out.println("Executing: Then I should see the "+widgetname+" widget in Progress Page with Target Goal and Latest data in the widget");
		progress.VerifyingTargetOnWidget(widgetname);
		WebElement lastPeriod = null;
		switch (widgetname) {
		case "Weight":
			lastPeriod = progress.LastPeriodTextWeightWidget;
			break;
		case "Sleep":
			lastPeriod = progress.LastPeriodTextSleepWidget;
			break;
		case "Calories Intake":
			lastPeriod = progress.LastPeriodTextCaloriesWidget;
			break;
		case "Steps":
			lastPeriod = progress.LastPeriodTextStepsWidget;
			break;
		}
		common.AssertIsDisplayed(lastPeriod);
	}
	
	@When("^I ensure the (.*?) widget is visible")
	public void I_ensure_widget_is_visible(String widget) throws Throwable {
		System.out.println("Executing: When I ensure the "+widget+" widget is visible");
		common.AssertTextOfElement(progress.ProgressPageHeaderTitle, "Progress");
		Double screenHeightStart = dimensions.getHeight() * 0.7;
		int scrollStart = screenHeightStart.intValue();
	    Double screenHeightEnd = dimensions.getHeight() * 0.2;
	    int scrollEnd = screenHeightEnd.intValue();	    
		String direction = "bottom";
		common.scrollPage(driver, direction);
		Thread.sleep(4000);
		int isOnPage = driver.findElementsByXPath("//XCUIElementTypeStaticText[@name='"+widget+"']").size();
		int isHidden = driver.findElementsByXPath("//XCUIElementTypeStaticText[@name='"+widget+"'][@visible='false']").size();
		if (isOnPage == 0) {
			System.out.println("Element not on page");
			//add widget
			common.TapOn(progress.AddGoalButton);
			switch (widget) {
			case "Weight":
				common.AssertTextOfElement(progress.WeightInSelectWidgetScreenOption, widget);
				common.TapOn(progress.WeightInSelectingWidgetScreen);
				break;
			case "Sleep":
				common.AssertTextOfElement(progress.SleepInSelectWidgetScreenOption, widget);
				common.TapOn(progress.TapSleepInSelectingWidgetScreen);
				break;
			case "Calories Intake":
				common.AssertTextOfElement(progress.CaloriesIntakeInSelectWidgetScreenOption, widget);
				common.TapOn(progress.TapCaloriesIntakeInSelectingWidgetScreen);
				break;
			case "Steps":
				common.AssertTextOfElement(progress.ActivityInSelectWidgetScreenOption, "Activity");
				common.TapOn(progress.ActivityInSelectWidgetScreenOption);
				common.AssertTextOfElement(progress.StepsInSelectWidgetScreenOption, widget);
				common.TapOn(progress.StepsInSelectWidgetScreenOption);
				break;
			}
			common.TapOn(progress.SetGoalButton);
			Thread.sleep(5000);			
		}
		if (isHidden >= 1) {
			System.out.println("Element is hidden");
			//scroll to the element
			for (int i = 0; i < 2; i++) {
		    	driver.swipe(0,scrollEnd,0,scrollStart,2000);
		    	if (isHidden == 0) {
					break;
				}
			}
		}
	}

	@When("^I open Contextual menu of a( \'(.*?)\')? widget$")
	public void I_open_Contextual_menu_of_a_widget(String isRandom, String widget) throws Throwable {
		System.out.println("Executing: I open Contextual menu of a "+widget+" widget");
		Thread.sleep(2000);
		common.AssertTextOfElement(progress.ProgressPageHeaderTitle, "Progress");
		if (isRandom == null) {
			WebElement WidgetTitle = driver.findElementByXPath("(//XCUIElementTypeOther/XCUIElementTypeStaticText[1])[1]");
			RandomlySelectedWidget = WidgetTitle.getText();
			common.TapOn(progress.IconMoreOnWidget);		 	
			}
		else {
			switch (widget) {
			case "Weight":
				// LastPeriodValueBeforeAdd = progress.LastPeriodWeightValue.getText();
				common.TapOn(progress.ContextMenuWeightWidget);
				break;
			case "Sleep": 
				LastPeriodValueBeforeAdd = progress.LastPeriodSleepValue.getText();
				common.TapOn(progress.ContextMenuSleepWidget);
				break;
			case "Calories Intake":
				// LastPeriodValueBeforeAdd = progress.LastPeriodCaloriesValue.getText();
				common.TapOn(progress.ContextMenuCaloriesWidget);
				break;
			case "Steps":
				LastPeriodValueBeforeAdd = progress.LastPeriodStepsValue.getText();
				common.TapOn(progress.ContextMenuStepsWidget);
				break;
			}
		}
	}
	
	@When("^I open Contextual menu on current page$")
	public void I_open_contextual_menu_on_current_page() throws Throwable {
		System.out.println("Executing: I open Contextual menu on current page");
		common.TapOn(common.OverflowMenu);
	}
	
	@When("^I open (.*?) widget detail page$")
	public void I_open_widget_detail_page(String widget) throws Throwable {
		System.out.println("Executing: I open "+widget+" widget detail page");
		WebElement widgetClick = null;
		switch (widget) {
		case "Weight": widgetClick = progress.TargetOnWeightWidget; break;
		case "Sleep": widgetClick = progress.TargetOnSleepWidget; break;
		case "Calories Intake": widgetClick = progress.TargetOnCaloriesWidget; break;
		}
		common.TapOn(widgetClick);
	}
	
	@When("^I log the following datapoint value: (\\d+) for the \'(.*?)\'$")
	public void I_log_the_value(double logValue, String widget) throws Throwable {
		System.out.println("Executing: log the following datapoint value: "+logValue+" for the "+widget);
		switch (widget) {
		case "Weight":
			break;
		case "Sleep":
			break;
		case "Calories Intake":
			break;
		}
	}
	
	@Then("^every widget has all expected elements$")
	public void every_widget_has_expected_elements() throws Throwable {
		System.out.println("Executing: every widget has all expected elements");
		String widget = "//XCUIElementTypeCell[@visible='true']";
		int countWidgets = driver.findElementsByXPath(widget).size();
		for (int i = 1; i <= countWidgets; i++) {
			WebElement WidgetTitle = driver.findElementByXPath("(//XCUIElementTypeOther/XCUIElementTypeStaticText[1])["+i+"]");
			String ForWidget = WidgetTitle.getText();
			WebElement TargetValue = driver.findElementByXPath("(//XCUIElementTypeCell//XCUIElementTypeStaticText[5])["+i+"]");
			WebElement TargetString = driver.findElementByXPath("(//XCUIElementTypeCell//XCUIElementTypeStaticText[@name='Target'])["+i+"]"); 
			WebElement IconMore = driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"icon more\"])["+i+"]");
			WebElement WidgetImage = driver.findElementByXPath("(//XCUIElementTypeImage)["+i+"]");
			assertTrue("FAIL! WidgetTitle for"+ForWidget+" not enabled", WidgetTitle.isEnabled());
			assertTrue("FAIL! TargetValue for "+ForWidget+" not enabled", TargetValue.isEnabled());
			assertTrue("FAIL! TargetString for "+ForWidget+" not enabled", TargetString.isEnabled());
			assertTrue("FAIL! Icon more for "+ForWidget+" not enabled", IconMore.isEnabled());	
			assertTrue("FAIL! WidgetImage for "+ForWidget+" not enabled", WidgetImage.isEnabled());
		}
	}
	
	@When("^I switch the timeframe tab to \'(2 months|Week)\'$")
	public void I_switch_timeframe_tab(String tab) throws Throwable {
		System.out.println("Executing: When I switch the timeframe tab to "+tab);
		WebElement whichTab = null;
		switch (tab) {
		case "2 months": whichTab = progress.TwoMonthsSwitchInGraphViewScreen; break;
		case "Week": whichTab = progress.WeekSwitchInGraphViewScreen; break;
		}
		common.TapOn(whichTab);
	}
	
	@When("^I log the default value (in the past )?for the \'(.*?)\'$")
	public void I_log_default_value_for_widget(String past, String widget) throws Throwable {
		System.out.println("Executing: When I log the default value "+past+"for the "+widget);
		switch (widget) {
		case "Calories Intake":
			progress.LogCaloriesInputField.sendKeys("2000");
			break;
		case "Steps":
			progress.LogStepsInputField.sendKeys("1000");
			break;
		default:
			break;
		}
		if (past != null) {
			common.TapOn(progress.ChangeDayTimeInLogDataScreen);
			Thread.sleep(2000);
			Double screenTouch = dimensions.getHeight() * 0.75;
			int intscreenTouch = screenTouch.intValue();
			ta.press(70, intscreenTouch).waitAction(1000).release();
			mta.add(ta).perform();
			Thread.sleep(2000);
			common.TapOn(progress.DoneButton);
			Thread.sleep(2000);
			System.out.println("Past date set");
		}
		common.TapOn(progress.SaveBtnInLogDataScreen);
	}
	
	// needs improvement
	@Then("^I should see the \'(.*?)\' widget in Progress Page and the value in the widget is (NOT )?changed$")
	public void I_see_the_widget_and_value_is_changed(String widget, String isnot) throws Throwable {
		System.out.println("Executing: Then I should see the "+widget+" widget in Progress Page and the value in the widget is "+isnot+"changed");
		switch (widget) {
		case "Weight":
			assertTrue("FAIL! Weight value not displayed",progress.LastPeriodWeightValue.isDisplayed());
			break;
		case "Sleep":
			String LastPeriodSleepAfterAdd = progress.LastPeriodSleepValue.getText();
			if (isnot == null) {
				Assert.assertFalse("FAIL! The last period value has not changed", LastPeriodSleepAfterAdd == LastPeriodValueBeforeAdd);
				break;
			} else {
				break;
			}
		case "Calories Intake":
			assertTrue("FAIL! Calories Intake value not displayed",progress.LastPeriodCaloriesValue.isDisplayed());
			break;
		case "Steps":
			String LastPeriodStepsAfterAdd = progress.LastPeriodStepsValue.getText();
			if (isnot == null) {
				Assert.assertFalse("FAIL! The last period value has not changed", LastPeriodStepsAfterAdd == LastPeriodValueBeforeAdd);
				break;
			} else {
				assertTrue("FAIL! The last period value has changed", LastPeriodStepsAfterAdd == LastPeriodValueBeforeAdd);
				break;
			}
		}
	}

	@Then("^the widget is removed from Progress Page$")
	public void I_should_see_the_widget_is_removed_from_Progress_Page() throws Throwable {
		System.out.println("Executing: Then the widget is removed from Progress Page");
		int WidgetTitles = driver.findElementsByXPath("(//XCUIElementTypeOther/XCUIElementTypeStaticText[@label='"+RandomlySelectedWidget+"'])").size();
		assertTrue("FAIL! The widget should be removed", WidgetTitles < 1);
	}
	
	//Progress19 Progress20 Progress18
	@When("^I see the (.*?) Option in the list and tap on it$")
	public void tap_progress_widget_context_menu_option(String option) throws Throwable {
		System.out.println("Executing: When I see the "+option+" Option in the list and tap on it");
		WebElement ContextElement = null;
		switch (option) {
		case "Connect Tracker": ContextElement = progress.TapConnectTrackerOptionInConMenuOnWidget; break;
		case "Log Data": ContextElement = progress.TapLogDataOptionInConMenuOnWidget; break;
		case "Remove": ContextElement = progress.TapRemoveOptionInConMenuOnWidget; break;
		case "Edit Goal": ContextElement = progress.TapEditgoalOptionInConMenuOnWidget; break;
		case "View all data": ContextElement = progress.ViewalldataBTNInWidgetDetScrnConMenu; break;
		}
		common.TapOn(ContextElement);
	}
	
	@Then("^I see (\\d+) less editable datapoints$")
	public void see_less_datapoints(int numberOfDatapoints) throws Throwable {
		System.out.println("Executing: Then I see "+numberOfDatapoints+" less editable datapoints");
		int newNumberOfDatapoints = driver.findElementsByXPath("//XCUIElementTypeCell/*[contains(@label,'Edit')]").size();
		assertTrue("The number of datapoints did not decrease by "+numberOfDatapoints,common.NumberOfOccurance - newNumberOfDatapoints == numberOfDatapoints);
	}

}
