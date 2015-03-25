package cov.pow.mjp.ff.controllers;

import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cov.pow.mjp.ff.model.FilmSearchTerms;

@Ignore("Need to figure out how to pass in a mock Device")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-servlet-context.xml")
public class FindAFilmControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(FindAFilmControllerTest.class);
	private static final String[] BASE_REQUEST_MAPPINGS = {"/", "/find-a-film"};
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void diplayForm_should_set_up_the_model() throws Exception {
		for (String url : BASE_REQUEST_MAPPINGS) {
		    logger.info("Testing url {}", url);
			this.mockMvc.perform(get(url))
		        .andExpect(status().isOk())
		        .andExpect(model().attributeExists("filmSearchTerms", "filmTypes"))
		        .andExpect(model().attribute("filmSearchTerms", isA(FilmSearchTerms.class)))
		        .andExpect(model().attribute("filmTypes", isA(LinkedHashMap.class)))
		        .andExpect(view().name("find-a-film"))
		        .andExpect(forwardedUrl("/WEB-INF/views/find-a-film.jsp"));
		}
	}

}
