package es.upm.miw.voting.rest.business.views;

public class ThemeDTO {

    int id;

    String theme;

    public void setId(int id) {
        this.id = id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

}
