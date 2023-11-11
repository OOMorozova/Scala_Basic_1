
import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}
// Давайте напишем программу, помогающую получить инициалы человека. Программа выдает один из следующих возможных результатов:
//  инициалы человека (заглавные буквы имени и фамилии с точкой, т.е. для John Smith результатом будет J. S. - внимание на точки и пробел)
//  сообщение Oops, something is wrong
//  предусматривать ситуации, когда на вход были переданы имя и фамилия в нижнем регистре - не надо
class Person(Fullname: Array[String]) {
  def getAbbr: String = Fullname.length match {
      case 2 => Fullname(0).substring(0, 1) + ". " + Fullname(1).substring(0, 1) + "."
      case _ => "Oops, something is wrong"
    }

}

object Person {
  def apply(Fullname: Array[String]): Person = new Person(Fullname)
}

object Main {
  def main(args: Array[String]): Unit = {
    val inpln = Try(readLine().split(" "))
    inpln match {
      case Success(fullname) => {
        val pers = Person(fullname)
        println(pers.getAbbr)
      }
      case Failure(e) => println("Oops, something is wrong")
    }
  }
}


