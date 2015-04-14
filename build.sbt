name := """Users"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "info.cukes" % "cucumber-java" % "1.1.8" % "test",
  "info.cukes" % "cucumber-junit" % "1.1.8" % "test",
  "org.assertj" % "assertj-core" % "2.0.0" % "test"
)
