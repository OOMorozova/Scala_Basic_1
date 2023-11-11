//Написать метод, позволяющий сравнивать версии между собой. Метод возвращает:
//  -1 (если v1 < v2)
//  0 (если v1 = v2)
//  1 (если v1> v2)
//результатом сравнения 1.0.2.03 и 1.1.0 будет -1 (1.0.2.03 < 1.1.0, так как 0 < 1)
//результатом сравнения 2.1 и 2.01 будет 0 (не забудьте предусмотреть в программе случаи, когда номера начинаются с нулей)
//результатом сравнения 3.0 и 3.0.0.0 также будет 0
//для 4 и 4.0.0.1 будет -1,  а для 4.0.1 и 4.0.0.1 будет 1
import scala.util.boundary, boundary.break

def compare(v1: String, v2: String): Int ={
  var lv1 = v1.split("\\.").map(_.toInt)
  var lv2 = v2.split("\\.").map(_.toInt)
  var res = 0
  boundary:
    for (i <- (lv1.zipAll(lv2, 0, 0))) {
      if (i._1 != i._2) {
        if (i._1 < i._2) {
          res = -1
          break(-1)
        }
        else {
          res = 1
          break(1)
        }
      }
  }
  res
}

println(compare("1.0.2.03", "1.1.0")) //-1
println(compare("2.1", "2.01")) //0
println(compare("3.0", "3.0.0.0")) //0
println(compare("4", "4.0.0.1")) //-1
println(compare("4.0.1", "4.0.0.1")) //1

//def compare(v1: String, v2: String): Int = {
//  val version1 = v1.split("\\.").map(_.toInt).toList
//  val version2 = v2.split("\\.").map(_.toInt).toList
//  val all = version1.zipAll(version2, 0, 0).map(x => x._1 - x._2)
//
//  all match {
//    case list: List[Int] if !list.exists(x => x != 0) => 0
//    case list: List[Int] if list.exists(x => x != 0) => list.filter(x => x != 0).head
//  }
//}
