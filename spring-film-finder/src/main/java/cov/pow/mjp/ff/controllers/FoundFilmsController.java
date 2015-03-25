package cov.pow.mjp.ff.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cov.pow.mjp.ff.model.MovieSearchResult;

@Controller
@RequestMapping({"/found-films", "/list-films"})
public class FoundFilmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(FoundFilmsController.class);
	
	private DeviceDiscoverer deviceDiscoverer = new DeviceDiscoverer();

	@RequestMapping({""})
	public String displayListOfFilms(Model model, Device device) {
		deviceDiscoverer.informModel(model, device);
		
		List<MovieSearchResult> searchResults = (List<MovieSearchResult>) model.asMap().get("searchResults");
		if (searchResults == null) {
			return "redirect:find-a-film";
		}
		
		int filmCount = searchResults.size();
		model.addAttribute("filmCount", filmCount);
		logger.info("Found {} films {}", filmCount, searchResults);
		return "found-films";
	}
	
}
