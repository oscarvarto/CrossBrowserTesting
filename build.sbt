name := "CrossBrowserTesting"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "io.github.bonigarcia" % "webdrivermanager" % "4.1.0" % Test,
  "org.scalactic" %% "scalactic" % "3.2.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.0" % Test,
  "org.scalatestplus" %% "selenium-3-141" % "3.2.0.0" % Test
)

scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps"
)

parallelExecution in Test := false