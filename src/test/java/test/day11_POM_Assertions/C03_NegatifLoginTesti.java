package test.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegatifLoginTesti {
    // qd anasayfaya gidin
    // 3 test method'u olusturun ve
    // asagidaki durumlarda giris yapilamadigini test edin
    // 1- gecerli username, gecersiz password
    // 2- gecersiz username, gecerli password
    // 3- gecersiz username, gecersiz password
    QdPage qdPage=new QdPage();
    @Test(groups = "smoke")
    public void NegatifLoginTesti1(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.submit();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }

    @Test(groups = {"smoke","mr1"})
    public void NegatifLoginTesti2(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.submit();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }

    @Test
    public void NegatifLoginTesti3(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.submit();
        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
        Driver.closeDriver();

    }
}
