package es.upm.miw.voting.rest.business.views;

public class VotingThemeDTO {

    String theme;

    int vote;

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

}
