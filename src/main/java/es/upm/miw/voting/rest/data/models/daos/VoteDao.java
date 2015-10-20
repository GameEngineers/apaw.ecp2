package es.upm.miw.voting.rest.data.models.daos;

import java.util.List;

import es.upm.miw.voting.rest.business.models.entities.Theme;
import es.upm.miw.voting.rest.business.models.entities.Vote;

public interface VoteDao<T, ID> extends GenericDao<T, ID> {
    
    public List<Vote> findByTheme(Theme theme);

}
