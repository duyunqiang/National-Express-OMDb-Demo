package cov.pow.mjp.ff.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * This only supports conversion of text if it's really json, but declares itself as text/html instead of application/json.
 * @author Mat
 */
public class TextHtmlToJsonMessageConverter extends MappingJackson2HttpMessageConverter {
	
	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Collections.singletonList(MediaType.TEXT_HTML);
	}
	
}
