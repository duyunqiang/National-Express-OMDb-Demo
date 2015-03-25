package cov.pow.mjp.ff.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class FilmSearchTerms implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Length(max=100, message="You don't need to enter the full title. 100 characters is enough.")
	@NotBlank(message="You don't need to enter the full title, but you need to type some words.")
	private String title;
	
	private String type;
	
	@Range(min=1850, max=2050, message="The year should be between 1850 and 2050.")
	private Integer year;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String toQueryString() {
		return "s=" + title.replaceAll(" ", "+")
				+ (type == null || type.isEmpty() ? "" : "&type=" + type)
				+ (year == null ? "" : "&year=" + year);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		FilmSearchTerms other = (FilmSearchTerms) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		return "FilmSearchTerms [title=" + title + ", type=" + type + ", year="
				+ year + "]";
	}
	
}
