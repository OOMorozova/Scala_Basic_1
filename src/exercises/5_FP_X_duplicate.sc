//Ваша задача - написать функцию duplicate(someList, numDups),
// которая создает указанное количество numDups дубликатов каждого элемента списка someList.
//Например, если был передан список List(1, 2, 3), а numDups = 2, то результатом будет List(1, 1, 2, 2, 3, 3)

//def duplicate[A](someList: List[A], numDups: Int = 1): List[A] = {
//  var res = List[A]()
//  for (x <- someList) {
//    for (i <- (1 to numDups)) res :+= x
//  }
//  res
//}
//def duplicate[A](someList: List[A], numDups: Int): List[A] = {
//  someList.flatMap(l => List.fill(numDups)(l))
//}

def duplicate[A](someList: List[A], numDups: Int): List[A] = someList.flatMap(List.fill(numDups)(_))

println(duplicate(List("a","b"),3))
println(duplicate(List(1, 2, 3),2))