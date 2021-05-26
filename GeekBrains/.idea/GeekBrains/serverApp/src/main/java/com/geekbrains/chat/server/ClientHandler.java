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
    private String login;

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

        if (cmd.startsWith("/chnick ")) {
            String[] token = cmd.split("\\s+", 2);

            if (token[1].contains(" ")) {
                sendMessage("Ник не может содержать пробелов" + '\n');
            }
            if (server.changeNick(this.username, token[1])) {
                sendMessage("/yourNickIs " + token[1]);
                sendMessage("Ваш ник изменен на " + token[1] + '\n');
                this.username = token[1];
                server.broadcastClientList();
            } else {
                sendMessage("Не удалось изменить ник. Ник " + token[1] + " уже существует" + '\n');
            }
        }

        if(cmd.startsWith("/login ")) {
            String[] token = cmd.split("\\s", 3);
            String newNick = server.getNicknameByLoginAndPassword(token[1], token[2]);
            login = token[1];

            if (newNick != null) {
                if (!server.isNickBusy(login)) {
                    username = newNick;
                    sendMessage("/login_ok " + username);
                    server.subscribe(this);
                } else {
                    sendMessage("Данная учетная запись уже используется" + '\n');
                }
            } else {
                sendMessage("Неверный логин / пароль" + '\n');
            }
        }
        if (cmd.startsWith("/reg ")) {
            String[] token = cmd.split("\\s", 4);
            boolean regSuccess = server.registration(token[1], token[2], token[3]);
            if (regSuccess) {
                sendMessage("/regok");
            } else {
                sendMessage("/regno");
            }
        }





        if(cmd.startsWith("/exit")){
            disconnect();
        }

        if(cmd.startsWith("/who_am_i")){
            sendMessage("Ваш логин: " + username + '\n');
        }

    }
}
