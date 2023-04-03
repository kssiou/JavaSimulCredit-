package ma.creditSimula.dao.Factory;

import ma.creditSimula.dao.IDao;
import ma.creditSimula.modele.Credit;

public abstract class DaoFactory {


    public static final int MYSQL_DAO_FACTORY =1;
    public static final int FILES_DAO_FACTORY =1;


    public abstract IDao<Credit,Long> getCreditDAO();


    public static DaoFactory getFactory(int type){
        switch (type){

            case MYSQL_DAO_FACTORY : return FactorySessionMySQL.getInstance();
           // case FILES_DAO_FACTORY: return new FactoryID() ;

            default:return null ;


        }



    }
}
