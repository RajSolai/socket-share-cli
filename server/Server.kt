package server

import java.net.DatagramSocket
import java.net.InetAddress
import java.time.format.DateTimeFormatter
import java.net.ServerSocket
import java.io.DataInputStream
import java.time.LocalDateTime
import java.io.FileOutputStream
import java.lang.Exception

class Server {
    private val ipAddress :String get() {
            var str = "null"
            try {
                val pingsocket = DatagramSocket()
                pingsocket.connect(InetAddress.getByName("8.8.8.8"), 10002)
                str = pingsocket.localAddress.hostAddress
            } catch (e: Exception) {
                println(e.message)
            }
            return str
        }

    init {
        try {
            val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")
            println("Server Runs on PORT 8080")
            println("Server IP: $ipAddress")
            val server = ServerSocket(8080)
            val socket = server.accept()
            val dis = DataInputStream(socket.getInputStream())
            val len = dis.readInt()
            val data = ByteArray(len)
            dis.readFully(data)
            val filename = "socket-share" + dtf.format(LocalDateTime.now()) + ".dat"
            val fos = FileOutputStream(filename)
            fos.write(data)
            fos.close()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}