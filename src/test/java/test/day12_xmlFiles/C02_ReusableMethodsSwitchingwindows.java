package test.day12_xmlFiles;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class C02_ReusableMethodsSwitchingwindows {

    @Test
    public void switchinWindowsTesti(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ReusableMethods.switchToWindow("New Window"); //acilan sayfanin window handle degerini
                                                          // set yaparak uzun uzun almaya gerek kalmadan
                                                          //switchToWindow() methodu ile kolayca almis ve gecmis oluyoruz

        System.out.println(Driver.getDriver().getTitle());


        Driver.quitDriver();


    }
}