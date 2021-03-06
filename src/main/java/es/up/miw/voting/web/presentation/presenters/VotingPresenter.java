package es.up.miw.voting.web.presentation.presenters;

import es.upm.miw.voting.rest.business.controllers.VotingThemesBO;
import es.upm.miw.voting.rest.business.views.VotingThemeDto;
import es.upm.miw.voting.web.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model){
        model.put("action", "VotingPresenter:process");
        model.put("votingThemes", new VotingThemesBO().getVotingThemes());
        return "VotingView";
    }
    
    public String voteTheme(Model model){
        model.put("action", "VotingPresenter:voteTheme");
        VotingThemeDto dto = new VotingThemeDto();
        dto.setTheme(model.get("themeName").toString());
        dto.setVote(Integer.parseInt(model.get("value").toString()));
        new VotingThemesBO().addVote(dto);
        model.put("votingThemes", new VotingThemesBO().getVotingThemes());
        return "VotingView";
    }
}
