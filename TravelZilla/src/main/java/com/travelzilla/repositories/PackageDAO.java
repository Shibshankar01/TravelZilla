package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Packages;

@Repository
public interface PackageDAO extends JpaRepository<Packages, Integer> {

}
