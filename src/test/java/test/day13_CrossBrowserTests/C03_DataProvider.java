package test.day13_CrossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProvider {


    /*
        Verilen 4 farkli websitesine gidin
        o sayfaya gidildigini test edin
        sayfayi kapatin
        amazonUrl
        wiseUrl
        qdUrl
        youtubeUrl
     */

    @DataProvider
    public static Object[][] urlListesi() {

        String[][] siteListesi={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}};

        return siteListesi;
    }


    @Test(dataProvider = "urlListesi")

    //urlTest bir test methodu. ama bu testi her seferinde yazmak yerine @Test notasyonunun yanina
    //(dataProvider = "urlListesi") yazariz
    //yazdiktan sonra uzerine yaklasinca method olusturma imkani veriyor
    // @DataProvider notasyonuna sahip method olusturdu:24. ve 28. satir var.
    //arayi biz dolduruyoruz: String[][] siteListesi={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}}; ile
    //32. satirdaki @Test(dataProvider = "urlListesi")  data provider ile 23. satirdaki @DataProvider baglantili oluyor

    public void urlTest(String gidilecekSite){

        Driver.getDriver().get(ConfigReader.getProperty(gidilecekSite));
        ReusableMethods.bekle(3);
        String actualurl= Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualurl,ConfigReader.getProperty(gidilecekSite)+"/");

        Driver.closeDriver();
    }
}