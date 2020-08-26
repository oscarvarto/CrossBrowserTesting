package io.oscarvarto

import org.scalatest.{ParallelTestExecution, Suite}
import org.scalatest.funsuite.{AnyFunSuite, AnyFunSuiteLike}
import org.scalatest.matchers.should
import org.scalatestplus.selenium.{Driver, WebBrowser}
import org.slf4j.{LoggerFactory, MDC}

class TitleSuite(val url: String, expectedTitle: String) extends AnyFunSuiteLike with should.Matchers {
  this: WebBrowser with Driver =>

  val log = LoggerFactory.getLogger(s"$expectedTitle")

  test(s"$url should have title $expectedTitle") {
    MDC.put("logFileName", expectedTitle)
    go to url
    log.debug(s"Page title: $pageTitle")
    pageTitle shouldBe expectedTitle
    quit()
  }
}

class ParallelTitleSuite extends AnyFunSuite with ParallelTestExecution {
  import org.scalatest.prop.Tables._

  val titleData = Table(
    ("url", "expectedTitle"),
    ("https://www.google.com/", "Google"),
    ("https://www.wikipedia.org/", "Wikipedia"),
    ("https://www.youtube.com/", "YouTube")
  )

  override def nestedSuites: IndexedSeq[Suite] = titleData.map{ case (url, expectedTitle) =>
    new TitleSuite(url, expectedTitle) with LazyChrome { }
  }
}