package ro.pavel.edenred.subscription.resolves;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.pavel.edenred.subscription.pojo.MessageDto;
import ro.pavel.edenred.subscription.service.MessageService;

import java.util.List;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {


    MessageService messageService;

    public MessageDto addMessage() {
        return messageService.add("hello");
    }

    public List<MessageDto> allData() {
        return messageService.getAll();
    }
}
