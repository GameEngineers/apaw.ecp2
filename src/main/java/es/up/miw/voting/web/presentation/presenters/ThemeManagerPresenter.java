package es.up.miw.voting.web.presentation.presenters;

import java.util.List;

import es.upm.miw.voting.rest.business.controllers.VotingThemesBO;
import es.upm.miw.voting.rest.business.views.ThemeDTO;
import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("action", "ThemeManagerPresenter:process");
        return "VotingView";
    }

    public String createVote(Model model) {
        model.put("action", "ThemeManagerPresenter:voteTheme");
        ThemeDTO dto = new ThemeDTO();
        dto.setTheme(model.get("themeName").toString());
        new VotingThemesBO().addTheme(dto);
        List<ThemeDTO> themes = new VotingThemesBO().getThemes();
        model.put("themes", themes);
        return "ThemeManagerView";
    }
    
}
