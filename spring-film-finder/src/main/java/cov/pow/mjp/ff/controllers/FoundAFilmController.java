package cov.pow.mjp.ff.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cov.pow.mjp.ff.model.MovieDetailsResult;
import cov.pow.mjp.ff.service.MovieDbService;

@Controller
@RequestMapping({"/found-film", "/film-details"})
public class FoundAFilmController {
	
	private static final Logger logger = LoggerFactory.getLogger(FoundAFilmController.class);
	
	@Autowired
	private MovieDbService movieDbService;
	
	private DeviceDiscoverer deviceDiscoverer = new DeviceDiscoverer();
	
	@RequestMapping({"{imdbId}"})
	public String foundAFilm(@PathVariable String imdbId, Model model, Device device) {
		if (imdbId == null) {
			logger.warn("How did we arrive here with a null imdb ID?");
			return "redirect:find-a-film";
		}

		logger.info("Found a film " + imdbId);
		MovieDetailsResult movieDetails = movieDbService.get(imdbId);
		logger.info("Found film details" + movieDetails);
		model.addAttribute("movie", movieDetails);
		
		deviceDiscoverer.informModel(model, device);
		
		return "found-film";
	}
	
}
