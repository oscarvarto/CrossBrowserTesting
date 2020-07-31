package io.oscarvarto

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should
import org.scalatest.tags.{ChromeBrowser, FirefoxBrowser}
import org.scalatestplus.selenium.{Chrome, Driver, Firefox, WebBrowser}

trait WikipediaSpec extends AnyFunSuiteLike with should.Matchers {
  this: WebBrowser with Driver =>

  test("Wikipedia should have correct title") {
    go to "https://www.wikipedia.org/"
    pageTitle shouldBe "Wikipedia"
    quit()
  }
}

@ChromeBrowser
class ChromeWikipediaSpec extends WikipediaSpec with Chrome

@FirefoxBrowser
class FirefoxWikipediaSpec extends WikipediaSpec with Firefox