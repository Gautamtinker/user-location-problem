package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserLocation;
@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
	  List<UserLocation> findAllByExcludedFalse();
}
