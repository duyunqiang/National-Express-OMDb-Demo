package cov.pow.mjp.ff.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cov.pow.mjp.ff.model.FilmSearchTerms;
import cov.pow.mjp.ff.model.MovieSearchResult;
import cov.pow.mjp.ff.service.MovieDbService;

@Controller
@RequestMapping({"/", "/find-a-film"})
public class FindAFilmController {
	
	private static final Logger logger = LoggerFactory.getLogger(FindAFilmController.class);
	
	private DeviceDiscoverer deviceDiscoverer = new DeviceDiscoverer();
	
	@Autowired
	private MovieDbService movieDbService;
	
	@RequestMapping(value={""}, method=RequestMethod.GET)
	public String diplayForm(Model model, Device device) {
		logger.info("Launch page");
		
		deviceDiscoverer.informModel(model, device);
		
		model.addAttribute("filmSearchTerms", new FilmSearchTerms());
		model.addAttribute("filmTypes", getFilmTypes());
		return "find-a-film";
	}
	
	private LinkedHashMap<String, String> getFilmTypes() {
		// TODO: language pack these strings
		LinkedHashMap<String, String> options = new LinkedHashMap<>();
		options.put(null, "       ");
		options.put("movie", "movie  ");
		options.put("series", "series ");
		options.put("episode", "episode");
		return options;
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public String search(@Valid FilmSearchTerms filmSearchTerms, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		logger.info("User searching for {}", filmSearchTerms);

		if (bindingResult.hasErrors()) {
			logger.info("{} errors on form", bindingResult.getErrorCount());
			model.addAttribute("filmTypes", getFilmTypes());
			return "find-a-film";
		}
		
		List<MovieSearchResult> searchResults = movieDbService.search(filmSearchTerms);
		
		/* TODO: This doesn't work.		 
		if (searchResults.isEmpty()) {
			//TODO: Add a field to report that no films were found - try again with different search terms.
			logger.info("No results");
			model.addAttribute("filmTypes", getFilmTypes());
			redirectAttributes.addFlashAttribute("zeroResults", true);
			return "redirect:/find-a-film";
		}
		*/
		
		if (searchResults.size() == 1) {
			MovieSearchResult movieResult = searchResults.get(0);
			redirectAttributes.addFlashAttribute("searchResult", movieResult);
			return "redirect:/found-film/" + movieResult.getImdbID();
		}
		
		redirectAttributes.addFlashAttribute("searchResults", searchResults);
		return "redirect:/found-films";
	}
	
}
