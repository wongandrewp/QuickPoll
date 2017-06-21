package wong.andrew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        poll = pollRepo.save(poll);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();

        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }

}
