/*class Movie (val  movie:String , val year :Int)

object Movie {
  def accamdyAwardGoesTo (x:Int): Unit = {

    x match {
    case 1930  => Some(new Movie("Enthitan" , 1930))
    case 2010 => Some (new Movie ("test", 2010))
    case _ => "test"
  }

}

Movie.accamdyAwardGoesTo(2010). */


  /* class Movie(val name: String, val year: Short)

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

  Movie.academyAwardBestMoviesForYear(1932).get.name */