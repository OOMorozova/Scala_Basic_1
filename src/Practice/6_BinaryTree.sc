//1) Бинарное дерево состоит из узлов, каждый из которых имеет свое значение.
//В таком дереве каждый узел:
// либо не имеет потомков вообще (такие узлы называются листьями),
// либо имеет только одного потомка (правого или левого),
// либо имеет обоих потомков.
//Самый верхний узел является корнем дерева.

import scala.util.{Failure, Success, Try}
abstract class BinaryTree[+T] {
  def value: T
  def leftChild: BinaryTree[T]
  def rightChild: BinaryTree[T]

  def isEmpty:  Boolean

  def isLeaf: Boolean
  def collectLeaves: List[BinaryTree[T]]
  def countLeaves: Int
  def nodesAtLevel(level: Int): List[BinaryTree[T]]
  def collectNodes(): List[T]
}

case object TreeEnd extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException
  override def rightChild: BinaryTree[Nothing] = throw  new NoSuchElementException

  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false
  override def collectLeaves: List[BinaryTree[Nothing]] = List()
  override def countLeaves: Int = 0
  override def nodesAtLevel(level: Int): List[BinaryTree[Nothing]] = List()
  override def collectNodes(): List[Nothing] = List()

}

case class Node[+T](
                     override val value: T,
                     override val leftChild: BinaryTree[T],
                     override val rightChild: BinaryTree[T])
  extends BinaryTree[T] {

  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

//2) получение списка всех листьев дерева -  метод collectLeaves.
// узел считается листом, если у него нет ни правого, ни левого потомка.
  override def collectLeaves: List[BinaryTree[T]] = {
    if (isLeaf) List(this)
    else (leftChild.collectLeaves ++ rightChild.collectLeaves)
  }

//  override def collectLeaves: List[BinaryTree[T]] = {
//    var res: List[BinaryTree[T]] = List()
//    def loop(cur: BinaryTree[T], acc: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {
//      if (cur.isLeaf) {
//        res :+= cur
//        res
//      }
//      else {
//        if (cur.rightChild != TreeEnd) loop(cur.rightChild, res)
//        if (cur.leftChild != TreeEnd) loop(cur.leftChild, res)
//        res
//      }
//    }
//
//    loop(this, res)
//  }

//3)  подсчитать общее количество листьев, присутствующих в дереве
  override def countLeaves: Int = this.collectLeaves.length
//4)  получить список значений узлов дерева на заданном уровне.
  override def nodesAtLevel(level: Int): List[BinaryTree[T]] = {
    if (level == 0) List(Node(this.value, TreeEnd, TreeEnd))
    else leftChild.nodesAtLevel(level-1) ++ rightChild.nodesAtLevel(level-1)
  }
//5) собрать значения всех узлов дерева в один общий список без использования nodesAtLevel
  override def collectNodes(): List[T] = {
    List(this.value) ++ leftChild.collectNodes() ++ rightChild.collectNodes()
  }

}

//6) возвращает true, если в заданном дереве tree существует такой путь от корня до листа,
//  что сумма значений узлов, лежащих на этом пути, равняется заданному значению target.
def hasPath(tree: BinaryTree[Int], target: Int = 0): Boolean = {
  if (tree.isEmpty) target == 0
  else if (tree.isLeaf) (target - tree.value) == 0
  else hasPath(tree.leftChild, target - tree.value) | hasPath(tree.rightChild, target - tree.value)
}
//
////7) получить все имеющиеся в дереве пути от корня до листа, удовлетворяющие заданному условию.
def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
  def Roads(tree: BinaryTree[String], acc: List[String]): List[List[String]] = {
    if (tree.isEmpty) Nil
    else if (tree.isLeaf) List(acc :+ tree.value)
    else {
      val res = acc :+ tree.value
      Roads(tree.leftChild, res) ++ Roads(tree.rightChild, res)
    }
  }
  val r =  Roads(tree, List())
  r.filter(x=> x.map(_.toInt).sum == target.toInt)
}

//def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
//  def loop(tree: BinaryTree[String]): List[List[String]] = {
//    tree match {
//      case Node(value, TreeEnd, TreeEnd) => List(value :: Nil)
//      case Node(value, TreeEnd, rightNode)  => loop(rightNode).map(value :: _)
//      case Node(value, leftNode, TreeEnd) => loop(leftNode).map(value :: _)
//      case Node(value, leftNode, rightNode)  => (loop(leftNode) ++ loop(rightNode)).map(value :: _)
//      case _ => Nil
//    }
//  }
//  loop(tree).filter(_.map(_.toInt).foldLeft(0)(_ + _) == target.toInt)
//}

//def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
//  def go(t: BinaryTree[String] = tree, prev: List[Int] = Nil): List[List[Int]] =
//    if (t.isEmpty) Nil
//    else {
//      val next = prev :+ t.value.toInt
//      if (t.isLeaf && next.sum == target.toInt) List(next)
//      else if (t.isLeaf) Nil
//      else go(t.leftChild, next) ++ go(t.rightChild, next)
//    }
//  go().map(_.map(_.toString))
//}

val tree = Node(1,
  Node(2,
    Node(4,
      TreeEnd,
      TreeEnd),
    Node(5,
      TreeEnd,
      Node(8,
        TreeEnd,
        TreeEnd))),
  Node(3,
    Node(6,
      TreeEnd,
      TreeEnd),
    Node(7,
      TreeEnd,
      TreeEnd)))

println(tree.collectLeaves.map(_.value).sorted)
println(tree.countLeaves)
println(tree.nodesAtLevel(2).map(_.value).sorted)
println(tree.collectNodes())
println(hasPath(tree, 8))

val tree_str = Node("1",
  Node("2",
    Node("4",
      TreeEnd,
      TreeEnd),
    Node("5",
      TreeEnd,
      Node("8",
        TreeEnd,
        TreeEnd))),
  Node("3",
    Node("6",
      TreeEnd,
      TreeEnd),
    Node("7",
      TreeEnd,
      TreeEnd))
)
println(findAllPaths(tree_str, "10"))
