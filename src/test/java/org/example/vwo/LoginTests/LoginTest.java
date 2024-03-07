package org.example.vwo.LoginTests;

import net.bytebuddy.build.Plugin;
import org.assertj.core.api.Assertions;
import org.example.basetest.CommonToAllTest;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.annotations.Test;

public class LoginTest extends CommonToAllTest {


@Test(priority = 2)
public void testLoginPositive() throws Exception {


  // who will start the browser
   // hwo to enter the user, pass and go to the dashboard and verify
   //who will close the webdriver

  LoginPage_POM pagePom = new LoginPage_POM();

  pagePom.OpenURL(PropertyReader.readKey("url"));

  pagePom.loginToVWOPositive();

  DashboardPage_POM dashboardPagePom = pagePom.afterLogin();  // here they are createing object of dasboard_pom to transfer the control to this page

  String expected_username = dashboardPagePom.loggedInUserName();

  Assertions.assertThat(expected_username).isNotNull().isNotBlank().contains(PropertyReader.readKey("expected_username"));


}

  @Test(priority = 1)  // all negative tests should run first
  public void testLoginNegative() throws Exception {

  LoginPage_POM pagePom = new LoginPage_POM();

  pagePom.OpenURL(PropertyReader.readKey("url"));

  String error_message = pagePom.loginToVWONegative();

  Assertions.assertThat(error_message).isNotNull().isNotBlank().contains(PropertyReader.readKey("error_message"));


  }






}
