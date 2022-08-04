package com.examples.abbasdgr8.services;

import com.examples.abbasdgr8.repositories.CountryRepository;
import com.examples.abbasdgr8.models.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Abbas Attarwala <abbas@muon-c.com>
 */
@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;
    
    public List<Country> list() {
        return countryRepository.findAll();
    }
    
    public void saveCountry(long id, String name) {
        countryRepository.save(new Country(id, name));
    }
}
