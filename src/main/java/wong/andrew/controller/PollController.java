package wong.andrew.controller;

import org.springframework.web.bind.annotation.RestController;
import wong.andrew.repository.PollRepository;

import javax.inject.Inject;

/**
 * Created by andrewwong on 6/20/17.
 */
@RestController
public class PollController {

    @Inject
    private PollRepository pollRepository;

}
