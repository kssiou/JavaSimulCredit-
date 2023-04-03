package ma.creditSimula.dao.daoMySQL;
import ma.creditSimula.dao.Factory.DaoFactory;
import ma.creditSimula.dao.Factory.FactorySessionMySQL;
import ma.creditSimula.dao.IDao;
import ma.creditSimula.dao.daoExceptions.DAOException;
import ma.creditSimula.modele.Credit;

import javax.net.ssl.HandshakeCompletedEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditDao implements IDao<Credit,Long> {

    FactorySessionMySQL factorySessionMySQL;

    @Override
    public Credit trouverParID(Long aLong) throws DAOException, Exception {
        Credit credit = null;
        Connection session=factorySessionMySQL.getSession();


        PreparedStatement ps = null;



        return null;
    }

    @Override
    public Credit save(Credit credit) {
        return null;
    }

    @Override
    public List<Credit> findall(Long aLong) {
        return null;
    }

    @Override
    public Credit update(Credit credit) {
        return null;
    }

    @Override
    public boolean delete(Credit credit) {
        return false;
    }

    @Override
    public Boolean deletebyId(Long aLong) {
        return null;
    }
}
