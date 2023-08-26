package com.example.demo.services;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.*;

import com.example.demo.repository.*;
@Service
public class UserLocationService {
	    @Autowired
	    private UserLocationRepository userLocationRepository;

	    public UserLocation createUserLocation(UserLocation userLocation) {
	        return userLocationRepository.save(userLocation);
	    }

	    public UserLocation updateUserLocation(Long id, UserLocation updatedUserLocation) {
	        UserLocation existingUserLocation = userLocationRepository.findById(id)
	                .orElseThrow();

	  
	        existingUserLocation.setName(updatedUserLocation.getName());
	        existingUserLocation.setLatitude(updatedUserLocation.getLatitude());
	        existingUserLocation.setLongitude(updatedUserLocation.getLongitude());
	        existingUserLocation.setExcluded(updatedUserLocation.isExcluded());

	        return userLocationRepository.save(existingUserLocation);
	    }

		public List<UserLocation> getNearestUsers(int n) {
			 List<UserLocation> allUsers = userLocationRepository.findAllByExcludedFalse();

		        // Sorting the users by their distance from (0,0)
		        Collections.sort(allUsers, Comparator.comparingDouble(userLocation ->
		            calculateDistance(userLocation.getLatitude(), userLocation.getLongitude(), 0.0, 0.0)
		        ));

		        // Returning the first 'n' nearest users
		        return allUsers.stream()
		                .limit(n)
		                .collect(Collectors.toList());
		}
		
		public List<UserLocation> getallusers(){
			List<UserLocation> allUsers = userLocationRepository.findAllByExcludedFalse();
			return allUsers.stream().collect(Collectors.toList());
		}
		
		 private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		        double dLat = Math.toRadians(lat2 - lat1);
		        double dLon = Math.toRadians(lon2 - lon1);
		        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
		                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
		                Math.sin(dLon / 2) * Math.sin(dLon / 2);
		        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		        return 6371000 * c; // Radius of the Earth in meters
		    }
		
	}

