package ma.creditSimula.presentation;

import lombok.var;
import ma.creditSimula.metier.ICreditMetier;

public class CreditControleur implements ICreditControleur {
    ICreditMetier creditMetier ;

    @Override
    public void afficher_mentualite(long idCredit) throws Exception{
            var Creditsavecmentuallite=creditMetier.calculer_mentualite(idCredit);
        System.out.println(Creditsavecmentuallite);


    }
}
