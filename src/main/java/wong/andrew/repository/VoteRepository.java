package wong.andrew.repository;

import org.springframework.data.repository.CrudRepository;
import wong.andrew.Vote;

/**
 * Created by andrewwong on 6/20/17.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {
}
