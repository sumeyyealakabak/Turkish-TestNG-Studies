package test.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;



public class C02_PozitifLoginTesti {
    @Test
    public void pozitifLoginTesti() throws InterruptedException {
        //qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //login linkine tiklayin
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        //qdPage.cookie.click();

        //gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qdPage.loginButonu.submit();


        //basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isEnabled());
        Driver.closeDriver();
    }
}
