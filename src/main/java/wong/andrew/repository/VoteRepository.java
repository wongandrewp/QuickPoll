package wong.andrew.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wong.andrew.Vote;

/**
 * Created by andrewwong on 6/20/17.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {

    // wtf is this
    @Query(value = "select v.* from Option o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
            public Iterable<Vote> findByPoll(Long pollId);
}
