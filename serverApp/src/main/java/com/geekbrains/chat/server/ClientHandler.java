package com.geekbrains.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.server = server;

        new Thread(() -> {
            try {
                while (true) {
                    String msg = in.readUTF();
                    if(msg.startsWith("/")){
                        executeCommand(msg);
                        continue;
                    }
                    server.broadcastMessage(username + ": " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    private void disconnect() {
        server.unsubscribe(this);
        if(in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            disconnect();
        }
    }

    public String getUsername() {
        return username;
    }

    private void executeCommand(String cmd) throws IOException {
        if(cmd.startsWith("/w ")){
            String[] tokens = cmd.split("\\s", 3);
            server.privateMessage(this, tokens[1], tokens[2]);
            return;
        }

        if(cmd.startsWith("/login ")) {
            String usernameFromLogin = cmd.split("\\s")[1];

            if(server.isNickBusy(usernameFromLogin)) {
                sendMessage("/login_failed Логин уже занят!");
            }

            if (username == null){
                username = usernameFromLogin;
                sendMessage("/login_ok " + username);
                server.subscribe(this);
            }

        }

        if(cmd.startsWith("/exit")){
            disconnect();
        }

        if(cmd.startsWith("/who_am_i")){
            sendMessage("Ваш логин: " + username);
        }

    }
}
