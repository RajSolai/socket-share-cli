package client

import java.net.Socket
import java.nio.file.Files
import java.io.DataOutputStream
import java.io.File
import java.lang.Exception
import java.util.*

class Client {
    init {
        try {
            val path: String
            val ip: String
            val inputscanner = Scanner(System.`in`)
            println("Enter the file path to Transfer:")
            path = inputscanner.nextLine()
            println("Enter the IP address of the Revicer")
            ip = inputscanner.nextLine()
            val soc = Socket(ip, 8080)
            println("READY TO SEND FILE")
            val filetoSend = File(path)
            val bytes = Files.readAllBytes(filetoSend.toPath())
            val dos = DataOutputStream(soc.getOutputStream())
            dos.writeInt(bytes.size)
            dos.write(bytes)
            println("File sent to successfully !.")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}