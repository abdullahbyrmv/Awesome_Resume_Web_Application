package Resume_Desktop_App.JDBC.dao;

import Resume_Desktop_App.JDBC.entity.Country;

import java.util.List;

public interface CountryInterface {
    public List<Country> getCountryById(int id);

    public List<Country> getAllCountries();
}
