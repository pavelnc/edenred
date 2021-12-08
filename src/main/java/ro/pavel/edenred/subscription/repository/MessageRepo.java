package ro.pavel.edenred.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.pavel.edenred.subscription.entity.Message;


@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {


}
