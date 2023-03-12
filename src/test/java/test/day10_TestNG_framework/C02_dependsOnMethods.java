package test.day10_TestNG_framework;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;


public class C02_dependsOnMethods {
    AmazonPage amazonPage = new AmazonPage();
    // Create 3 test methods
    // 1. Go to amazon and test we go to amazon
    // 2. Search for Nutella and test that the result contains Nutella
    // 3. Click on the first product and test if the product name contains Nutella

    @Test
    public void amazonTest(){

        Driver.getDriver().get("https://www.amazon.com");

        String expectedContent="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedContent));
    }

    @Test(dependsOnMethods = "amazonTest")
    public void nutellaTest(){

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);

        String expectedContent = "Nutella";
        String actualResultText = amazonPage.resultBoxElement.getText();

        Assert.assertTrue(actualResultText.contains(expectedContent));

    }

    @Test(dependsOnMethods = "nutellaTest")
    public void firstProductTest(){
        amazonPage.firstProduct.click();

        String expectedContent="Nutella";
        String actualProductName= amazonPage.firstProductNameElement.getText();

        Assert.assertTrue(actualProductName.contains(expectedContent));
        Driver.closeDriver();

    }

}
