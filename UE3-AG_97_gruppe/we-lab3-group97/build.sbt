name := "we-lab3-group97"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaCore,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.1.Final"
)     

play.Project.playJavaSettings
