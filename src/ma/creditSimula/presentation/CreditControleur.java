package ma.creditSimula.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.creditSimula.metier.ICreditMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Data @AllArgsConstructor @NoArgsConstructor
@Controller
public class CreditControleur implements ICreditControleur {
    @Autowired
    @Qualifier("metier")
    ICreditMetier creditMetier ;

    @Override
    public void afficher_mentualite(long idCredit) throws Exception{
            var Creditsavecmentuallite=creditMetier.calculer_mentualite(idCredit);
        System.out.println(Creditsavecmentuallite);


    }
}
