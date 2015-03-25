package cov.pow.mjp.ff.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cov.pow.mjp.ff.http.MovieSearchGateway;
import cov.pow.mjp.ff.model.FilmSearchTerms;
import cov.pow.mjp.ff.model.MovieDetailsResult;
import cov.pow.mjp.ff.model.MovieResultList;
import cov.pow.mjp.ff.model.MovieSearchResult;

@Service
public class MovieDbServiceImpl implements MovieDbService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieDbService.class);
	
	@Autowired
	private MovieSearchGateway movieSearchGateway;

	@Override
    @Cacheable("movieDetails")
	public MovieDetailsResult get(String imdbId) {
		logger.info("Outgoing request for {}", imdbId);
		MovieDetailsResult reply = movieSearchGateway.getMovieDetails(imdbId);  
		logger.info("Replied with: {}", reply);
		return reply;
	}

	@Override
    @Cacheable("moviesSearchResults")
	public List<MovieSearchResult> search(FilmSearchTerms filmSearchTerms) {
		String searchTerms = filmSearchTerms.toQueryString();
		logger.info("Outgoing request for {}", searchTerms);
		MovieResultList movieResultList = movieSearchGateway.searchForMovies(searchTerms);
		List<MovieSearchResult> results = movieResultList.getResultsAsList();  
		logger.info("Replied with: {}", results);
		return results;
	}
}
