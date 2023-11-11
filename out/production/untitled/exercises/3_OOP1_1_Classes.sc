//Дан код, в котором пропущена строка:
//Что именно надо дописать, чтобы на выходе было John's salary is 0.0?

class Employee(val name: String, var salary: Double) {
  def this() = this("John", 0.0) // здесь пропущена строка кода
}

val employee = new Employee()
println(s"${employee.name}'s salary is ${employee.salary}")