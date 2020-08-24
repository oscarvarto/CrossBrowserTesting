package io.oscarvarto

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions, FirefoxProfile}
import org.scalatestplus.selenium.{Driver, WebBrowser}

trait LazyFirefox extends WebBrowser with Driver {
  /**
   * The <code>FirefoxOptions</code> passed to the constructor of the <code>FirefoxDriver</code> returned by <code>webDriver</code>.
   *
   * <p>
   * The <code>FirefoxDriver</code> uses the <code>FirefoxOptions</code> defined as <code>firefoxOptions</code>. By default this is just a <code>new FirefoxOptions</code>.
   * You can mutate this object to modify the profile, or override <code>firefoxProfile</code>.
   * </p>
   */
  lazy val firefoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile)

  /**
   * <code>WebBrowser</code> subtrait that defines an implicit <code>WebDriver</code> for Firefox (an <code>org.openqa.selenium.firefox.FirefoxDriver</code>), with a default
   * Firefox profile.
   *
   * <p>
   * The <code>FirefoxDriver</code> uses the <code>FirefoxProfile</code> defined as <code>firefoxProfile</code>. By default this is just a <code>new FirefoxProfile</code>.
   * You can mutate this object to modify the profile, or override <code>firefoxProfile</code>.
   * </p>
   */
  implicit lazy val webDriver: WebDriver = new FirefoxDriver(firefoxOptions)
}
