package com.geekbrains.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        if (!SQLHandler.connect()) {
            throw new RuntimeException("Не удалось подключиться к БД");
        }
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port + "...");
            while (true) {
                System.out.println("Ждём нового клиента...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            SQLHandler.disconnect();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastMessage(clientHandler.getUsername() + " подключился.");
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage(clientHandler.getUsername() + " отключился.");
        broadcastClientList();
    }

    public void broadcastMessage(String message){
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message + '\n');
        }
    }

    public void privateMessage(ClientHandler sender, String receiverUsername, String message){
        for(ClientHandler client : clients){
            if(client.getUsername().equals(receiverUsername)){
                client.sendMessage("От: " + sender.getUsername() + " Сообщение: " + message + '\n');
                sender.sendMessage("Кому: " + receiverUsername + " Сообщение: " + message + '\n');
                return;
            }
        }
        sender.sendMessage("Пользователь не найден!!!");

    }

    public boolean isNickBusy(String nickname) {
        for (ClientHandler clientHandler : clients) {
            if(clientHandler.getUsername().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
    public void broadcastClientList(){
        StringBuilder stringBuilder = new StringBuilder("/clients_list ");
        for (ClientHandler client : clients){
            stringBuilder.append(client.getUsername()).append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String clientList = stringBuilder.toString();
        for (ClientHandler clientHandler : clients){
            clientHandler.sendMessage(clientList);
        }
    }

    public String getNicknameByLoginAndPassword(String login, String password) {
        return SQLHandler.getNicknameByLoginAndPassword(login, password);
    }

    public boolean changeNick(String oldNickname, String newNickname) {
        return SQLHandler.changeNick(oldNickname, newNickname);
    }

    public boolean registration(String login, String password, String nickname) {
        return SQLHandler.registration(login, password, nickname);
    }



}
