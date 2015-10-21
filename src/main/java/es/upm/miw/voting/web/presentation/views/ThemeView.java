package es.upm.miw.voting.web.presentation.views;

import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeView implements View {

    @Override
    public void show(Model model) {
        
        System.out.println("Theme Manager Page");
        System.out.println("Temas: " + model.get("themes"));
        
    }

}
