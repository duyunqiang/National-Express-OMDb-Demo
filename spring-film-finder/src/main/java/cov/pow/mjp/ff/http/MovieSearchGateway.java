package cov.pow.mjp.ff.http;

import cov.pow.mjp.ff.model.MovieDetailsResult;
import cov.pow.mjp.ff.model.MovieResultList;

public interface MovieSearchGateway {
	
	MovieDetailsResult getMovieDetails(String imdbId);
		
	MovieResultList searchForMovies(String searchTerms);
}
