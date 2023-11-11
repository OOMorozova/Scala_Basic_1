//Ваша задача - реализовать два класса: Button и RoundedButton.
//
//Для класса Button
//  предусмотрите возможность указания label типа String при создании экземпляра класса
//  пропишите метод def click(): String, возвращающий строку, в которой указан label, заданный при создании кнопки:
//  button -label- has been clicked
//
//Для RoundedButton
//  предусмотрите наледование от Button
//  реализуйте метод click, который похож на родительский метод click, но в отличие от него содержит слово rounded перед
//  button: rounded button -label- has been clicked
//
//Учтите, что в коде задан еще один класс: TestButton. И выглядит этот класс следующим образом: class TestButton extends Button.
// В классе прописан только метод click, больше ничего. Для этого класса метод click всегда выводит test button -test- has been clicked
//
class Button(label: String) {
  def this() = this("test")
  def click(): String = s"button -$label- has been clicked"
}

class RoundedButton(label: String) extends Button(label){
  override def click(): String = s"rounded ${super.click()}"
}
