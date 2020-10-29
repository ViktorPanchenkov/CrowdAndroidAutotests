package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationPageTests extends TestBase {

    @BeforeMethod
    public void GotoNotitficationPage(){
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        notificationPage.GotoNotificationPage();
    }
    @Test
    public void ViewNotification(){
       notificationPage.GotoNotificationScreen().
               ClcikOnTheViewButton();
        Assert.assertTrue(notificationPage.IS_User_WasRedirectedByClickingToViewButton());
    }
    @Test
    public void GotoRequestsScreen(){
        notificationPage.GotoRequestsScreen();
        Assert.assertTrue(notificationPage.IS_TabSelected(notificationPage.RequestsTab));
    }
    @Test
    public void GoToNotificationScreen(){
        notificationPage.GotoRequestsScreen().
        GotoNotificationScreen();
        Assert.assertTrue(notificationPage.IS_TabSelected(notificationPage.NotificationScreen));
    }
    @Test
    public void ClearAllNotifications(){
        notificationPage.GotoNotificationScreen().
        ClcikOnTheClearALLButton().
               ClcikOnClearAllNotificationButton();
        communityPage.ClcikOnTheOkButtonOnConfirmationPopUP();
        Assert.assertTrue(notificationPage.IS_Notification_or_Requests_Was_Deleted());
    }
    @Test
    public void ClearAllRequests(){
        notificationPage.GotoRequestsScreen().
                ClcikOnTheClearALLButton().
                ClcikOnTheClearAllRequestsButton();
        communityPage.ClcikOnTheOkButtonOnConfirmationPopUP();
        Assert.assertTrue(notificationPage.IS_Notification_or_Requests_Was_Deleted());
    }
    @Test
    public void GotoNotificationSettings(){
          notificationPage.GotoNotificationSettings();
          Assert.assertTrue(notificationPage.IS_Notification_Settings_Screen_ISDisplayed());
    }

}
