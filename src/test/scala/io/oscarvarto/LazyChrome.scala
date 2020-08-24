package io.oscarvarto

import org.openqa.selenium.chrome.ChromeDriver
import org.scalatestplus.selenium.{Driver, WebBrowser}

trait LazyChrome extends WebBrowser with Driver {
  /**
   * <code>WebBrowser</code> subtrait that defines an implicit <code>WebDriver</code> for Chrome (an <code>org.openqa.selenium.chrome.ChromeDriver</code>).
   */
  implicit lazy val webDriver = new ChromeDriver()
}