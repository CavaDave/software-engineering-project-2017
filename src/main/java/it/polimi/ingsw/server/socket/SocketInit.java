package it.polimi.ingsw.server.socket;

public class SocketInit implements Runnable {
    private static final int PORT = 6677;

    @Override
    public void run() {
        SocketServer socketServer = new SocketServer(PORT);
        socketServer.startServer();
    }
}