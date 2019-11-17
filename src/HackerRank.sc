import com.sun.org.apache.xpath.internal.operations.And

import scala.collection.mutable.ArrayBuffer

val meal_cost = 20
val tip_percent = 8
val test:Double = meal_cost * (tip_percent.toFloat/100)

test.round

    val n = 22
if (n%2 == 0) "even" else "odd"

if (n%2 != 0) {
  print("Weird")
}
else if ((n%2 == 0 ) & (n <= 5 )) {
  print ("Not Weird")
  }
else if ((n%2 == 0 ) &  (n >= 6 ) & (n <= 20)) {
  print ("Weird")
}
else if ((n%2 == 0 ) &  (n > 20 ) ) {
  print ("Not Weird")
}


/// Challenge 4

class Person {
  var age: Int = 0

  def this(intitilage: Int) {
    this()
    if (intitilage < 0) {
      println("age is not valid ,setting age to 0 ")
      age
    }
    else {
      println("age is valid")
      age = intitilage
    }

        def yearPasses(): Unit = {
                age += 1
        }

        def amIOld() = {
                      if (age < 13 ) {
              println ("You are young..")
            }
            else if (age >= 13 & age <18 ){
              println ("You are a teenager..")
            }
            else if (age > 18){
              println("You are old..")

            }
        }
  }
}

val multple =2
for (  i <-  1 to 10 ) {
  val result = multple * i
  println(result)

}



def oddorEvenString (inputstring :String) ={
  var evenwords = ""
  var oddwords = ""
for (i <- 0 until   (inputstring.length() ) ) {


  if (i %2 ==0) {
    evenwords += inputstring.charAt(i)
      }
  else {
    oddwords += inputstring.charAt(i)

  }
}
  println(evenwords)
  println(oddwords)

}

oddorEvenString("Hacker")

val arr = "2 3 4 5"

arr.split(" ").map(_.trim.toInt)
var emptyarr = Array()

for (i <- arr.reverse ) {
   print(i)
}



val phoneBook = Map(("sam" ,"99912222"), ("tom" ,"11122222") ,("harry", "12299933"))

val serachInput = "edward"

if (phoneBook.contains(serachInput.trim))
  phoneBook(serachInput)
else "Not Found"



def convertToMap(lines:String) ={
  val splitsVal = lines.split(",")

  (splitsVal(0),splitsVal(1))

}



val line = "hi,1234"
convertToMap(line)

//val num = scala.io.StdIn.readLine()


for ( i<- 1 to 5) {
  for ( j <- 1 to i ) { print("*")}
  println("")

}

def factorial (n:Int) :Int ={

   val previousval = if (n <=2) n else  n * factorial(n-1)

  previousval

}

factorial(10)

// Binary repsentation

val tempInt = 130012

val temp = tempInt.toBinaryString.toLong // 101
var listOfOnes = temp.toString.split("0").toList

println(listOfOnes.max.size)

//print (5/2)



val testArrary = Array(1,2,3,4,5,6,7)

var sumval = 0

for (x <- 0 to testArrary.length -1 ) {
  sumval += testArrary(x)
//  println(sumval)
}
println(sumval)

var sumofMultidimesinalArray = 0
val testMultiDimesionalarray = Array(Array(1,2,3,4,5,6),
  Array(1,2,3,4,5,6), Array(1,2,3,4,5,6),Array(1,2,3,4,5,6),
  Array(1,2,3,4,5,6),Array(1,2,3,4,5,6))
for ( i <- 0 to 5 ) {
  for (j <- 0 to 5) {
    sumofMultidimesinalArray +=(testMultiDimesionalarray(i)(j))

  }
}


println(sumofMultidimesinalArray)

val favNums= new Array[Int](20)

val arrayBufer = new ArrayBuffer[Int]



class Person2 {

}

class student(val firstName:String,
              lastName :String,
              id:Int,
              scores:ArrayBuffer[Int])
  extends Person2{
def calculate() ={
  val scoreTotalavg = scores.sum/2
println(scoreTotalavg)
//  if (scoreTotalavg >= 90 || scoreTotalavg <= 100 ){
//    "O"
//  }
 if (scoreTotalavg >= 90 ) {
    "E"
  }
  else if (scoreTotalavg >= 70 && scoreTotalavg < 80) {
   "A"
  }
  else if (scoreTotalavg >= 55 && scoreTotalavg < 70) {
    "P"
  }
  else if (scoreTotalavg >= 40 && scoreTotalavg < 55) {
    "D"
  }
  else {
      "T"
  }
}
}
var testclass1 = new student("vinoth12", "kumar12", 13,ArrayBuffer(100,90))


testclass1.calculate()

//line.split(",").map({
//  pair =>  val Array(k,v) = pair.split(",")
////    (k.trim -> v.toInt)
//})

//val str = "a=10, b=20, c=30"
//
//val values: Map[String, Int] = str // drop braces
//  .split(",") // split into key-value pairs
//  .map { pair =>
//  val Array(k, v) = pair.split("=") // split key-value pair and parse to Int
//  (k.trim -> v.toInt)
//}.toMap



//val stdin = scala.io.StdIn

//val ntest = stdin.readLine.trim.toInt

//val sc = new java.util.Scanner (System.in)
//val mapSize = sc.nextInt()
//var mapValues = new Array[String](mapSize)

//for(arr_i <- 0 to n-1) {
//  mapValues(arr_i) = sc.next()
//}





//// Problem  statement
// Detemine list has odd or even values

// define a list --done
//// for loop to go through the list --done
/// determine its or even
/// for determine its even n%2 ==0 that menas its even , increament even var + 1
/// for determine its odd n%2 !=0 that means its odd, Incremnt odd + 1
//// Intialize a counter for even and odd
//// if the
/// at end if the even > odd  print even value
/// else the odd value

val listofIntegers :List[Int] = List(1,2,3,4,5,6,7,9,10)
var evenCounter = 0
var oddCounter = 0

for ( i <- 0 to listofIntegers.length -1 ) {
//  println(listofIntegers(i))

  if (listofIntegers(i)%2==0) {
    println ("Even " + listofIntegers(i))
    evenCounter += 1
  }
  else {
    println("Odd " + listofIntegers(i))
    oddCounter += 1
  }

}
println(evenCounter)
println(oddCounter)

if (evenCounter > oddCounter) println("even is winner " + evenCounter)
else if (evenCounter == oddCounter) println("both are equal")
else println("odd is Winner " + oddCounter)

val testList = List(3,4,5)



import scala.math._
for ( i <-  testList.indices ) {
  if (abs(testList(i) - testList(i+1)) < abs(testList(i)- testList(i + 2))) {
  println(testList(i) + "is closer" + testList(i + 1))
}
else {
  println("interesting")
 } }

/// Problem Statement find a number in list closest
// to each other
/// Define a list
/// Take a list loop the list
/// Take the first value and compare it with other values
/// store the value to array with the value and difference

