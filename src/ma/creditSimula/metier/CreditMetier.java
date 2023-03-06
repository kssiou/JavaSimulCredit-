package ma.creditSimula.metier;

import lombok.var;
import ma.creditSimula.dao.IDao;
import ma.creditSimula.modele.Credit;

public class CreditMetier implements ICreditMetier  {
    IDao<Credit,Long> creditDao;

    @Override
    public Credit calculer_mentualite(Long idcredit) throws Exception{
        var credit =creditDao.trouverParID(idcredit);
        if(credit==null){
            throw new Exception("id du credit est incorecte :: [ Credit non trouver ]");
        }
        else {
            double taux =credit.getTaux_Mensuel();
                    taux=taux/1200;
            double capitale =credit.getCapitale_emprunte();
            int nbr_mois =credit.getNbr_mois();
            double mentualite = (capitale * taux) / (1 - (Math.pow((1 + taux) , -1 * nbr_mois)));
            mentualite =Math.round(mentualite*100)/100;
            credit.setMensualite(mentualite);
            return credit;


        }
    }
}
