//Код написан с ошибками. Найдите их и исправьте.
//Ваша цель - заставить функцию someFunc всегда выдавать результат умножения x на 2.
//
//Примечания: метод multiply описан в программе за вас (и его имплементация от вас скрыта)
//  дописывать в коде вызов someFunc и принт результатов не надо

def multiply(y: Int): Int = {
  y * y
}

def aCondition(): Boolean = if (1 < 2) true else false

def someFunc(x: Int, y: => Int): Int = {
  if (aCondition()) x * 2
  else  multiply(y)
}

someFunc(1,2)