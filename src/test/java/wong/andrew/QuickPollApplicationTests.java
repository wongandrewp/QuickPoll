package wong.andrew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wong.andrew.controller.PollController;
import wong.andrew.repository.PollRepository;

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
	public void testGetAllPolls() {

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
