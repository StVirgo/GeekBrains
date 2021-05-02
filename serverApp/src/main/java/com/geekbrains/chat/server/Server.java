package com.geekbrains.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
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
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastMessage(clientHandler.getUsername() + " подключился. \n");
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage(clientHandler.getUsername() + " отключился. \n");
        broadcastClientList();
    }

    public void broadcastMessage(String message){
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public void privateMessage(ClientHandler sender, String receiverUsername, String message){
        for(ClientHandler client : clients){
            if(client.getUsername().equals(receiverUsername)){
                client.sendMessage("От: " + sender.getUsername() + " Сообщение: " + message);
                sender.sendMessage("Кому: " + receiverUsername + " Сообщение: " + message);
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
    private void broadcastClientList(){
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


}
