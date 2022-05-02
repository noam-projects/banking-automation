import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionsTest extends BaseTest {
    @Test(dataProviderClass =DataUtil.class, dataProvider ="data",dependsOnGroups = {"openaccounttest"})
    public void transactions(String firstname,String lastname,String postcode,String prefferedcurrency)
    {
        ExtentTest a=ExtendReportsClass.test;
        a.info("of customer "+firstname+" "+lastname);
        WebElement home_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.box.mainhdr > button.btn.home"));
        home_button.click();
        a.info("home button clicked");
        WebElement customers_login_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(1) > button"));
        customers_login_button.click();
        a.info("customer login button clicked");
        WebElement select_name=driver.findElement(By.cssSelector("#userSelect"));
        Select names_list= new Select(select_name);
        names_list.selectByVisibleText(firstname+" "+lastname);
        a.info("selected currency");
        WebElement loginbutton=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > form > button"));
        loginbutton.click();
        a.info("performed log in");
        WebElement deposit_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)"));
        deposit_button.click();
        a.info("deposit button clicked");
        WebElement deposit_input=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)"));
        deposit_button.sendKeys("20");
        a.info("typed 20");
        WebElement depositbutton=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)"));
        depositbutton.click();
        a.info("deposited cash");
        WebElement withdrawl_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(3)"));
        withdrawl_button.click();
        a.info("clicked on withdrawel button");
        WebElement withdrawl_input=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > div > input"));
        withdrawl_input.sendKeys("10");
        a.info("typed 10");
        WebElement withdrawelbutton=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > button"));
        withdrawelbutton.click();
        a.info("clicked on withdrawel");
        WebElement balance=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div:nth-child(3) > strong:nth-child(2)"));
        if(Integer.parseInt(balance.getText())<0)
        Assert.fail();
    }
}
