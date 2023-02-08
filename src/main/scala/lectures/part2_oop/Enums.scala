package lectures.part2_oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit =
      if (this == READ ) println("Opening document...")
      else println("Reading not allowed.")
  }

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends  PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }



  def main(args: Array[String]): Unit = {

    val readPermission: Permissions = Permissions.READ
    val writePermission: Permissions = Permissions.WRITE
    // standard API
    val somePermissionsOrdinal = writePermission.ordinal

    readPermission.openDocument()
    writePermission.openDocument()
    println(somePermissionsOrdinal)

  }

}
