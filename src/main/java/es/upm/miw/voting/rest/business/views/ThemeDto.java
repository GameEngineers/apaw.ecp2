package es.upm.miw.voting.rest.business.views;

public class ThemeDto {

    String theme;

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return theme;
    }

}
