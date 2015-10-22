package es.upm.miw.voting.web.presentation.views;

import es.upm.miw.voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.print("Temas: ");
        if (model.get("votingThemes") != null) {
            System.out.println(model.get("votingThemes"));
        } else {
            System.out.println("[]");
        }
    }
}
