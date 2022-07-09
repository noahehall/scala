ThisBuild /scalaVersion := "3.1.3"
ThisBuild / organization := "com.example"

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.12"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.7.0"
val playJson  = "com.typesafe.play" %% "play-json" % "2.10.0-RC6"

// the main project
lazy val hello = (project in file("."))
  .aggregate(helloCore) // broadcast all cmds sent to hello to helloCore
  .dependsOn(helloCore) // this project now depends on helloCore
  .enablePlugins(JavaAppPackaging) // enable plugins in root/project/plugins.sbt
  .settings(
    name := "Hello",
    libraryDependencies +=  scalaTest % Test,
  )

// a sub project
lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test,
  )
