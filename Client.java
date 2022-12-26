import java.net.*;
import java.io.*;
import java.util.*;
// 编译： javac Client.java && jar cvfe client.jar Client Client.class
// 连接到服务端： java -jar client.jar 192.168.56.104 8089
class Client {

    public static void main(String[] args) {
        // args[0] = host, args[1]=port
        System.out.println(Arrays.toString(args));
        for (int i = 0; i < 200; i++) {
            try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]))) {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String msg = "data" + i;
                System.out.printf("Send Msg --> %s \n", msg);
                out.write(msg);
                out.flush(); // 立即发送，否则需要积累到一定大小才一次性发送

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
