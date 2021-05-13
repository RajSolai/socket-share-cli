import client.Client
import server.Server

fun main(args: Array<String>) {
    when (args[0]) {
       "-r" -> Server()
       "-s" -> Client()
       else -> println("-r for Recive / -s to Send")
   }
}
