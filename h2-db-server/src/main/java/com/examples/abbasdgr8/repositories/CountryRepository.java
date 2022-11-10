package com.examples.abbasdgr8.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.abbasdgr8.models.Country;


/**
 * @author Abbas Attarwala <abbas@muon-c.com>
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> { }