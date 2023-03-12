package ma.creditSimula.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.creditSimula.metier.ICreditMetier;
@Data @AllArgsConstructor @NoArgsConstructor


public class CreditControleur implements ICreditControleur {
    ICreditMetier creditMetier ;

    @Override
    public void afficher_mentualite(long idCredit) throws Exception{
            var Creditsavecmentuallite=creditMetier.calculer_mentualite(idCredit);
        System.out.println(Creditsavecmentuallite);


    }
}
