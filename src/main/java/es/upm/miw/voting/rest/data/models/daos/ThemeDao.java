package es.upm.miw.voting.rest.data.models.daos;

import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;

public interface ThemeDao extends GenericDao<Theme, Integer> {

    public Theme findByName(String themeName);
    public List<String> findAllNames();
    
}
