import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.col

/*def funhi() = "hi"

funhi()

/*@annotation.tailrec
def power(x:Int , y :Int) = {
if (x>1) 1
else (x *  power(x, y-1))

} */


@annotation.tailrec
def power2 (x:Int, n:Int, t:Int =1 ): Int =
{
  if (x < 1 ) t
  else power2( x, n-1, x*t)
}

//power2(2,3)

// Nesteed functions
def max ( x:Int, y :Int , z:Int) ={

  def max (a:Int, b:Int ) = if (a > b) a else b

  max (x, max(y,z))
}

max(30,20,40)

//Function Overloading

def greet (name :String , gretstring : String ="" ) = s"$name$gretstring"


val gretings = greet ("hello","test")

val greeting2 = greet("hello")


//variable arguments (vararg)

def sum (items :Int*) ={
var total = 0
  for (i <- items) total+=i
  total
 }

sum (10,20,400)


sum()

///type parameters


def idetntify [A] (a:A) = a

val test :String = idetntify[String]("hi")


val test2 = identity[Any]("hi")


val test3 = idetntify[Double](123.7)


val test4 = identity("hasasasas")



//methods and operatars
val s :String = "how are you"

s.endsWith("you")


val d = 66.46666

d.round



def areaofcircle ( radius :Int ) ={
  3.14 * radius * radius
}

areaofcircle(8)


def areaofcircle2 (radius :String ) ={
  if (radius.trim  ==  "" )   println ("Null Hi")
  else (3.14 * radius.toInt * radius.toInt)

}

areaofcircle2("")


def print5() ={
  val toprintval = 1 to 50
  println s"$toprintval"
}
 */
/*
@annotation.tailrec
def fives (cur: Int , maxval : Int) :AnyVal ={

  if (cur <= maxval ) {
    println (cur)
   fives(cur + 5 , maxval)}
  }

fives(0 , 20)



def millisectotime (millsec :Long)= {

  val secs = millsec /1000

  val days = secs/86400

  val hours = (secs % 86400) / 3600

   val minutes = (secs % 3600) / 60
  val seconds = secs % 60

  s"$days  days , $hours hours , $minutes mins. $seconds seconds"

}

millisectotime(1000090887L)


def mathpow ( x:Int, powval :Int): Unit = {
  math.pow(x, powval)
}

def mathpow2  (x:Long, n :Int) ={

  var p = 1.0
  for ( i <- 1 to n)
    p *= x; p

}

mathpow2(2,7)


def point2d (x:(Int,Int), y :(Int, Int) ) ={

(  (x._1 - y._1), (x._2 - y._2))


}

point2d((30,10) ,( 10, 20) )






def execrise7ch4 [A,B](x:(A,B)):(Any, Any)={

  def isnit(t:Any)= t.isInstanceOf[Int]

  (isnit(x._1),isnit(x._2)) match {
    case (false,true) => (x._2,x._1)
    case _ => x
  }

}

execrise7ch4("hi",3)


def exec8ch4[A,B,C](t: (A,B,C)) : (A,String, B,String ,C, String )= {
  (t._1, t._1.toString,t._2,t._2.toString,t._3,t._3.toString)
}

exec8ch4[Int,String,String](1,"hi","hi")



// First Class functions


val x =  def double (x:Int) :Int = x  * 2



val mydouble :Int => Int = double


val mydoublecopy = mydouble
*/
/* Scala Excerises code

def itwillReturn( flag : Boolean) : Option[String] = {

  if (flag) Some("Found value") else None
}

 val value1 = itwillReturn(true)

val value2 = itwillReturn(false)

value1 getOrElse("No Value")
value2 getOrElse("No Value")

value2 getOrElse{ "default Function"}

val someValue :Option[Double] = Some(20.0)
val noValue :Option[Double]= None
val valueS = someValue match {
 case v => v
 case _ => None
}

val valueN= noValue match {
 case Some(n) => n
 case _ => 0.0

}



abstract  class notification

case class emailNotify (email :String, text : String) extends notification
case class smsNotify (mobileNo:String , text:String) extends notification


def checkNotify (notificationtext:notification): String = {
 notificationtext match {
  case emailNotify(person, text) => s"you got an $text from $person"
  case smsNotify(mobno, text) => s"you got a SMS $text from $mobno"
 }
}
println(checkNotify(emailNotify("asdjsakdjkajsd", "12344545454")))


abstract  class device

case class Phone(model :String) extends device {
 def screenOff = "Turning Screen Off"
 }

case class tablet(model:String) extends device {
 def switchOff = "Switch off the device"
}


def goIdle (device :device)={
 device match {
  case p:Phone => p.screenOff
  case t:tablet => t.switchOff

 }}

println(goIdle(Phone("test")))

val someIntValue:Option[Int] = Some(3)
val someNonIntVal:Option[Int] = None

someIntValue.map(x => x*1.5)
someNonIntVal.map(x => x* 1.5)


val number :Option[Int] = Some(3)
val noNumber:Option[Int] = None

number.fold(1)( x => x * 3 )
noNumber.fold(0) (x => x * 3 )


object Greeting {
 def english = "Hi"

 def espanol = "Hola"

}
Greeting.english
Greeting.espanol

class Movie(val name: String, val year: Short)

object Movie {
 def academyAwardBestMoviesForYear(x: Short) = {
  //This is a match statement, more powerful than a Java switch statement!
  x match {
   case 1930 ⇒ Some(new Movie("All Quiet On the Western Front", 1930))
   case 1931 ⇒ Some(new Movie("Cimarron", 1931))
   case 1932 ⇒ Some(new Movie("Grand Hotel", 1932))
   case _ ⇒ None
  }
 }
}

Movie.academyAwardBestMoviesForYear(1932).get.name


class Movie2 (val  movie:String , val year :Int)

object Movie2 {
  def accamdyAwardGoesTo (x:Int) = {
        x match {
    case 1930  => Some(new Movie("Enthitan" , 1930))
    case 2010 => Some (new Movie ("Enthitan2", 2010))
    case _ => None
  }

} }


Movie2.accamdyAwardGoesTo(2010).get.name

class Person (val name :String ,private val superhero :String)


object Person {
 def getSuperhero (x:Person) ={
  x.superhero
 }

 def getSupertest: Unit = {
  val test = new Person("","").superhero
 }
}

val someValue1: Option[String] = Some("I am wrapped in something")

val emptyValue: Option[String] = None

def lambda = (x:Int) => x +1

lambda.apply(1)

lambda(2)
def lambda2 = (x:Int)=> x +2
val lamba3 = (x:Int )=> x +3
lamba3(3)

val  lambda4 = new Function1[Int ,Int]{ def apply(v1:Int ) = v1 -1  }

val `result123` = lambda.apply(3)

lambda4(3)


def summation = (x :Int, y: Int =>Int ) => y(x)
var incrementer = 3
def closure  = (x:Int) => x + incrementer

def mulitply = (x:Int ) => x *30

summation(10 ,closure)
summation(10 ,mulitply)

//Higher Order Function

def addWithoutSyntaxSugar1 (x:Int): Function1[Int, Int] = {
 new Function1[Int, Int ]() {def apply (y:Int):Int = x + y }
}

addWithoutSyntaxSugar1(1).isInstanceOf[Function1[Int, Int]]

def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
 new Function1[Int, Int]() {
  def apply(y: Int): Int = x + y
 }
}
addWithoutSyntaxSugar(1)

addWithoutSyntaxSugar(2)(3)
def fiveAdder: Function1[Int, Int] = addWithoutSyntaxSugar(5)

def addWithoutSyntaxSugar3 (x:Int): Function1[Int, Int] = {
 new Function1 [Int, Int] {def apply (y:Int):Int = x + y}
}

def makeUpper ( xs :List[String]) = xs.map ( _.toUpperCase)


makeUpper(List("abc", "hi", "ajsjdlksajdljd"))


def makeWhateverYouLike (x: List[String],  y : String => String  )
= { x map y }

makeWhateverYouLike(List("ABC") , {x => x.toLowerCase })

def  mynameis= ( x: String) => s"my name is $x"

makeWhateverYouLike(List("ABC") , mynameis )



def makeWhatEverYouLike(xs: List[String], sideEffect: String ⇒ String) =
 xs map sideEffect
val myName = (name: String) => s"My name is $name"


makeWhatEverYouLike(List("John", "Mark"), myName)
*/
/*

val a = List(1, 2, 3)
val b = List(1, 2, 3)
(a eq b)


val c = List ("hi", 1, 3 )

(a == b)
(a eq b)

val stringList:List[String] = Nil
val intList :List[Int] = Nil

stringList == intList

stringList eq intList

intList == Nil
intList eq Nil
a.headOption
a.tail
a.reverse



val aList = List (1, 3,5,7,9)

aList.reverse

aList.length

aList.map { _ *2 }

aList.filter( _ %3 == 0 )

val aList2 = List(1,3,5,7)

aList2.reduceLeft( _ + _)


val head = List (1,3)
val tail = List(5,7)

head ::: tail

head ::: Nil







val d = Nil
val c1 = 3 :: d
val b2 = 2 :: c1
val a1 = 1 :: b2

c1.tail

a1.tail
b2.tail
c1.tail



// apply

val foo = (x:Int) => {
  val y = 5
  x + y
}


foo(2)

foo.apply(2)

//d.apply(List(2))
def foo2 ( x: Int)=  ( x *2 )

val testfunc = foo2 _


def m1(x:Int) = x+3

val f1 = (x:Int) => x+3

f1(2).toString
m1(2).toString


def arrCol(any: String): Column = {
  val toks = any.replaceAll("\\[(\\d+)\\]", "\\.$1").split("\\.")
  toks.tail.foldLeft(col(toks.head))({
    case (acc, tok) => {
      if (tok.matches("\\d+")) {
        acc(tok.toInt)
      } else acc(tok)
    }
  })
}


arrCol("1234456[hello]")


val myMap = Map("hi" -> "vaalkkam", "nadri" -> "Thanks")


myMap.size

val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")

myMap2.size

val anewMap2 = myMap2 + ("Chennai" -> "Tamil Nadu")

anewMap2.contains("Chennai")


val myMap3 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

val mapValues = myMap3.values
mapValues.head
mapValues.last
mapValues.size

val myMapDups = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Meechigan")

myMapDups("MI")

myMapDups.size

val myMapSameVal = Map ("Ann Arbor" ->"MI", 42332 -> "MI")

myMapSameVal("Ann Arbor")

myMapSameVal (42332)

val mapMissingVal = Map ("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin")
mapMissingVal.getOrElse("TX" , "Missing Data")

val myMap4 =
  Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa") withDefaultValue("missing data")



myMap4("TX")


val anewMap4 = myMap4 - "MI"

anewMap4.contains("MI")

val anewMap5 = myMap4 - ("MI", "OH")
anewMap5.contains("MI")



val aSet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")

aSet.size
val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val mySet2 = Set ("Wisconsin", "Michigan", "Minnesota")


val aNewSetIntersect= mySet1 intersect(mySet2)

mySet2 subsetOf(mySet1)

val helloval = "Hello World"

"Application %s".format(helloval)

val t = "Hello World"
"Application %s".format(t)

val a = "aadskads"
val b = 'B'

"%s".format(a)

"%c".format(b)
"%c".format(b)

val c = 'a' //unicode for a
val d = '\141' //octal for a
val e = '\"'
val f = '\\'

"%c".format(c)
"%c".format(d)
"%c".format(e)
"%c".format(f)

val j = 190
"%d bottles of beer on the wall" format j - 100


val k = "vodka"

"%d bottles of %s on the wall" format (j -100 , k)


 object testObject
 {
  def pattenmathcing ( x: String)= {
    x match {
      case "Hi" =>  " Hi, How  are you "
      case "Hello" =>   " hello "
      case _ =>  "Something alien"
    }
  }

}
println(testObject.pattenmathcing("testing"))

object  MatchTest1  {

    def matchTest(x: Int)=  x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many" // case _ will trigger if all other cases fail.
    }

    println(matchTest(3)) // prints "many"

}

println(MatchTest1.matchTest(2))


val stuff= "blue"

val myStuff = stuff match {

  case "red" => println ("Red manu");1
  case "blue" => println ("tes" );2
  case "green" => println ("green");3

}
println(myStuff)

val x = List (1,2,3)
val  matchList = List (1,2,3) match {
  case y ::ys => ys.head
  case _ => 0
}

def goldilocks(expr: Any) = expr match {
  case ("porridge", bear) ⇒
    bear + " said someone's been eating my porridge"
  case ("chair", bear) ⇒ bear + " said someone's been sitting in my chair"
  case ("bed", bear) ⇒ bear + " said someone's been sleeping in my bed"
  case _ ⇒ "what?"
}


goldilocks(("porridge", "Papa"))
goldilocks(("chair","Mama"))


val foodIteam = "porridge"

def goldilocks2 (expr:Any) = expr match {
  case (`foodIteam`, _) => "eating"
  case ("chair", "Mama") => "sitting"
  case ("bed","Baby") => "sleeping"
  case _ => "what?"

}

goldilocks2 (("porridge", "Papa"))
goldilocks2 (("chair", "Mama"))



val testList = List(1) match {
  case x::y::ys => y
  case _ => 0
}

val testList2 = List(1,2,3) match {
  case x::y::Nil => y
  case _ => 0
}


case class Person  (fName :String, lNames: String )

val p1 = new Person("Fred" , "Jones")

val p2 = new Person ("test", "lastname")

val p3 = new Person ("Fred" , "Jones")


  (p1 == p2)

  (p1 == p3)

(p1 eq p2)

(p1 eq p3)


p1.hashCode == p3.hashCode

p1.hashCode == p2.hashCode


case class Dog (name :String , breed :String )


val d1 = Dog ("test1", "test2")

val d2 = Dog ("test3", "test4")

val d3 = new Dog ("test1", "test2")

d1 == d2

d1 == d3


case class Dog2(var name: String, breed: String)
val d12 = Dog2("Scooby", "Doberman")

d12.toString

d12.name = "Scooby new"


case class Person2 (name:String, lastname :String , age :Int = 0 , ssn:String ="")



val p21 = Person2("test", "test1")

p21.age

p21.name



val p10 = Person2.unapply(p21).get



p10._1
p10._2
p10._3
p10._4

p21.asInstanceOf[Serializable]






case class PersonCC(firstName: String, lastName: String)
val indy = PersonCC("Indiana", "Jones")

indy.isInstanceOf[Serializable]



class Person4(firstName: String, lastName: String)
val junior = new Person4("Indiana", "Jones")

junior.isInstanceOf[Serializable]




val rangeNumbers = Range(0,10)

rangeNumbers.size

rangeNumbers.last

val rangeNumbers2 = 0 until 10

rangeNumbers2.size
rangeNumbers2.last


val someNumbers = Range(0,34).inclusive
val otherRange = 0 to 34

(someNumbers == otherRange)
val second = someNumbers(0)
*/

//partially applied functions
def sum ( a:Int , b :Int, c:Int) = a + b + c

val sum3 = sum _
sum3(1,9,7)
sum(4,5,6)


//currying functions

def multiply (x:Int , y :Int ) = x  * y


(multiply _).asInstanceOf[Function2[_,_,_]]

val multiplycurreid = (multiply _ ).curried

multiply(4 ,5)
multiplycurreid(3)(4)
val multlpliedCurriedBy4 = multiplycurreid(4)
multlpliedCurriedBy4(10)



def customFilter (f: Int => Boolean)(xs: List[Int]) = xs filter f

def onlyEven (x :Int) = x % 2 == 0
val xs :List[Int] = List(12, 11, 5, 20, 3, 13, 2)


onlyEven(34)

customFilter (onlyEven)(xs)


val doubleEvens :PartialFunction[Int, Int] =
  new PartialFunction[Int, Int ] {
  def isDefinedAt(x:Int) = x % 2 ==0

  def apply(x :Int) = x *2

}


val triplePods: PartialFunction[Int,Int] = new PartialFunction[Int, Int] {
  def isDefinedAt(x :Int) = x %2 != 0

  def apply(x:Int) = x * 3

}

val whatToDo = (doubleEvens) orElse (triplePods)
whatToDo.apply(12)


def doubleEvens2 :PartialFunction[Int, Int] = {
  case x if (x % 2) == 0 => x * 2

}

def triplePods2 :PartialFunction[Int,Int]= {
  case x if (x % 2) != 0 => x * 3
}

val whatToDo2 = doubleEvens2 orElse triplePods2

whatToDo2(4)

val addFive = (x:Int) => x + 5


val whatToDO3 = doubleEvens2 orElse  triplePods2 andThen addFive


whatToDO3(3)


def printEven:PartialFunction[Int, String] = {
  case x if x  % 2 == 0 => "Even"
}
def printOdd:PartialFunction[Int, String]= {
  case x if x % 2 != 0 => "Odd"
}


val whatToDo4 = (doubleEvens2 orElse triplePods2 ) andThen  ( printEven orElse printOdd)


whatToDo4(3)


abstract class semiGroup [A] {
  def add (x:A, y:A): A }


abstract class monoid[A] extends  semiGroup[A]{
  def unit :A
}



object ImplicitTest2 extends App {
  implicit object StringMoniod extends monoid[String] {
    def add ( x:String, y:String) :String = x +  y
    def unit =""
  }

}
/*
def sumofString(x:String, y :String ):String = x + y

class tetsClass (val orginal :Int ) {
  def isOdd = orginal %2 != 0

}
 implicit def newMethod(value:Int) = new tetsClass(value)


19.isOdd
20.isOdd


*/


import java.math.BigInteger
implicit def Int2BigIntegerConvert(value: Int): BigInteger =
  new BigInteger(value.toString)

def add(a: BigInteger, b: BigInteger) = a.add(b)

add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9)

add(3, 6) == 9
add(3, 6) == Int2BigIntegerConvert(9)

add(3, 6) == (9: BigInteger)
add(3, 6).intValue == 9



/*def calHours (timeSpend:Int)(implicit ratePerHour :BigDecimal) = timeSpend * ratePerHour


implicit  val rate = BigDecimal(34)

calHours(30)


def howMuchPerContacter (hours :Int)(implicit rate:BigDecimal , currency : String)=
 {
  hours * rate + " " + currency
}

implicit val rater = BigDecimal(34)

implicit val currenyDollar = "Dollars"

howMuchPerContacter(30) */

def howmuchImake (hoursiwork :Int) (implicit rate:BigDecimal = 34, currencyconv:String = "Dollars")
={
  (hoursiwork * rate ).toString() + " " + currencyconv
}

howmuchImake(30)

howmuchImake(30)(95)




