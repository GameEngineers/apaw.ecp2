package es.upm.miw.voting.rest.business.views;

import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;

public class ThemesResponse {

    private List<Theme> themes;

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
    
    
}
