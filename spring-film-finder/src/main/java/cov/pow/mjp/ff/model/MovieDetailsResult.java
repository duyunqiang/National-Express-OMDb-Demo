package cov.pow.mjp.ff.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Jackson is case-sensitive. 
	 * It would be good to extend it to be insensitive.
	 * Or else to automatically generate the .java file given the json. */

	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private String year;
	@JsonProperty("Rated")
	private String rated;
	@JsonProperty("Released")
	private String released;
	@JsonProperty("Runtime")
	private String runtime;
	@JsonProperty("Genre")
	private String genre;
	@JsonProperty("Director")
	private String director;
	@JsonProperty("Writer")
	private String writer;
	@JsonProperty("Actors")
	private String actors;
	@JsonProperty("Plot")
	private String plot;
	@JsonProperty("Language")
	private String language;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("Awards")
	private String awards;
	@JsonProperty("Poster")
	private String poster;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Response")
	private String response;	// false indicates an error - no result

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getRated() {
		return rated;
	}

	public String getReleased() {
		return released;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public String getPoster() {
		return poster;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public String getType() {
		return type;
	}

	public String getResponse() {
		return response;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	public String getAwards() {
		return awards;
	}

	@Override
	public String toString() {
		return "MovieResult [Title=" + title + ", Year=" + year + ", Rated=" + rated
				+ ", Released=" + released + ", runtime=" + runtime
				+ ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot
				+ ", poster=" + poster + ", imdbRating=" + imdbRating
				+ ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + ", type="
				+ type + ", response=" + response + "]";
	}
}
