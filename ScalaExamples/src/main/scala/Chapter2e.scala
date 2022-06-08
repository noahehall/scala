object Chapter2e {
  // types
  val favouriteDessert = "brownie"
  val favouriteDessert2: String = "brownie"

  // functions
  def sum(n1: Int, n2: Int): Int = n1 + n2

  def lightSwitch(switchOn: Boolean = false): String = if switchOn then "light on!" else "light off!"

  // challenge
  def product(n1: Int, n2: Int): Int = n1 * n2

  def greeting(name: String = "stranger") = s"Hi, $name!"
}
