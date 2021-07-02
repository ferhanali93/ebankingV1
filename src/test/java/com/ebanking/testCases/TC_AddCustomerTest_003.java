package com.ebanking.testCases;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass
{
    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        addCustomer.clickAddNewCustomer();
        addCustomer.custName("Ferhan");
        addCustomer.custgender("male");
        addCustomer.custdob("01", "01", "1986");
        Thread.sleep(3000);
        addCustomer.custaddress("United States");
        addCustomer.custcity("Syracuse");
        addCustomer.custstate("NY");
        addCustomer.custpinno("5000074");
        addCustomer.custtelephoneno("0123456789");
        String email = randomString()+"@gmail.com";
       addCustomer.custemailid(email);
       addCustomer.custpassword("abcdef");
       addCustomer.custsubmit();
       Thread.sleep(3000);
        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }



    }

}
