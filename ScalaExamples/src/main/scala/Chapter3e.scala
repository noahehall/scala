object Chapter3e {
  def partyAtHome(guests: Int, tentAvailable: Boolean): Boolean =
    if guests < 15 then true
    else if tentAvailable && guests < 40 then true
    else false
  end partyAtHome

  def weather(sunny: Boolean): String = sunny match
    case true => "yay! Where are my sunglasses?"
    case false => "oh where is my umbrella?"
  end weather

  def greeting(friend: String): String = friend match
    case "Ada" => "hi Ada!"
    case "Deji" => "hi Deji!"
    case _ => "hi! What's your name?"
  end greeting

  def greeting2(friend: String): String = friend match
    case "Ada" | "Deji" => "hi my friend! Long time no see!"
    case newFriend => s"hi $newFriend! It's so nice to meet you!"
  end greeting2

  //challenge
  def competition(result: Int): String =
    if result == 1 then "gold"
    else if result == 2 then "silver"
    else if result == 3 then "bronze"
    else "well done!"
  end competition

  def competition2(result: Int): String = result match
    case 1 => "gold"
    case 2 => "silver"
    case 3 => "bronze"
    case _ => "well done!"
  end competition2
}
