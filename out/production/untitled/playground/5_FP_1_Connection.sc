//Поработаем с API, про который известно следующее:
//
//  доступно поле config вида Map[String, String], хранящее в себе два ключа: ip адрес хоста (host) и порт (port)
//у вас нет гарантии, что у ключа есть значение, могло ведь случиться, что в конфигурационном файле, откуда значения хоста и порта должны были считаться, эти значения отсутствовали
//в наличии класс Connection с методом connect, устанавливающим соединение с сервером. В случае установки соединения выдается уведомление "Connected". Не факт, что соединение будет установлено.
//у класса есть объект-компаньон с методом apply , который возвращает Option[Connection]. Именно этот метод отвечает за отправку запроса на создание нового соединения.
//
//
//  Ваша цель: установить соединение с сервером

//не воспроизводимо
val forConnectionStatus = for {
  host <- config.get("host")
  port <- config.get("port")
  connection <- Connection(host, port)
} yield connection.connect

forConnectionStatus.foreach(println)