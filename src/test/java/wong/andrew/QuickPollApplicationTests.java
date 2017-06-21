package wong.andrew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wong.andrew.controller.PollController;
import wong.andrew.repository.PollRepository;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PollConfig.class)
public class QuickPollApplicationTests {

	@InjectMocks
	private PollController pollController;

	@Mock
	private PollRepository pollRepository;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllPollsOK() {
		String expectedQuestion = "Do you like peanut butter?";
		Option questionOptionOne = new Option("Y");
		Option questionOptionTwo = new Option("N");
		Set<Option> options = new HashSet<>(Arrays.asList(questionOptionOne, questionOptionTwo));
		Poll poll = new Poll(expectedQuestion, options);
		List<Poll> expectedList = new ArrayList<>();
		poll.setId(1);
		expectedList.add(poll);
		HttpStatus expectedStatus = HttpStatus.OK;

		when(pollRepository.findAll()).thenReturn(expectedList);
		List<Poll> actualList = pollController.getAllPolls().getBody();
		HttpStatus actualStatus = pollController.getAllPolls().getStatusCode();

		assertTrue("Poll contains expected question", actualList.contains(poll));
		assertEquals("Expect HTTP status returned", expectedStatus, actualStatus);
	}

	@Test
	public void testGetAllPollsServerError(){
		HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		List<Poll> expectedList = new ArrayList<>();
		expectedList.add(null);

		when(pollRepository.findAll()).thenReturn(expectedList);
		List<Poll> actualList = pollController.getAllPolls().getBody();
		HttpStatus actualStatus = pollController.getAllPolls().getStatusCode();

		assertNull("Poll contains expected question", actualList.get(0));
		assertEquals("Expect HTTP status returned", expectedStatus, actualStatus);
	}

	@Test
	public void testGetPollById() {

	}

	@Test
	public void testPostPoll(){

	}

	@Test
	public void testPutPollReturns400Status() {

	}

	@Test
	public void testDeletePollReturns400Status() {

	}

}
