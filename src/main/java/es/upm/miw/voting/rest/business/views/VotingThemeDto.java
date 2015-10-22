package es.upm.miw.voting.rest.business.views;

public class VotingThemeDto {

    int themeId;

    String theme;

    int vote;

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String toString() {
        return "ThemeTransfer [themeName=" + this.getTheme() + ", " + "average=" + this.getVote() + "]";
    }

}
