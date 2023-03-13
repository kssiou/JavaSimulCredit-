package ma.creditSimula.dao.daoVolatile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.creditSimula.dao.IDao;
import ma.creditSimula.modele.Credit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Component("dao")
public class CreditDao implements IDao<Credit,Long> {

   static Set<Credit> BD_Credit(){
        var credits = new HashSet<Credit>(
       Arrays.asList(
               new Credit(1L,30000000.0,120,2.5,"mouad",0.0),
       new Credit(2L,2000000.0,120,3.5,"mouad",0.0),
       new Credit(1L,3000000.0,120,2.5,"mouad",0.0),
       new Credit(4L,4000000.0,30,2.0,"mouad",0.0)

       ));
        return credits ;
    }

    @Override
    public Credit trouverParID(Long id) {
        System.out.println("           ");
        return BD_Credit()
                .stream()
                .filter(credi -> credi.getId()==id)
                .findFirst()
                .orElse(null);
    }
}
