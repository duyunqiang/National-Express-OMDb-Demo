package cov.pow.mjp.ff.rest;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * omdbapi.com returns json, but declares it as text in the Content-Type header. So we need to extend Spring's RestTemplate.
 * This additionally supports conversion of text if it's really json, but declares itself as text/html instead of application/json. 
 * @author Mat
 */
public class TextHtmlAcceptingRestTemplate extends RestTemplate {

	public TextHtmlAcceptingRestTemplate() {
		// Also deal with gzipped responses.
		super(createGzipRequestFactory());
		List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
		messageConverters.add(new TextHtmlToJsonMessageConverter());
		setMessageConverters(messageConverters);
	}

	private static ClientHttpRequestFactory createGzipRequestFactory() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return requestFactory;
	}

}
