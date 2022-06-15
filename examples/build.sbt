ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

// "organization name" %% "artifact (i.e. package) name" % "version" [% OptionalClassPath]
ThisBuild / libraryDependencies ++= List(
  "com.lihaoyi" %% "fansi" % "0.3.0",
  "org.scalameta" %% "munit" % "0.7.29" % Test
)

ThisBuild / testFrameworks += TestFramework("munit.Framework")

// configure sb-site: enables sbt task makeSite
// run sbt > makeSite
// check in root/target/site/*
makeSite / mappings := {
  val indexFile = target.value / "index.html"
  IO.write(indexFile, "<h1>poop</h1>")
  Seq(indexFile -> "index.html")
}

lazy val root = (project in file("."))
  .settings(
    name := "examples"
  )
