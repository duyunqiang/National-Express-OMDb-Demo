package cov.pow.mjp.ff.service;

import java.util.List;

import cov.pow.mjp.ff.model.FilmSearchTerms;
import cov.pow.mjp.ff.model.MovieDetailsResult;
import cov.pow.mjp.ff.model.MovieSearchResult;

public interface MovieDbService {

	MovieDetailsResult get(String imdbId);

	List<MovieSearchResult> search(FilmSearchTerms filmSearchTerms);

}
