package com.niyaj.neetcode

import org.example.utils.Printer

// This is the com.niyaj.neetcode.main entry point of the application.
// It uses the `Printer` class from the `:utils` subproject.
fun main() {
    val message = "Hello JetBrains!"
    val printer = Printer(message)
    printer.printMessage()
}
