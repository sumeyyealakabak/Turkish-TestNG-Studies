package test.day11_POM_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigReaderKulanimi {

    @Test
    public void test01(){

      //  amazon ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

      //  test datasi olarak verilen kelime icin arama yapin

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonExpectedContent")+ Keys.ENTER);

      //  arama sonuclarinin nutella icerdigini test edin
        String expectedContent=ConfigReader.getProperty("amazonExpectedContent");
        String actualResultText=amazonPage.resultBoxElement.getText();
        Assert.assertTrue(actualResultText.contains(expectedContent));
        Driver.closeDriver();



    }
}
