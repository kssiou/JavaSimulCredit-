package ma.creditSimula.metier;

import ma.creditSimula.dao.daoExceptions.DAOException;
import ma.creditSimula.modele.Credit;

public interface ICreditMetier {
     Credit calculer_mentualite(Long idcredit) throws Exception, DAOException;
}
