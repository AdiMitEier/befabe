name := "we-lab3-group97"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaCore,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.2.8.Final",
  "com.google.code.gson" % "gson" % "2.2"
)     

play.Project.playJavaSettings

templatesImport += "scala.collection._"

templatesImport += "at.ac.tuwien.big.we14.lab2.api._"
