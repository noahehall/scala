scalaVersion := "3.1.2"
organization := "dev.zio"
name         := "zio-quickstart-graphql-webservice"

libraryDependencies ++= Seq(
  "dev.zio"               %% "zio"              % "2.0.0-RC2",
  "com.github.ghostdogpr" %% "caliban"          % "2.0.0-RC2",
  "com.github.ghostdogpr" %% "caliban-zio-http" % "2.0.0-RC2",
  "io.d11"                %% "zhttp"            % "2.0.0-RC3",
)
