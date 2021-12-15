//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import page.BelaviaHomePage;
//import page.TimetablePage;
//
//public class BelaviaViewTest {
//    @Test
//    public void viewSuggestions() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
//        belaviaHomePage.openPage();
//        Thread.sleep(2000);
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='offers clear']//child::a[text()='Все предложения']"))).click();
//    }
//
//    @Test
//    public void viewTimetable() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
//        TimetablePage timetablePage  = new TimetablePage(driver);
//        belaviaHomePage.openPage();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnMenuButton();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnTimetableButton();
//        Thread.sleep(2000);
//        timetablePage.clickOnOneWayButton();
//        Thread.sleep(2000);
//        timetablePage.clickOnTudaCalendarButton();
//        Thread.sleep(2000);
//        timetablePage.clickOnObratnoCalendarButton();
//        // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='select-main-menu']"))).click();
//    }
//}
