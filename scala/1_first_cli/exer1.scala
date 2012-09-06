import scala.io.Source.fromFile

val contents = fromFile("C:/Tommi/Ohjelmointi/ScalaWorkspace/curious-learners/scala/1_first_cli/mediakanta.conf")

val numberRegexp = """^[0-9]+$""".r
val numberLines = contents.getLines.filter(entry => { entry.nonEmpty && (numberRegexp findFirstIn entry.split(" = ")(1)).nonEmpty })
val numbers = numberLines.map(entry => { entry.split(" = ")(1) }).toList.sorted

for(number <- numbers) {println(number)}
