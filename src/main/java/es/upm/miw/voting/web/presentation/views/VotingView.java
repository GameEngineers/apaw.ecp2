package es.upm.miw.voting.web.presentation.views;

import es.upm.miw.voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.println("Temas: " + model.get("votingThemes"));
    }
}
