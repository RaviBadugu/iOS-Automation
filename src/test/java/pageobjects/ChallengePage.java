package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ChallengePage {
	
	
	public  ChallengePage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(id="Join Challenge")
	public IOSElement joinChallengeButton;
	
	// Challenge overflow menu
	
	@iOSFindBy(id="Rules")
	public IOSElement challengeMenuRules;
	
	@iOSFindBy(id="Share Challenge")
	public IOSElement challengeMenuShare;
	
	@iOSFindBy(id="View trackers")
	public IOSElement challengeMenuTrackers;
	
	@iOSFindBy(id="Leave Challenge")
	public IOSElement challengeMenuLeave;
	
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name='Leave Challenge']")
	public IOSElement challengeAlertLeave;
	
	// Team challenge UI
	
	@iOSFindBy(id="View team members")
	public IOSElement teamChallengeTeamMembers;
	
	@iOSFindBy(id="View Leaderboard")
	public IOSElement teamChallengeViewLeaderboard;
	
	@iOSFindBy(id="All posts")
	public IOSElement teamChallengeAllPostsTab;
	
	@iOSFindBy(id="Team posts")
	public IOSElement teamChallengeTeamPostsTab;

	@iOSFindBy(id="Challenges")
	public IOSElement challengesbutton;	
	
}
