package it.polimi.ingsw.shared.requests.serverclient;

import it.polimi.ingsw.client.middleware.ClientReceiver;

import java.io.Serializable;

@FunctionalInterface
public interface ServerClientRequest extends Serializable {
    void acceptServerClientRequestVisitor(ClientReceiver clientReceiver);
}
