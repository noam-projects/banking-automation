import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
    @Test(dataProviderClass =DataUtil.class, dataProvider ="data",groups = {"logintest"})
    public void login(String firstname,String lastname,String postcode,String prefferedcurrency)
    {
        ExtentTest a=ExtendReportsClass.test;
        a.info("of customer"+firstname+" "+lastname);
        WebElement home_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.box.mainhdr > button.btn.home"));
        home_button.click();
        a.info("home button clicked");
        WebElement bank_manager_login_button=driver.findElement(By.xpath(" /html/body/div[3]/div/div[2]/div/div[1]/div[2]/button"));
        a.info("bank manager button clicked");
        bank_manager_login_button.click();
        WebElement add_customer_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.center > button:nth-child(1)"));
        add_customer_button.click();
        a.info("add customer button clicked");
        WebElement first_name_input=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input"));
        first_name_input.sendKeys(firstname);
        a.info("typed first name"+first_name_input.getText());
        WebElement last_name_input=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input"));
        last_name_input.sendKeys(lastname);
        a.info("typed last name"+last_name_input.getText());
        WebElement post_code_input=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input"));
        post_code_input.sendKeys(String.valueOf(Math.round(Float.parseFloat(postcode))));
        a.info("typed postcode"+post_code_input.getText());
        WebElement add_customer_final_button=driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > button"));
        add_customer_final_button.click();
        a.info("customer added");
        Alert alert = driver.switchTo().alert();
        String[] splitted_alert = alert.getText().split(" ");
        String final_part=splitted_alert[6];
        final_part=final_part.replace(":","");
        int string_number=Integer.parseInt(final_part);
        if (string_number<4||string_number>99)
            Assert.fail();
        alert.accept();
    }
}
