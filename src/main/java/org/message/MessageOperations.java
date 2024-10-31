package org.message;

import java.util.List;

public interface MessageOperations {
    void sendMessage(Message message);
    Message readMessage(int messageId);
    List<Message> getListMessage();

}
