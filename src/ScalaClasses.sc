import java.util.Date

class Car ( val carName : String , var reserve :Boolean) {
def toString ( r:Boolean)= { reserve = r }
}

class Lotus(val colorName:String, modelName :String  ) extends Car ("Hyundai", false){

}
val l = new Lotus("White", "Elantra")
l.colorName
l.carName
l.reserve


//type Prarameters

def identify [A](someval: A) : A = someval

identify[String]("hello")
  val testIdentify = identify("asjdaskjdsad")
val testIdentify2 = identify(1214)


//define a class with default parameters

class CarwithDefaultVals ( val carName :String, var soldFlag :Boolean = false, val carMake :String ,carYear :Int = 2019 )
{
  def toString1 = s"$carName , $soldFlag , $carMake , $carYear"
}

val newvalfor = new CarwithDefaultVals("Hyundai" , carMake = "Elantra")

newvalfor.toString1



////Class with Type parameters

class Singular [A](element :A ) extends Traversable[A] {
  def foreach [B](f :A => B) = f(element)
}

val p = new Singular("Planes")

//p.foreach [String]println

p foreach println


///ABstract Class

abstract class CarAbstract {
  val carName:String
  val carYear:Int
  def color :String
  }

class extendCar (val color :String = "Red")extends CarAbstract {
  //def color = "Red"
  override val carName: String = "Mini"
  override val carYear: Int = 2019

}

val p2 = new extendCar
p2.carName
p2.carYear
p2.color



abstract class abstractCar2 {
  val carName2 :String
  def color2()
}

class extendCar2 extends abstractCar2 {
  val carName2: String = "test"
  def color2() = println("hi")

}

val p3 = new extendCar2
p3.color2()
p3.carName2

abstract class Listener { def trigger}

class Notifier {

  var listener :Listener = null
  def register(l: Listener) ={listener =l}
  def sendNotfication {listener.trigger}

}

val test = new Notifier()
test.register {
  new Listener {
    def trigger { println("hi")}
  }
}
test.sendNotfication
val l2 :Seq[String] = "Hi" :: "Hello" ::"tateastasttasats" ::Nil

l2.mkString(", ")

class Printer (msgtoPrint: String) {
  def print(msg: String) = println(msg)

  def print(msg: Seq[String]) = println(msg.mkString(", "))
}

new Printer("today report").print(l2)


//// Privacy Contols

class User { protected val pwd = util.Random.nextString(1)}

class ValidUser extends User { def isValid = !pwd.isEmpty}


val test23 = new ValidUser().isValid
val tets344 = new User()
println(tets344)

//// Protected values are accessible to its subclass , whereas
/// private values are not accessible to subclasses

class UserPwd ( private var password :String) {
  def update (p: String) ={
    println ("Modifying the password")
    password = p
      }
  def validate (p:String):Boolean={
    if (password == p) true else false

  }
}

/*class UserPwdextension extends UserPwd("1245")
{
  password = "125255"
}
val test134 = new UserPwdextension()
test134.password
*/

val testuserPwd = new UserPwd("1234")
//testuserPwd.validate("3457")
//testuserPwd.update("3457")

//package com.vinoth.myapp
/*
package com.vinoth
{
  //private [vinoth] class config {
//    val url = "http://localhost"

  package vintoh{
    class Config (pString :String) {val  pString123 = "https://localhost"}
  }
}
*/

class Console(val make :String , val model :String ,
                 var debut_date:Date , val wifiType : Option[String],
                 val phyModelSprt :String , val maxVideoRes:Byte  ) {
  override def toString = "Consolde123"
  debut_date = new java.util.Date


}
import java.util.Date
import java.text.SimpleDateFormat





val format = new SimpleDateFormat("dd/MM/yyyy")
var date = format.parse("22/05/2013")

val value1 = new Console("Xbox", "one",date,Some("none"),"test",12)

value1.make
value1.phyModelSprt
value1.wifiType
class Games(val name :String ,maker :String , consoles :String) {
  def isSupported () ={ if (consoles == "test") true else false }
}
