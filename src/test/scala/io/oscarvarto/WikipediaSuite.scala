package io.oscarvarto

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should
import org.scalatest.tags.{ChromeBrowser, FirefoxBrowser}
import org.scalatestplus.selenium.{Driver, WebBrowser}

trait WikipediaSuite extends AnyFunSuiteLike with should.Matchers {
  this: WebBrowser with Driver =>

  test("Wikipedia should have correct title") {
    go to "https://www.wikipedia.org/"
    pageTitle shouldBe "Wikipedia"
    quit()
  }
}

@ChromeBrowser
class ChromeWikipediaSuite extends WikipediaSuite with LazyChrome

@FirefoxBrowser
class FirefoxWikipediaSuite extends WikipediaSuite with LazyFirefox
