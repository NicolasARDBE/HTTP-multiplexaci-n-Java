package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttp1Server {

    private static int requestCount = 0; // Variable para contar las solicitudes

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/test", new MyHandler());
        server.start();
        System.out.println("Servidor iniciado en el puerto 8080");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            synchronized (SimpleHttp1Server.class) {
                requestCount++;
                System.out.println("Número de solicitudes: " + requestCount);
            }
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();  // Asegúrate de cerrar el OutputStream
        }
    }

}
