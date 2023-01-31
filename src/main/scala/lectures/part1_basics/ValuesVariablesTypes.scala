package lectures.part1_basics

object ValuesVariablesTypes extends App {


    // START OF VAL ----------------------------------------------------------------------------------------------------
    // VAL'S ARE IMMUTABLE
    val x: Int = 43
    println(x)

    // Types are optional - Compiler can infer types
    val y = 44
    println(y)

    // Semi-colon are optional
    val aString: String = "Hello"
    val bString: String = "Goodbye";
    println(aString)
    println(bString)

    val aBoolean: Boolean = false
    val aChar: Char = 'a'
    val aShort: Short = 4615 // Shorts have less than 5 digits
    val aLong: Long = 527839852783895237L // Longs needs a 'L' at the end
    val aFloat: Float = 2.0f //Float needs a 'f' in the end otherwise it represents it as a double
    val aDouble: Double = 3.1416

    // END OF VAL ------------------------------------------------------------------------------------------------------

    // START OF VAR ----------------------------------------------------------------------------------------------------
    /** Variables are used for side effects
        Since it allows it to modify variables without complains in the compiler **/
    var aVariable: Int = 4
    aVariable = 5

    // END OF VAR ------------------------------------------------------------------------------------------------------
}
