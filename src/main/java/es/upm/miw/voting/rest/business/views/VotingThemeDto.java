package es.upm.miw.voting.rest.business.views;

public class VotingThemeDto {

    String theme;

    double averege;
    
    int vote;

    public String getTheme() {
        return theme;
    }


    public void setTheme(String theme) {
        this.theme = theme;
    }


    public double getAverege() {
        return averege;
    }


    public void setAverege(double averege) {
        this.averege = averege;
    }


    public int getVote() {
        return vote;
    }


    public void setVote(int vote) {
        this.vote = vote;
    }


    public String toString() {
        return "ThemeTransfer [themeName=" + this.getTheme() + ", " + "average=" + String.format("%1$,.2f", this.getAverege()) + "]";
    }

}
