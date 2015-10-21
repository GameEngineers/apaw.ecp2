package es.upm.miw.voting.rest.business.views;

import java.util.Map;

public class VotingThemesResponse {

    Map<String, Integer> votingThemes;

    public Map<String, Integer> getThemes() {
        return votingThemes;
    }

    public void setThemes(Map<String, Integer> themes) {
        this.votingThemes = themes;
    }
 
}
