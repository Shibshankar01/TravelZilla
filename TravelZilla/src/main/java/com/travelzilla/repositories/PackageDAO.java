package com.travelzilla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;

@Repository
public interface PackageDAO extends JpaRepository<Packages, Integer> {

	public List<Packages> findByRoute(Route r);

}
