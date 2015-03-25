package cov.pow.mjp.ff.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Jackson is case-sensitive. 
	 * It would be good to extend it to be insensitive.
	 * Or else to automatically generate the .java file given the json. */

	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private String year;
	private String imdbID;
	@JsonProperty("Response")
	private String response;	// false indicates an error - no result
	
	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public String getResponse() {
		return response;
	}
	
	@JsonIgnore
	public boolean isEmpty() {
		return Boolean.toString(false).equals(response); 
	}

	@Override
	public int hashCode() {
		if (imdbID == null) {
			return 0;
		}
		if (imdbID.startsWith("tt")) {
			String number = imdbID.substring(2);
			try {
				return Integer.parseInt(number);
			} catch (NumberFormatException e) {
				// fall through
			}
		}
		return imdbID.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieSearchResult other = (MovieSearchResult) obj;
		if (imdbID == null) {
			if (other.imdbID != null)
				return false;
		} else if (!imdbID.equals(other.imdbID))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieSearchResult [title=" + title + ", year=" + year
				+ ", imdbID=" + imdbID + ", response=" + response + "]";
	}
}
