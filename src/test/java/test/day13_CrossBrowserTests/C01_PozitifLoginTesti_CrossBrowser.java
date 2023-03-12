package test.day13_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.DriverCross;
import utilities.TestBaseCross;


public class C01_PozitifLoginTesti_CrossBrowser  extends TestBaseCross {

    @Test
    public void pozitifLoginTesti() throws InterruptedException {

        //qd anasayfaya gidin
        driver.get(ConfigReader.getProperty("qdUrl"));

        /* Pages tan locate leri alamiyoruz . oradakiler normal tek driver,
         burada driver cross test yapacagiz. o yuzden locate leri tekrar alacagiz
         QdPage qdPage=new QdPage();  obje olusturmuyoruz  QdPage ten
         yani POM kullanamiyoruz ayni JUnit teki gibi yapabiliyoruz*/

        //login linkine tiklayin
        WebElement ilkLoginLinki=driver.findElement(By.linkText("Log in"));
        ilkLoginLinki.click();
        //qdPage.cookie.click();

        //gecerli kullanici adi ve password ile giris yapin
        WebElement emailKutusu=driver.findElement(By.id("login-email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        WebElement passwordKutusu=driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

       WebElement loginButonu=driver.findElement(By.xpath("//button[text()='Login']"));
        loginButonu.submit();


        //basarili bir sekilde giris yapildigini test edin
        WebElement basariliGirisElementi=driver.findElement(By.xpath("//a[text()='Instructor']"));
        Assert.assertTrue(basariliGirisElementi.isEnabled());
        Driver.closeDriver();

    }
}
