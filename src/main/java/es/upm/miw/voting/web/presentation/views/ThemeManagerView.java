package es.upm.miw.voting.web.presentation.views;

import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeManagerView implements View {

    @Override
    public void show(Model model) {

        System.out.println("Theme Manager Page");
        System.out.print("Temas: ");
        if (model.get("themes") != null) {
            System.out.print(model.get("themes"));
        } else {
            System.out.print("[]");
        }

    }

}
