<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Paralel Classlari Calistirma" parallel="tests" thread-count="2" verbose="3">


    <test name="Paralel Calisma 1">
        <classes>
            <class name="test.day11_POM_Assertions.C02_PozitifLoginTesti"></class>
            <class name="test.day10_TestNG_framework.C01_Priority"></class>
        </classes>
    </test>



    <test name="Paralel Calisma 2">
        <classes>
            <class name="test.day12_xmlFiles.C02_ReusableMethodsSwitchingwindows"></class>
            <class name="test.day11_POM_Assertions.C05_SoftAssert"></class>
        </classes>
    </test>


</suite>