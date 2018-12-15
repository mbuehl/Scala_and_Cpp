/*
10.2 Querying with For-Comprehensions
The for-notation is essentially equivalent to common operations of database query
languages. For instance, say we are given a database books, represented as a list of
books, where Book is defined as follows.
*/

case class Book(title: String, authors: List[String])

val books: List[Book] =
  List(
    Book("Structure and Interpretation of Computer Programs",
      List("Abelson, Harold", "Sussman, Gerald J.")),
    Book("Principles of Compiler Design",
      List("Aho, Alfred", "Ullman, Jeffrey")),
    Book("Programming in Modula2",
      List("Wirth, Niklaus","Abelson, Harold", "Ullman, Jeffrey")),
    Book("The Java Language Specification",
      List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")),
    Book("Introduction to Functional Programming",
      List("Bird, Richard")),
    Book("The Java Language Specification",
      List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")),

    Book("The Java Language Specification",
      List("Gosling, James"))
  )

for (b <- books; a <- b.authors if a startsWith "Ullman") yield b.title


//(Here, startsWith is a method in java.lang.String). Or, to find the titles of all
//  books that have the string “Program” in their title:
val cc = for (b <- books
     if (b.title indexOf "Program") >= 0) yield b.title
println(cc mkString("\n"))

//Or, to find the names of all authors that have written at least two books in the
//  database.
for (b1 <- books; b2 <- books
     if b1 != b2;
     a1 <- b1.authors;    a2 <- b2.authors
     if a1 == a2) yield a1 mkString("\n")

//GENERIC
def removeDuplicates[A](xs: List[A]): List[A] =
  if (xs.isEmpty) xs
  else xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))

removeDuplicates(books).length


//CONCRETE title
def removeDuplicatesBkTitle(xs: List[Book]): List[Book] =
  if (xs.isEmpty) xs
  else xs.head :: removeDuplicatesBkTitle(xs.tail filter  (x => x.title != xs.head.title) )

removeDuplicatesBkTitle(books)
removeDuplicatesBkTitle(books).length

//xs.head :: removeDuplicates(for (x <- xs.tail if x != xs.head) yield x)