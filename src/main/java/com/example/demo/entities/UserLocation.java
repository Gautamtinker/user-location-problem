package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UserLocation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private Double latitude;
	 private Double longitude;
	 private boolean excluded;

	     public Long getId() {
	         return id;
	     }

	     public void setId(Long id) {
	         this.id = id;
	     }

	     public String getName() {
	         return name;
	     }

	     public void setName(String name) {
	         this.name = name;
	     }

	     public Double getLatitude() {
	         return latitude;
	     }

	     public void setLatitude(Double latitude) {
	         this.latitude = latitude;
	     }

	     public Double getLongitude() {
	         return longitude;
	     }

	     public void setLongitude(Double longitude) {
	         this.longitude = longitude;
	     }

	     public boolean isExcluded() {
	         return excluded;
	     }

	     public void setExcluded(boolean excluded) {
	         this.excluded = excluded;
	     }
	 }

