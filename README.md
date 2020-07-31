# Minimal Scala Project with ScalaTest + Selenium

Running 

```
$ sbt
sbt:CrossBrowserTesting> test
```

runs the `WikipediaSpec` on Chrome, Firefox and Safari. But, if I try to run only the _Chrome_ test with

```
sbt:CrossBrowserTesting> testOnly * -- -n org.scalatest.tags.ChromeBrowser
```

the Firefox and Safari browsers are still started (even though any of the test are executed for these)
and the windows are not closed.

 **What needs to be done in order to run only the tests tagged with a single browser?**
