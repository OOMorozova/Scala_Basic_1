//Давайте напишем метод guard, который получает на вход два параметра: data и maxLength:
//
//data - это то, что мы скармливаем методу на проверку. Это может быть все, что угодно: число, строка, список, вектор - но что именно, вам заранее не известно
//  maxLength - максимально допустимая длина строки или списка
//  типом возвращаемого значения для guard является String
//
//
//Внутри метода необходимо прописать шаблон, состоящий из пяти case. Результаты проверок на соответствие шаблону следующие:
//
//  Задан список List допустимой длины
//  Длина списка больше максимально допустимого значения
//    Длина строки не превышает максимально допустимого значения
//  Получена строка недопустимой длины
//    Что это? Это не строка и не список

def guard(data: Any, maxLength: Int): String = data match {
  case d: List[Any] if d.length <= maxLength => "Задан список List допустимой длины"
  case d: List[Any] if d.length > maxLength => "Длина списка больше максимально допустимого значения"
  case d: String if d.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
  case d: String if d.length > maxLength => "Получена строка недопустимой длины"
  case _ => "Что это? Это не строка и не список"
}
