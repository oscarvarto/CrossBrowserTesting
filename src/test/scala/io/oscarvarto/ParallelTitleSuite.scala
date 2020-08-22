package io.oscarvarto

import org.scalatest.Suite
import org.scalatest.funsuite.{AnyFunSuite, AnyFunSuiteLike}
import org.scalatest.matchers.should
import org.scalatestplus.selenium.{Chrome, Driver, WebBrowser}

abstract class TitleSuite(val url: String, expectedTitle: String) extends AnyFunSuiteLike with should.Matchers  {
  this: WebBrowser with Driver =>

  test(s"$url should have title $expectedTitle") {
    go to url
    pageTitle shouldBe expectedTitle
    quit()
  }
}

class ParallelTitleSuite extends AnyFunSuite {
  import org.scalatest.prop.Tables._

  val titleData = Table(
    ("url", "expectedTitle"),
    ("https://www.google.com/", "Google"),
    ("https://www.wikipedia.org/", "Wikipedia"),
    ("https://www.youtube.com/", "YouTube")
  )

  override def nestedSuites: IndexedSeq[Suite] = titleData.map{ case (url, expectedTitle) =>
    new TitleSuite(url, expectedTitle) with Chrome { }
  }
}