//x--7.8 Imperative-style vs. FUNCTIONAL  - E.G.: multiplication   TABLE
//
//x        FUNCTIONAL style

val pdngSz = 5

// Returns a full row as a (String) sequence
def makeRowSeq(row: Int) = {
  for (col <- 1 to 10) yield {
                        val prdct = (row * col).toString
                        val padding = " " * (pdngSz - prdct.length)

                        padding + prdct
                      }
}

// Returns a row as a string  -> converting from Vector to plain string
def makeRow(row: Int) = {
  makeRowSeq(row).mkString
}

// Returns table as a string with one row per line
def multiTable() = {
                  // a sequence of row strings
  val tableSeq = for (xx <- 1 to 10) yield makeRow(xx)

  tableSeq  //this is a Vector of strings
}//end-of-functional

multiTable() mkString("\n","\n",".")


//x   IMPERATIVE STYLE - Java like
def printMultiTable() {
  var i = 1
  // only i in scope here
  while (i <= 10) {
    var j = 1
    // both i and j in scope here
    while (j <= 10) {
      val prod = (i * j).toString
      // i, j, and prod in scope here
      var k = prod.length
      // i, j, prod, and k in scope here
      while (k < 4) {
        print(" ")
        k += 1
      }
      print(prod)
      j += 1
    }
    // i and j still in scope; prod and k out of scope
    println()
    i += 1
  }
  // i still in scope; j, prod, and k out of scope
}

"IMPERATIVE STYLE - Java like:  \n"
printMultiTable()
/*
x 7.9 Conclusion
    Scala’s built-in control structures are minimal, but they do the job. They
    act much like their imperative equivalents, but because they tend to result
    in a value, they support a functional style, too. Just as important, they are
    careful in what they omit, thus leaving room for one of Scala’s most powerful
    features, the function literal, which will be described in the next chapter
*/