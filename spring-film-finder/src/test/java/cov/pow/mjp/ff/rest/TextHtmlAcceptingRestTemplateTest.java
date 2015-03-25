package cov.pow.mjp.ff.rest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import cov.pow.mjp.ff.model.MovieDetailsResult;

public class TextHtmlAcceptingRestTemplateTest {
	
	private static RestTemplate restTemplate;
	private static MovieDetailsResult movie;
	
	@BeforeClass
	public static void setUp() throws Exception {
        restTemplate = new TextHtmlAcceptingRestTemplate();
        movie = restTemplate.getForObject("http://www.omdbapi.com/?t=The Godfather", MovieDetailsResult.class);
	}

	@Test
	public void title_should_be_the_godfather() {
		assertEquals("The title should be 'The Godfather'", "The Godfather", movie.getTitle());
	}

	@Test
	public void year_should_be_1972() {
		assertEquals("The year should be 1972", "1972", movie.getYear());
	}

	@Test
	public void imdbRating_should_be_9_2() {
		assertEquals("The imdb rating should be 9.2", "9.2", movie.getImdbRating());
	}

	//todo: write tests for the rest of the fields
}
