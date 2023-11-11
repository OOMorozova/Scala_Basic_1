import scala.util.Try

def multiplyByTwo(a: Int): Int = a * 2

val result = multiplyByTwo {
  val aList1 = List("a", "b")
  val aList2 = List("c", "d")

  val aList = aList1 ++: aList2 :+ "p"
  aList.zipWithIndex.filter(_._2 != 0).map(_._1).length
  

}

println(result)

val aPartialFunction: PartialFunction[String, String] = {
  case "mon" => "Work!"
  case "fri" => "Party Time"
  case "sun" => "Relax a little"
}


println(aPartialFunction("sun")) // Relax a little
println(aPartialFunction("sat")) // MatchError


def guard(data: Any, maxLength: Int): String = data match {
  case d: List[Any] if d.length <= maxLength => "Задан список List допустимой длины"
  case d: List[Any] if d.length > maxLength => "Длина списка больше максимально допустимого значения"
  case d: String if d.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
  case d: String if d.length > maxLength => "Получена строка недопустимой длины"
  case _ => "Что это? Это не строка и не список"


//    && (_.length == maxLength)  => println(s"Задан список List допустимой длины")
//  case i if (List[Any]) & (i.length > maxLength)  => println(s"Длина списка больше максимально допустимого значения")
//  case i if (String) && (i.length <= maxLength)  => println(s"Длина строки не превышает максимально допустимого значения")
//  case i if (String) && (i.length > maxLength)  => println(s"Получена строка недопустимой длины")
//  case _ => println(s"Что это? Это не строка и не список")
}

println(guard(List(1,2,3), 3))
println(guard(List(1,2,3), 2))
println(guard("Строка", 6))
println(guard("Строка", 3))
println(guard(42, 3))









def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")
val anotherPotentialFailure = Try {
  Try(unsafeMethod())
  "another failure"
}
println(anotherPotentialFailure)

val anotherPotentialFailure2 = Try {
  "another failure"
  Try(unsafeMethod())
}
println(anotherPotentialFailure2)

val someVal = Some(2)
println(someVal.map(_ * 2))

val sampleTuple = new Tuple2(2, "Hello, World")
println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)

println(Seq(3,4,3,3).sorted.search(3))


println(Int.MaxValue + 1)

val aString: String = "Hello, world!"

println(aString.length) // выводит 13
println(aString.charAt(1)) // выводит e
println(aString.substring(0, 2)) // выводит He
println(aString.split(" ").toList) // выводит List(Hello,, world!)
println(aString.startsWith("He")) // выводит true
println(aString.replace("!", ".")) // выводит Hello, world.
println(aString.toLowerCase) // выводит hello, world!
println(aString.toUpperCase) // выводит HELLO, WORLD!
println("abcd".reverse) // выводит dcba
println("abcd".take(2)) // выводит ab

def powerOfTwo(x: Int): BigInt={
  def loop2(i: Int, m: BigInt=1): BigInt={
    if (i <1) m
    else loop2(i-1, m*2)
  }

  loop2(x)
}

powerOfTwo(4)


class Instructor(val id: Int, val name: String, val surname: String) {
  def fullName(): String=name.substring(0,1).toUpperCase ++ name.substring(1, name.length) ++ " " ++ surname.substring(0,1).toUpperCase ++ surname.substring(1, surname.length)
}

class Course(val courseID:Int, val title: String, var releaseYear:String, val instructor: Instructor) {
  def getID: String=this.courseID.toString ++ this.instructor.id.toString
  def isTaughtBy(instructor: Instructor): Boolean=if (instructor == this.instructor) true else false
  def copyCourse(newReleaseYear: String): Course=new Course(this.courseID, this.title, newReleaseYear, this.instructor)
}

var inst = new Instructor(1, "victor", "zubov")
var inst2 = new Instructor(2, "alexey", "zubov")

println(inst.fullName())

var courseinst = new Course(1, "kurs", "2020", inst)
println(courseinst.getID)
println(courseinst.isTaughtBy(inst))
println(courseinst.isTaughtBy(inst2))
var curs2 = courseinst.copyCourse("2023")
println(courseinst.instructor.fullName())
println(courseinst.releaseYear)
println(curs2.courseID)

case class Instructor2(id: Int, name: String, surname: String) {
  val fullName: String = s"${name.capitalize} ${surname.capitalize}"
}

case class Course2(courseID: Int, title: String, releaseYear: String, instructor: Instructor2) {
  def getID = s"$courseID${instructor.id}"
  def isTaughtBy(instructor: Instructor2) = this.instructor == instructor
  def copyCourse(newReleaseYear: String) = copy(releaseYear = newReleaseYear)
}

var case2 = new Instructor2(1, "victor", "zubov")
var case1 = new Instructor2(2, "alexey", "zubov")

println(case2.fullName)

var crs2 = new Course2(1, "kurs", "2020", case2)
println(crs2.getID)
println(crs2.isTaughtBy(case2))
println(crs2.isTaughtBy(case1))
var crs1 = crs2.copyCourse("2023")
println(crs2.instructor.fullName)
println(crs1.releaseYear)
println(crs1.courseID)

