package Tests;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InboxPageTests extends TestBase {
    @BeforeMethod
    public void GotoInboxPage(){
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        inboxPage.GotoInboxTab();
    }

    @Test
    public void GotoChatsTab(){
     inboxPage.GotoChatsTab();
        Assert.assertTrue(inboxPage.IS_Tab_Selected(inboxPage.ChatsTab));
    }
    @Test
    public void GotoDisscussionTab(){
        inboxPage.GotoDisscussinScreen();
        Assert.assertTrue(inboxPage.IS_Tab_Selected(inboxPage.DisscussionTab));
    }
    @Test
    public void GotoGroupChat(){
        inboxPage.GotoChatsTab().
                GotoGroupChat();
        Assert.assertTrue(inboxPage.IS_Chat_Disscusion_was_Opened());
    }
    @Test
    public void GotoDisscusion(){
        inboxPage.GotoDisscussinScreen().
                GotoDisscusion();
        Assert.assertTrue(inboxPage.IS_Chat_Disscusion_was_Opened());
    }
    @Test
    public void RemoveGroupChatFromInbox(){
        inboxPage.GotoChatsTab();
        Assert.assertTrue(inboxPage.RemoveCroupChatFromInbox());
    }
    @Test
    public void RemoveDisscusionFromInbox(){
        inboxPage.GotoDisscussinScreen();
        Assert.assertTrue(inboxPage.RemoveDisscusionFromInbox());
    }
}
