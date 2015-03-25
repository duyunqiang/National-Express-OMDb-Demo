package cov.pow.mjp.ff.controllers;

import org.springframework.mobile.device.Device;
import org.springframework.ui.Model;

public class DeviceDiscoverer {

	/**
	 * Add an {@code isSmallScreenDevice} attribute to the model, which is {@code true} is the device is a mobile or a table.
	 * TODO: This should be aspect-driven advice.
	 * @param model
	 * @param device
	 */
	public void informModel(Model model, Device device) {
		model.addAttribute("isSmallScreenDevice", device.isMobile() || device.isTablet());
//		model.addAttribute("isSmallScreenDevice", true);	// uncomment for easy testing on a desktop
	}
}
