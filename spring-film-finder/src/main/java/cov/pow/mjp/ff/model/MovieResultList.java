package cov.pow.mjp.ff.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResultList {

	
	@JsonProperty("Search")
	private MovieSearchResult[] results;

	public MovieSearchResult[] getResults() {
		return results;
	}
	
	@JsonIgnore
	public List<MovieSearchResult> getResultsAsList() {
		if (results == null) {
			return Collections.emptyList();
		}
		return Arrays.asList(results);
	}

	public void setResults(MovieSearchResult[] results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(results);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieResultList other = (MovieResultList) obj;
		if (!Arrays.equals(results, other.results))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieResultList " + results;
	}
	
}
