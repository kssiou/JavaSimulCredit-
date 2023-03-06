package ma.creditSimula.dao;

public interface IDao <T,ID>{
   T trouverParID (ID id);
}
