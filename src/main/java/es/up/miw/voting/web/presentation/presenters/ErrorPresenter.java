package es.up.miw.voting.web.presentation.presenters;

import es.upm.miw.voting.web.presentation.models.Model;

public class ErrorPresenter {

    public String process(Model model) {
        model.put("action", "ErrorPresenter:process");
        return "VotingView";
    }
}
