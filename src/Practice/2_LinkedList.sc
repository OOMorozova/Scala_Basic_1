//реализовать односвязный список
// методы:
//
//  last - возвращает последнее поступившее сообщение (иначе говоря - head списка)
//  previous - возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
//isEmpty - проверяет, если ли в нашем списке сообщения
//  all - предоставляет нам содержимое нашего списка в виде строки
//  add(msg) - добавляет сообщение в список
//
//
//Примечания: для поступающих сообщений используем тип String
import scala.annotation.tailrec

abstract class LogList {
  def add(msg: String): LogList
  def previous: LogList
  def last: String
  def isEmpty: Boolean
  def all:  String

}

class Log(head: String, tail: LogList) extends LogList {
  def add(msg: String): LogList = new Log(msg, this)
  def isEmpty: Boolean = false
  def previous: LogList = this.tail
  def last: String = s"${this.head}"
  def all: String = {
    var res = " "
    @tailrec
    def loop(lst: LogList, res: String=""): String = {
      if (lst.isEmpty) {res.trim()}
      else loop(lst.previous, res ++ " " + lst.last)
    }
    loop(this)
  }

}

object Empty extends LogList {
  def add(msg: String): LogList = new Log(msg, Empty)
  def previous: LogList = throw new NoSuchElementException
  def last: String = throw new NoSuchElementException
  def all: String = s""
  def isEmpty: Boolean = true
}



val list = new Log("INFO_1", new Log("INFO_2", new Log("INFO_3", Empty)))
println(list.previous.last) //INFO_2

val lst =  new Log("m1", new Log("m2", new Log("m3", Empty)))
println(lst.all) //m1 m2 m3
