package ro.pavel.edenred.subscription.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.pavel.edenred.subscription.entity.Message;
import ro.pavel.edenred.subscription.pojo.MessageDto;
import ro.pavel.edenred.subscription.repository.MessageRepo;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    public static final String TEXT = "text";
    @Mock
    private MessageRepo messageRepo;

    @InjectMocks
    private MessageService messageService;

    @Test
    public void getAll() {
        Message message = new Message();
        message.setText(TEXT);
        when(messageRepo.findAll()).thenReturn(Collections.singletonList(message));

        List<MessageDto> messageDtos = messageService.getAll();

        MessageDto messageDto=new MessageDto();
        messageDto.setText(TEXT);

        assertEquals(Collections.singletonList(messageDto), messageDtos);

    }

    @Test
    public void add() {
        MessageDto messageDto = messageService.add(TEXT);

        Message message=new Message();
        message.setText(TEXT);
        MessageDto messageDto2=new MessageDto();
        messageDto2.setText(TEXT);

        verify(messageRepo, times(1)).save(message);
        assertEquals(messageDto2, messageDto);
    }
}