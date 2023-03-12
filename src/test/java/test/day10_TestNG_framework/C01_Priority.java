package test.day10_TestNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {


    //TestNG methods work by letter order
    //But TestNG lets us order
    //We give priority to the test method by writing "priority".
    //The smaller "priority value" works first
    //If "priority value" is the same value, it works with letter order.
    //When the value is not written, the "priority value" is assumed to be 0 by default.

    @Test(priority = 20)
    public void amazonTest(){
        //Go to the amazon homepage
        Driver.getDriver().get("https://amazon.com");

        //Test that url contains "amazon"
        String expectedContent="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedContent));
        Driver.closeDriver();



    }

    @Test
    public void wiseTest(){
        //Go to the wisequarter homepage and test that you have gone to amazon.
        Driver.getDriver().get("https://wisequarter.com");
        Driver.getDriver().navigate().refresh();

         //Test that url contains "wisequarter"
        String expectedContent="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedContent));
        Driver.closeDriver();




    }

    @Test
    public void youtubeTest(){
        //Go to the youtube homepage and test that you have gone to amazon.
        Driver.getDriver().get("https://youtube.com");

        //Test that url contains "youtube"
        String expectedContent="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedContent));
        Driver.closeDriver();
    }

}
