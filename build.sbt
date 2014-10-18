
version := "1.0.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.1"

libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"
