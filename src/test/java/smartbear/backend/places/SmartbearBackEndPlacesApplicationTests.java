package smartbear.backend.places;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import smartbear.backend.places.framework.V1;
import smartbear.backend.places.model.SearchPlaceJsonData;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartbearBackEndPlacesApplicationTests {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(this.ctx)
				.build();
	}

	/**
	 * Test TestLocationControllerOK with correct parameters
	 * @throws Exception
	 */
	@Test
	public void TestLocationControllerOK() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(
				get(V1.URI_RETRIEVE_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.param("lat", "59.332339")
						.param("lng", "18.064479"))
				.andExpect(request().asyncStarted())
				.andReturn();

		ResponseEntity<SearchPlaceJsonData> placesResponseEntity = (ResponseEntity<SearchPlaceJsonData>)mvcResult.getAsyncResult();
		SearchPlaceJsonData placesResponse = placesResponseEntity.getBody();

		assertEquals(placesResponse.getResults().size(), 20);
		assertEquals(placesResponse.getStatus(), HttpStatus.OK.name());
	}

	/**
	 * Test TestLocationControllerOK with correct parameters
	 * @throws Exception
	 */
	@Test
	public void TestLocationControllerBadRequest() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(
				get(V1.URI_RETRIEVE_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.param("lat", "59.332339"))
				.andExpect(request().asyncStarted())
				.andReturn();

		ResponseEntity<SearchPlaceJsonData> placesResponseEntity = (ResponseEntity<SearchPlaceJsonData>)mvcResult.getAsyncResult();
		SearchPlaceJsonData placesResponse = placesResponseEntity.getBody();

		assertEquals(placesResponse.getStatus(), HttpStatus.BAD_REQUEST.name());
		assertEquals(placesResponse.getMessage(),"Wrong parameters");
	}

}
