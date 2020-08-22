package io.oscarvarto

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should
import org.scalatest.tags.{ChromeBrowser, FirefoxBrowser, SafariBrowser}
import org.scalatestplus.selenium.{Chrome, Driver, Firefox, Safari, WebBrowser}

trait WikipediaSuite extends AnyFunSuiteLike with should.Matchers {
  this: WebBrowser with Driver =>

  test("Wikipedia should have correct title") {
    go to "https://www.wikipedia.org/"
    pageTitle shouldBe "Wikipedia"
    quit()
  }
}

@ChromeBrowser
class ChromeWikipediaSuite extends WikipediaSuite with Chrome

@FirefoxBrowser
class FirefoxWikipediaSuite extends WikipediaSuite with Firefox

@SafariBrowser
class SafariWikipediaSuite extends WikipediaSuite with Safari
