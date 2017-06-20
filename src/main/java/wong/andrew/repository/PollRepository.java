package wong.andrew.repository;

import org.springframework.data.repository.CrudRepository;
import wong.andrew.Poll;

/**
 * Created by andrewwong on 6/20/17.
 */
public interface PollRepository extends CrudRepository<Poll, Long> {
}
