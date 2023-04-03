package ma.creditSimula.dao.Factory;

import ma.creditSimula.dao.IDao;
import ma.creditSimula.dao.daoExceptions.DAOConfigException;
import ma.creditSimula.dao.daoMySQL.CreditDao;
import ma.creditSimula.modele.Credit;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FactorySessionMySQL extends DaoFactory {
    private static FactorySessionMySQL INSTANCE =null ;
    private static Connection session =null;
    private static IDao<Credit,Long> CREDIT_DAO =null;





    private FactorySessionMySQL() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream propertiesFile = classLoader.getResourceAsStream("dao.propreties");
            Properties properties = new Properties();
            properties.load(propertiesFile);
            var url = properties.getProperty("URL");
            var username = properties.getProperty("USERNAME");
            var password = properties.getProperty("PASSWORD");


            session = DriverManager.getConnection(url, username, password);
            System.out.println("Connection avec succes ");

            var clientdao = properties.getProperty("CREDITDAO");


            Class cCreditdao =Class.forName(clientdao);

            CREDIT_DAO=(IDao<Credit, Long>) cCreditdao.getDeclaredConstructor().newInstance();

            Method setFactory = cCreditdao.getMethod("setFactory",DaoFactory.class);
            setFactory.invoke(CREDIT_DAO,this);





        }
         catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static Connection getSession() throws Exception {
        if (session ==null ){
            INSTANCE =getInstance();
        }
        return session;
    }

    public static Connection closeSession() throws Exception, DAOConfigException {
        if (session !=null ){
            try {
                session.close();
                System.out.println("la session a ete ferme");}


            catch (SQLException e){
                System.err.println("la session a ete echoue de ferme");
            }

        }
        return session;
    }

    @Override
    public IDao<Credit, Long> getCreditDAO() {
        if (CREDIT_DAO==null){getInstance();}
        return CREDIT_DAO;
    }
    public static FactorySessionMySQL getInstance(){

        if (session==null){
            INSTANCE = new FactorySessionMySQL();
        }
        return INSTANCE;
    }
}
