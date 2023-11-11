//Напишите функцию countChars(s: String): Map[Char, Int] ,
//которая позволит посчитать, сколько раз каждый из символов был встречен в заданной строке.
//Конечный результат, отправляемый на проверку, должен быть конвертирован в список
//и отсортирован по возрастанию количества встреченных символов.

def countChars(s: String): Map[Char, Int] = {
  s.toLowerCase.foldLeft(Map[Char, Int]().withDefaultValue(0)){
    case (acc, letter)  => acc + (letter -> (1 + acc(letter)))
  }
}

val inputString = "Sst"
println(countChars(inputString).toSeq.sortBy(_._2).toList)