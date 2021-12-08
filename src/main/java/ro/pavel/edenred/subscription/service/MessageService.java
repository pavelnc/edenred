package ro.pavel.edenred.subscription.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.pavel.edenred.subscription.entity.Message;
import ro.pavel.edenred.subscription.pojo.MessageDto;
import ro.pavel.edenred.subscription.repository.MessageRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageService {



    private MessageRepo messageRepo;

    public List<MessageDto> getAll() {
        return messageRepo.findAll().stream().map(message -> {
            MessageDto messageDto = new MessageDto();
            messageDto.setText(message.getText());
            return messageDto;
        }).collect(Collectors.toList());

    }

    public MessageDto add(String message) {

        Message hello = new Message();
        hello.setText(message);

        messageRepo.save(hello);

        MessageDto messageDto = new MessageDto();
        messageDto.setText(message);
        return messageDto;
    }
}
