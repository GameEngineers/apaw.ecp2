package es.upm.miw.voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;
import es.upm.miw.voting.rest.business.models.entities.Vote;
import es.upm.miw.voting.rest.business.views.ThemeDTO;
import es.upm.miw.voting.rest.business.views.VotingThemeDTO;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;

public class VotingThemesBO {

    public void addTheme(ThemeDTO theme) {
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

    public List<ThemeDTO> getThemes() {
        ArrayList<ThemeDTO> themes = new ArrayList<>();
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : themeList) {
            ThemeDTO dto = new ThemeDTO();
            dto.setId(theme.getId());
            dto.setTheme(theme.getName());
            themes.add(dto);
        }

        return themes;
    }

    public List<VotingThemeDTO> getVotingThemes() {
        ArrayList<VotingThemeDTO> votingthemes = new ArrayList<>();
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : themes) {
            List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
            int avg = averageVote(votes);
            VotingThemeDTO dto = new VotingThemeDTO();
            dto.setTheme(theme.getName());
            dto.setThemeId(theme.getId());
            dto.setVote(avg);
            votingthemes.add(dto);
        }
        return votingthemes;
    }

    private int averageVote(List<Vote> votes) {
        int result = 0;
        if (votes != null && votes.size() > 0) {
            for (Vote vote : votes) {
                result += vote.getVote();
            }
            result = result / votes.size();
        }
        return result;
    }

    public void addVote(VotingThemeDTO votingTheme) {
        assert votingTheme != null;
        Theme theme = DaoFactory.getFactory().getThemeDao().read(votingTheme.getThemeId());
        Vote vote = new Vote(this.generateVoteId(), votingTheme.getVote(), theme);
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
