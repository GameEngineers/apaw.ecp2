package es.upm.miw.voting.rest.business.views;

import java.util.Map;

public class VotingThemesResponse {

    Map<String, Integer> themes;

    public Map<String, Integer> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, Integer> themes) {
        this.themes = themes;
    }
 
}
