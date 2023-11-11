//В системе заданы классы Event и Listener и создана переменная notification. Для этого использован следующий код:
abstract class Event {
    def trigger(eventName: String): Unit
  }

class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) = { event = evt }
    def sendNotification() = { event.trigger(eventName) }
  }

val notification: Listener = new Listener("mousedown", null)

//Ваша задача - использовав знание анонимных классов, дополнить код так, чтобы сработал вызов:
//
//  notification.sendNotification
//  В результате должна появиться строка, уведомляющая о том, какой eventName был использован: trigger eventName event.
//
//Таким образом, для случая, когда в качестве eventName задано mousedown, должна появиться строка: trigger mousedown event
//
notification.register(
  // дополните код
  new Event{
    override def trigger(eventName: String): Unit ={
      println(s"trigger $eventName event")
    }
  }
)

notification.sendNotification()