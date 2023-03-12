package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {
    /*
    Cross Browser testi yapabilmek icin
    xml dosyasindaki  "<parameter name="browser" value="chrome"></parameter>" value nun okunmasi icin
    "@Parameters("browser")"  buna ihtiyac var
    Her test method undan once calismasi icin "@BeforeMethod" dan once yazariz

    Boylece:
    1.  "@Parameters("browser")" ile xml dosyasindan parametre olarak yazilan browser degerini alir
         her test method undan once
    2. "driver= DriverCross.getDriver(browser);" ile DriverCross class ina browser parametresini goturecek
    3. DriverCross dan ilgili browser i getirecek

    yani " @Parameters("browser")" xml dosyasi ile DriverCross arasinda kopru gorevindedir

         bunlari her test methodundan once yapacak

         *TestBaseCross un calismasi icin extends yapmaliyiz
         *Cross Browser testini yaptigimiz testler icin ayri bir package olusturuyoruz day13 un altinda,
         kullanilan driver lar karismamasi icin

     */
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){

        driver= DriverCross.getDriver(browser);

    }

    @AfterMethod
    public void tearDown(){

        DriverCross.closeDriver();
    }
}