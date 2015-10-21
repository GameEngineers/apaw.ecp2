package es.upm.miw.voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;
import es.upm.miw.voting.rest.business.views.ThemeDTO;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;

public class VotingThemesBO {


    public void addTheme(ThemeDTO theme) {
        DaoFactory.getFactory().getThemeDao().create(new Theme(theme.getId(), theme.getTheme()));
    }

    public ArrayList<ThemeDTO> getThemes() {
        ArrayList<ThemeDTO> themes = new ArrayList<>();
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : themeList) {
            themes.add(new ThemeDTO(theme.getId(), theme.getName()));
        }
        return themes;
    }

}
