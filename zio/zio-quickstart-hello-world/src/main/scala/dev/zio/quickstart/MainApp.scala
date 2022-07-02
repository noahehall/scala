package dev.zio.quickstart

import zio.*

object MainApp extends ZIOAppDefault:
  def run =
    for {
      _    <- Console.print("Please enter your name: ")
      name <- Console.readLine
      _    <- Console.printLine(s"Hello, $name!")
    } yield ()
