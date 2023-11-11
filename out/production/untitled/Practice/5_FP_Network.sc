//разработка маршрутной сети для авиакомпании
// Cеть будет хранить ассоциации между пунктом отправления и всеми доступными для него пунктами назначения.
// Чтобы эти ассоциации создать, нужно сначала предоставить системе список возможных локаций.

//добавляет локацию в маршрутную сеть
def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = network + (location -> Set())

//удаляет маршрут
def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
  val routesForA: Set[String] = network(pointA)
  val routesForB: Set[String] = network(pointB)
  network + (pointA -> (routesForA - pointB)) + (pointB -> (routesForB - pointA))
}

//удаляет локацию из маршрутной сети
def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
  def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] =
    if (destinations.isEmpty) acc
    else loop(destinations.tail, disconnect(acc, location, destinations.head))
  val disconnected = loop(network(location), network)
  disconnected - location
}

//связывает две локации между собой (учитывать, что связь действует в обе стороны,
// т.е. становится доступным маршрут как туда, так и обратно)
def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
  val routesForA: Set[String] = network(pointA)
  val routesForB: Set[String] = network(pointB)
  network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
}

// возвращает количество доступных прямых перелетов из заданной точки
def nFlights(network: Map[String, Set[String]], location: String): Integer = network(location).size

//проверяет, связаны ли две точки между собой
// (учитывать возможные пересадки, необходимые чтобы перелететь из одной точки в другую)
def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
  val routesForA: Set[String] = network(pointA) + pointA
  val routesForB: Set[String] = network(pointB) + pointB
  if (routesForA.intersect(routesForB).size > 0) true
  else false
}

//возвращает точку, из которой доступно больше всего прямых перелетов
def mostFlights(network: Map[String, Set[String]]): String = network.maxBy(_._2.size)._1

//возвращает количество точек, не включенных ни в один маршрут
//def nLocationsWithNoFlights(network: Map[String, Set[String]]): Integer = network.filter(x => x._2.size == 0).size
def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = network.count(_._2.isEmpty)


var network: Map[String, Set[String]] = Map("A" -> Set("B"), "B" -> Set("A", "C"), "C" -> Set("B"), "D" -> Set("F"), "F" -> Set("D"))

print(isConnected(network, "A", "D")) //false
print(isConnected(network, "A", "C")) //true

network = add(network, "E")
network = connect(network, "E", "A")
network = disconnect(network, "E", "A")
network = remove(network, "F")
nLocationsWithNoFlights(network)
network = connect(network, "E", "D")
nFlights(network, "B")
mostFlights(network)

//Возможные улучшения:
//предусмотреть работу с дубликатами
//под методы создать класс
//предусмотреть отсутствие ключа - вспомнить про Try