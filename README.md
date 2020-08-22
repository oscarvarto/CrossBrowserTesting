# Minimal Scala Project with ScalaTest + Selenium

## Problem \# 1

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

## Problem \# 2

Running

```
testOnly io.oscarvarto.ParallelTitleSuite
```

starts up 9 browser windows in my computer (it has 12 cores), instead of the 3 browser windows expected
(1 per nested test, 3 in total). After the test completes, it reports that 3 tests succeded, and closes
the 3 browser windows used but **lefts 6 browser windows opened**.

The expected behavior is that only the 3 nested suites create a browser window (only the ones that are needed,
or as many as the system can support if there are a lot of needed windows), and those windows should open only
when the test starts. This is not happening, because 9 browser windows are created and opened.

The usage of `parallelExecution in Test := false` (instead of using `true` for this sbt setting) makes no
difference in the behavior.
