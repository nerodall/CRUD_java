package ru.gb.my_first_crud.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateWay {
    void writeFile(@Header(FileHeaders.FILENAME) String fileName, String content);
}
