package wong.andrew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wong.andrew.Poll;
import wong.andrew.repository.PollRepository;

import javax.inject.Inject;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewwong on 6/20/17.
 */
@RestController
public class PollController {

    @Inject
    private PollRepository pollRepo;

    //TODO: Handle cases where there are no polls or internal server error
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Poll>> getAllPolls(){
        ArrayList<Poll> pollList = new ArrayList<>();
        pollRepo.findAll().forEach(pollList::add);
        return new ResponseEntity<>(pollList, HttpStatus.OK);
    }

    @RequestMapping(value = "/polls", method = RequestMethod.POST)
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepo.save(poll);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        Poll p = pollRepo.findOne(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    //TODO: find poll with pollId, use poll's instance variables to update poll with that id
    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        pollRepo.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollRepo.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
