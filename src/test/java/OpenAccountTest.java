import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest {
        @Test(dataProviderClass =DataUtil.class, dataProvider ="data",dependsOnGroups = {"logintest"},groups = {"openaccounttest"})
        public void open_accounts(String firstname,String lastname,String postcode,String prefferedcurrency)
        {
            ExtentTest a=ExtendReportsClass.test;
            a.info("of customer"+firstname+" "+lastname);
            WebElement home_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.box.mainhdr > button.btn.home"));
            home_button.click();
            a.info("home button clicked");
            WebElement bank_manager_login_button=driver.findElement(By.xpath(" /html/body/div[3]/div/div[2]/div/div[1]/div[2]/button"));
            a.info("bank manager button clicked");
            bank_manager_login_button.click();
            WebElement open_account_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.center > button:nth-child(2)"));
            open_account_button.click();
            a.info("open account button clicked");
            WebElement selectCustomer = driver.findElement(By.cssSelector("#userSelect"));
            Select customers_list= new Select(selectCustomer);
            customers_list.selectByVisibleText(firstname+" "+lastname);
            a.info("selected customer name");
            WebElement select_currency = driver.findElement(By.cssSelector("#currency"));
            Select currency_list= new Select(select_currency);
            currency_list.selectByVisibleText(prefferedcurrency);
            a.info("selected currency");
            WebElement submit=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > button"));
            submit.click();
            a.info("clicked on process");
            Alert alert = driver.switchTo().alert();
            String[] splitted_alert = alert.getText().split(" ");
            String final_part=splitted_alert[6];
            final_part=final_part.replace(":","");
            int string_number=Integer.parseInt(final_part);
            if (string_number<1000||string_number>50000)
                Assert.fail();
            alert.accept();
        }
    }


