1. 编译服务端：`mvn clean package -Dmaven.test.skip=true`，
2. 运行 `java -jar netty-3.7.0.Final.jar` 会运行一个在端口：`8089`的tcp服务端。
3. 编译一个简单客户端： `javac Client.java && jar cvfe client.jar Client Client.class`
4. 连接到服务端： `java -jar client.jar 192.168.56.104 8089`
5. 观察服务器，`netstat -npta`, 出现大量 `CLOSE_WAIT`
6. `src/main/java/org/jboss/netty/channel/socket/nio/NioServerBoss.java` 类做了修改

