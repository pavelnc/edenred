package ro.pavel.edenred.subscription.websocket;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.pavel.edenred.subscription.pojo.MessageDto;
import ro.pavel.edenred.subscription.service.MessageService;

import java.util.List;


@AllArgsConstructor
@Controller
public class Websocket {
    private MessageService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto send(String message) {
        return messageService.add(message);
    }


    @GetMapping
    public ResponseEntity<List<MessageDto>> getMessages() {
        return new ResponseEntity<>(messageService.getAll(), HttpStatus.OK);
    }

}
