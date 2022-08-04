package com.examples.abbasdgr8.repositories;

import com.examples.abbasdgr8.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abbas Attarwala <abbas@muon-c.com>
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> { }