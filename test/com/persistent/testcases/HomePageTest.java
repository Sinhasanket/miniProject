package com.persistent.testcases;

import org.testng.annotations.Test;

import com.persistent.base.TestBase;
import com.persistent.pages.HomePage;
import com.persistent.pages.LoginPage;
import com.persistent.utilities.TestUtils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{

	TestUtils testUtils;
	HomePage homePage;
	LoginPage loginPage;

	HomePageTest(){
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyLogoutLinkTest() {
		HomePage.userLogOut(driver).click();
	}

	@Test(priority=2)
	public void verifyMessageLinkTest() {
		String getExpectedTitle = prop.getProperty("messageTitle").trim();

		HomePage.userMessage(driver).click();

		String actualTitle = driver.findElement(By.className("f-title")).getText();

		Assert.assertEquals(actualTitle, getExpectedTitle);
	}

	@Test(priority=3)
	public void verifyFindFriendLinkTest() {
		String expectedBtnName = prop.getProperty("addBtn");

		HomePage.getFindFriendLink(driver).click();

		HomePage.getAddFriendBtn(driver).click();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT ,TimeUnit.SECONDS) ;

		String actualBtnName = HomePage.getActualBtnName(driver);

		Assert.assertEquals(actualBtnName, expectedBtnName);
	}

	@Test(priority=4)
	public void verifyFriendLinkTest() {
		String pageNotFound = prop.getProperty("pageNotFound");

		HomePage.getFrienLinkNew(driver).click();

		String title = HomePage.getPageTitle(driver);

		if(title.contains(pageNotFound)) {
			System.out.println("ERROR 404");
		}
	}

	@Test(priority=5)
	public void verifyLikeDislikeBtnTest() {
		String likeButtonConvert1 = HomePage.getLikeBtn(driver).getText();
		double oldCounter = Double.parseDouble(likeButtonConvert1.substring(0,likeButtonConvert1.length()-1));

		String dislikeButtonConvert1 = HomePage.getDislikeBtn(driver).getText();
		double oldDislikeCounter = Double.parseDouble(dislikeButtonConvert1.substring(0,dislikeButtonConvert1.length()-1));

		HomePage.getLikeBtn(driver).click();

		String likeButtonConvert = HomePage.getLikeBtn(driver).getText();
		double newCounter = Double.parseDouble(likeButtonConvert.substring(0,likeButtonConvert.length()-1));

		HomePage.getDislikeBtn(driver).click();

		String dislikeButtonConvert2 = HomePage.getDislikeBtn(driver).getText();
		double newDislikeCounter = Double.parseDouble(dislikeButtonConvert2.substring(0,dislikeButtonConvert2.length()-1));

		if(newCounter > oldCounter) {
			System.out.println("TESTCASE PASSED (LIKE BUTTON)");
		}else {
			System.out.println("TESTCASE FAILED (LIKE BUTTON)");
		}

		if(newDislikeCounter > oldDislikeCounter) {
			System.out.println("TESTCASE PASSED (DISLIKE BUTTON)");
		}else {
			System.out.println("TESTCASE FAILED (DISLIKE BUTTON)");
		}
	}

	@Test(priority=6)
	public void verifyNotificationLinkTest() {
		String pageNotFound = prop.getProperty("pageNotFound");
		HomePage.getNotificationLink(driver).click();

		String title = HomePage.getPageTitle(driver);

		if(title.contains(pageNotFound)) {
			System.out.println("ERROR 404");
		}
	}

	@Test(priority=7)
	public void verifyFindFriendWhoIsFollowingLinkTest() {
		String expectedLinkName =  prop.getProperty("addBtn");

		HomePage.getFindFriendLink(driver).click();

		HomePage.getFindFriendWhoIsFollowing(driver).click();

		String actualLinkName = HomePage.getFindFriendWhoIsFollowing(driver).getText();

		Assert.assertEquals(actualLinkName, expectedLinkName);
	}

	@Test(priority=8)
	public void verifyHamBergerMenuTest() {
		HomePage.getHamBurgermenu(driver).click();
	}

	@Test(priority=9)
	public void verifyUserNameClickTest() {
		String expectedString = prop.getProperty("profilePage");

		HomePage.getUserName(driver).click();

		String actualString = HomePage.verifyProfilePage(driver);

		Assert.assertEquals(actualString,expectedString);
	}

	@Test(priority=10)
	public void verifySearchFriendTest() {
		String expectedTitle = prop.getProperty("pageTitle");
		String getName = prop.getProperty("nameToSearch");

		HomePage.getSearchBox(driver).sendKeys(getName);

		HomePage.getSearchBtn(driver).click();

		String actualTitle = HomePage.getPageTitle(driver);

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
