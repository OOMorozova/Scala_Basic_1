//Повторим условие еще раз (все перечисленное ниже уже прописано в системе):
//
//  нам доступно значение хоста (host) и порт (port)
//  есть сервер, который дает доступ к HTML странице
//  вам доступен метод render(page), выводящий содержимое страницы на экран
//для доступа к HTML странице по заданному url в классе Connection описан метод get(url: String). Е
// сли действие успехом не увенчалось, выбрасывается исключение, сообщающее о том, что Your Connection was Interrupted
//сам процесс соединения с сервером описан в объекте HttpService, в методе apply (вот только сама имплементация от вас скрыта)
//на вход apply подается host и port
//если подключиться к серверу не удалось, срабатывает исключение с сообщением Someone else took the port
//
//
//Ваша цель: воспользовавшись доступным функционалом, установить соединение с сервером и получить HTML страницу,
// содержимое которой следует вывести на экран. Главное здесь - разобраться с возможными исключениями.

//не воспроизводимо
import scala.util.{Failure, Success, Try}

//def safeConnection(host: String, port: String): Try[Connection] = Try(HttpService(host,port))
//val conn = safeConnection(host, port)
//if (conn.isSuccess)
//{
//  val page = Try(conn.get.get("https://stepik.org/"))
//  if (page.isSuccess) render(page.get)
//}