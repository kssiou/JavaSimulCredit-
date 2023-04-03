package ma.creditSimula.dao;

import ma.creditSimula.dao.daoExceptions.DAOException;
import ma.creditSimula.modele.Credit;

import java.util.List;

public interface IDao <T,ID>{
   T trouverParID (ID id) throws DAOException, Exception;
   T save(T t) throws DAOException;
   List<T> findall(ID id) throws DAOException;
   T update(T t);
   boolean delete(T t ) throws DAOException;
   Boolean deletebyId(ID id ) throws DAOException;



}
