package es.up.miw.voting.web.presentation.presenters;

import java.util.List;

import es.upm.miw.voting.rest.business.controllers.VotingThemesBO;
import es.upm.miw.voting.rest.business.views.ThemeDto;
import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("action", "ThemeManagerPresenter:process");
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        model.put("action", "ThemeManagerPresenter:voteTheme");
        ThemeDto dto = new ThemeDto();
        dto.setTheme(model.get("themeName").toString());
        new VotingThemesBO().addTheme(dto);
        List<ThemeDto> themes = new VotingThemesBO().getThemes();
        model.put("themes", themes);
        return "ThemeManagerView";
    }
    
}
