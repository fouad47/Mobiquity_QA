package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.DefaultConfiguration;

public abstract class BaseTest {

    protected SoftAssert softAssert = new SoftAssert();
    protected String baseUrl;

    @BeforeClass
    public void setupConfig(){
        baseUrl = DefaultConfiguration.getPropertyValue("url");
    }

    @AfterMethod
    public void afterEachMethod(){
        softAssert.assertAll();
    }


}
