package es.upm.miw.voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;
import es.upm.miw.voting.rest.business.models.entities.Vote;
import es.upm.miw.voting.rest.business.views.ThemeDto;
import es.upm.miw.voting.rest.business.views.VotingThemeDto;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;

public class VotingThemesBO {

    public void addTheme(ThemeDto theme) {
        assert theme != null;
        DaoFactory.getFactory().getThemeDao().create(new Theme(this.generateThemeId(), theme.getTheme()));
    }

    private int generateThemeId() {
        int id = 0;
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        if (themes.size() == 0) {
            id = 1;
        } else {
            for (Theme theme : themes) {
                if (theme.getId() > id)
                    id = theme.getId();
            }
        }
        return id + 1;
    }

    public List<ThemeDto> getThemes() {
        ArrayList<ThemeDto> themes = new ArrayList<>();
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : themeList) {
            ThemeDto dto = new ThemeDto();
            dto.setTheme(theme.getName());
            themes.add(dto);
        }

        return themes;
    }

    public List<VotingThemeDto> getVotingThemes() {
        ArrayList<VotingThemeDto> votingthemes = new ArrayList<>();
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : themes) {
            List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
            double avg = averageVote(votes);
            VotingThemeDto dto = new VotingThemeDto();
            dto.setTheme(theme.getName());
            dto.setAverege(avg);
            votingthemes.add(dto);
        }
        return votingthemes;
    }

    private double averageVote(List<Vote> votes) {
        double result = 0;
        if (votes != null && votes.size() > 0) {
            for (Vote vote : votes) {
                result += vote.getVote();
            }
            result = result / votes.size();
        }
        return result;
    }

    public void addVote(VotingThemeDto votingTheme) {
        assert votingTheme != null;
        Theme theme = DaoFactory.getFactory().getThemeDao().findByName(votingTheme.getTheme());
        Vote vote = new Vote(this.generateVoteId(), votingTheme.getVote() , theme);
        DaoFactory.getFactory().getVoteDao().create(vote);
    }

    private int generateVoteId() {
        int id = -1;
        List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
        if (votes.size() == 0) {
            id = 1;
        } else {
            for (Vote vote : votes) {
                if (vote.getId() > id)
                    id = vote.getId();
            }
        }
        return id + 1;
    }

}
