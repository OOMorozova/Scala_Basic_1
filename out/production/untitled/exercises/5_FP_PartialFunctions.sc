//Напоследок - давайте создадим простенького чат-бота. Бот реагирует только на три фразы:
//  hello
//  bye
//  what's up
//  Соответственно, его ответами будут :
//  Hi, I'm Bot
//  Bye-bye
//  sup-sup
//  Нужно:
//  использовать PartialFunction
//  предусмотреть, чтобы никаких MatchError не возникало
//  чтобы обратиться к функции можно было через переменную типа String => Option[String] с именем chatbot

def chatbot(phrase: String): Option[String] = {
  val reсognize: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  reсognize.lift(phrase)
}


//val chatbot = ({
//  case "hello"     => "Hi, I'm Bot"
//  case "bye"       => "Bye-bye"
//  case "what's up" => "sup-sup"
//}: PartialFunction[String, String]).lift


println(chatbot("hello"))
println(chatbot("bye"))
println(chatbot("what's up"))
println(chatbot("wrong input"))