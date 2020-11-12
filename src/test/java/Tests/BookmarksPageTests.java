package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookmarksPageTests extends TestBase {
    int Random = (int) (Math.random() *10);
    @BeforeMethod
    public void GotoCommunityPage() {
        String Phone2 = "1113333333";
        String Phone1 = "1112222222";
        String Phone3 ="11111111111";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton();
        if(Random <= 4){
            loginPage.EnterPhone(Phone1);
        } else if(Random > 4 && Random <8){
            loginPage.EnterPhone(Phone2);
        } else  if (Random >8){
            loginPage.EnterPhone(Phone3);
        }

        loginPage.EnterPassword(Password).
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
