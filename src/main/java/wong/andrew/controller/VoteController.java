package wong.andrew.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wong.andrew.Vote;
import wong.andrew.repository.VoteRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewwong on 6/21/17.
 */
@RestController
public class VoteController {

    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);

        // Set headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.GET)
    public ResponseEntity<List<Vote>> getAllVotes(@PathVariable Long pollId) {
        List<Vote> votes = new ArrayList<>();
        voteRepository.findByPoll(pollId).forEach(votes::add);
        return new ResponseEntity<List<Vote>>(votes, HttpStatus.OK);
    }
}
