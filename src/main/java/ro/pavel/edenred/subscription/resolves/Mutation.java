package ro.pavel.edenred.subscription.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.pavel.edenred.subscription.pojo.MessageDto;
import ro.pavel.edenred.subscription.service.MessageService;


@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {


    MessageService service;

    public MessageDto add(String message) {
        return service.add(message);
    }
}
