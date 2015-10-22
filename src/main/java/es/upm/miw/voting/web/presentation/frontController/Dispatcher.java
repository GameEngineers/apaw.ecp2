package es.upm.miw.voting.web.presentation.frontController;

import es.up.miw.voting.web.presentation.presenters.ErrorPresenter;
import es.up.miw.voting.web.presentation.presenters.ThemeManagerPresenter;
import es.up.miw.voting.web.presentation.presenters.VotingPresenter;
import es.upm.miw.voting.web.http.HttpRequest;
import es.upm.miw.voting.web.http.HttpResponse;
import es.upm.miw.voting.web.presentation.models.Model;
import es.upm.miw.voting.web.presentation.views.ErrorView;
import es.upm.miw.voting.web.presentation.views.ThemeManagerView;
import es.upm.miw.voting.web.presentation.views.View;
import es.upm.miw.voting.web.presentation.views.VotingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            nextView = themeManagerPresenter.process(model);
            break;
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            nextView = votingPresenter.process(model);
            break;
        case "ErrorPresenter":
            ErrorPresenter errorPresenter = new ErrorPresenter();
            nextView = errorPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.createTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = votingPresenter.voteTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        case "VotingView":
            view = new VotingView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }
}
