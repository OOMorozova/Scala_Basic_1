//Примечания: от вас требуется написать лишь код классов. Создавать экземпляры классов и что-то принтить не надо
// Instructor: id, name, surname
//Методы класса:
//  - fullName: возвращает полное имя в виде Имя Фамилия. первые буквы имени и фамилии обязательно должны быть
//  заглавными, изменять регистр остальных букв не требуется
//
// Course: courseID, title, releaseYear, instructor
//Методы класса:
//  - getID: возвращает id в формате courseID + instructor.id (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
//  - isTaughtBy(instructor): проверяет, является ли указанный человек инструктором курса
//  - copyCourse(newReleaseYear): возвращает новый экземпляр класса Course с обновленным значением поля releaseYear
//
class Instructor(val id: Int, val name: String, val surname: String) {
  def fullName(): String=name.substring(0,1).toUpperCase ++ name.substring(1, name.length) ++ " " ++ surname.substring(0,1).toUpperCase ++ surname.substring(1, surname.length)
}

class Course(val courseID:Int, val title: String, var releaseYear:String, val instructor: Instructor) {
  def getID: String=this.courseID.toString ++ this.instructor.id.toString
  def isTaughtBy(instructor: Instructor): Boolean=if (instructor == this.instructor) true else false
  def copyCourse(newReleaseYear: String): Course=new Course(this.courseID, this.title, newReleaseYear, this.instructor)
}