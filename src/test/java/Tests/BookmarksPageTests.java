package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookmarksPageTests extends TestBase {

    @BeforeMethod
    public void GotoCommunityPage() {
        // String Phone = "1113333333";
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        bookmarksPage.GotoBookmarkPage();


    }

    @Test
    public void GotoSurveysTab(){
    bookmarksPage.GotoSurveysTab();
        Assert.assertTrue(bookmarksPage.IS_Tab_Selected(bookmarksPage.SurveysTab));
    }
    @Test
    public void GotoCommunitiesTab(){
        bookmarksPage.GotoSurveysTab().
                GotoCommunitiesTab();
        Assert.assertTrue(bookmarksPage.IS_Tab_Selected(bookmarksPage.CommunitiesTab));
    }
    @Test
    public void GotoBokmarkedCommunity(){
        bookmarksPage.GotoCommunitiesTab().
                GotoCommunity();
        Assert.assertTrue(bookmarksPage.IS_Community_Open());
    }
    @Test
    public void GotoBookmarkedSurvey(){
        bookmarksPage.GotoSurveysTab().
                GotoBookmarckedSurvey();
        Assert.assertTrue(bookmarksPage.IS_Survey_Opened());
    }
}
