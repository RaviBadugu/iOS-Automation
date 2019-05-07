/**
 * 
 */
package step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageobjects.LibraryPage;
import pageobjects.CommonMethods;

/**
 * @author ravibadugu
 *
 */
public class LibrarySteps {
	
	public IOSDriver<IOSElement> driver; 
	LibraryPage library;
	Random rand;
	CommonMethods common;
	
	String articleTileTitle = "";
	String topicTileTitle = "";
	
	public LibrarySteps()
    {
		driver = Launcher.driver;
    	library = new LibraryPage(driver);
    	rand = new Random();
    	common = new CommonMethods(driver);
    }

	@Then("^I Should see Recommended and Topics sections in the screen$")
	public void I_Should_see_Recommended_and_Topics_sections_in_the_screen() throws Throwable {
		System.out.println("Executing Then I Should see Recommended and Topics sections in the screen");
		common.AssertIsDisplayed(library.RecommendedSwitchButton);
		common.AssertIsDisplayed(library.TopicsSwitchButton);
	}
	
	@When("^I open an article( from the Topic list)?$")
	public void I_open_an_article(String isTopic) throws Throwable {
		System.out.println("Executing: When I open an article "+isTopic);
		Thread.sleep(4000);
		int articles_list = driver.findElementsByXPath("//XCUIElementTypeCell[@visible='true']").size();
		if (articles_list > 0) {
			int randomlySelectedArticle = rand.nextInt(articles_list) + 1;
			if (isTopic == null) {
				articleTileTitle = driver.findElementByXPath("(//XCUIElementTypeCell)["+randomlySelectedArticle+"]//XCUIElementTypeStaticText[2]").getAttribute("label");
			} else {
				articleTileTitle = driver.findElementByXPath("(//XCUIElementTypeCell)["+randomlySelectedArticle+"]//XCUIElementTypeStaticText[1]").getAttribute("label");
			}	
			System.out.println("Attempt to open the Article: "+articleTileTitle);
			driver.findElementByXPath("(//XCUIElementTypeCell)["+randomlySelectedArticle+"]").click();
		} else {
			assertTrue("FAIL! No articles found!", 1 == 0);
		}
	}
	
	@Then("^I see the article with all the GUI elements$")
	public void article_GUI() throws Throwable {
		System.out.println("Executing: Then I see the article with all the GUI elements");
		Thread.sleep(4000);
		common.AssertIsDisplayed(library.ArticleTitle);
		System.out.println("Comparing ArticleTitle: "+library.ArticleTitle.getAttribute("label")+" with articleTileTitle: "+articleTileTitle);
		common.AssertTextOfElement(library.ArticleTitle, articleTileTitle);
		// To add more elements when valid locators introduced
	}
	
	@When("^I tap on random topic tile$")
	public void tap_on_random_topic_tile() throws Throwable {
		System.out.println("Executing: When I tap on random topic tile");
		Thread.sleep(4000);
		int topics_list = driver.findElementsByXPath("//XCUIElementTypeCell").size();
		if (topics_list > 0) {
			int randomlySelectedTopic = rand.nextInt(topics_list) + 1;
			topicTileTitle = driver.findElementByXPath("(//XCUIElementTypeCell)["+randomlySelectedTopic+"]//XCUIElementTypeStaticText").getText();
			System.out.println("Attempt to open the Topic: "+topicTileTitle);
			driver.findElementByXPath("(//XCUIElementTypeCell)["+randomlySelectedTopic+"]").click();
			Thread.sleep(5000);
		} else {
			assertTrue("FAIL! No topics found!", 1 == 0);
		}
	}
	
	@Then("^I see a relevant Topic header on page$")
	public void I_see_relevant_topic_header_on_page() throws Throwable {
		System.out.println("Executing: Then I see a relevant Topic header on page");
		common.AssertTextOfElement(library.TopicPageNavTitle, topicTileTitle);
	}

}
