package fr.isika.cda.projet3.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Location;
import fr.isika.cda.projet3.service.location.ILocationService;

@ManagedBean
public class LocationController {

	@Inject
	private ILocationService locationService;
	
	private Location location = new Location();
	
	private List<Location> locations;
	
	public void testLocation() {
		System.out.println(locations.size());
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public List<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
