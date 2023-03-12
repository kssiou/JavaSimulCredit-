package ma.creditSimula;

import ma.creditSimula.dao.IDao;
import ma.creditSimula.dao.daoVolatile.CreditDao;
import ma.creditSimula.metier.CreditMetier;
import ma.creditSimula.metier.ICreditMetier;
import ma.creditSimula.modele.Credit;
import ma.creditSimula.presentation.CreditControleur;
import ma.creditSimula.presentation.ICreditControleur;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CrediSimulator_app {
    static Scanner clavier = new Scanner(System.in);
    private static boolean estNombre(String input){
        try {Integer.parseInt(input);return true ; }
        catch (Exception e){return false ;}
    }
    public static void test1(){
        var dao = new CreditDao();
        var metier = new CreditMetier();
        var controleur = new CreditControleur();
        //injection des dependances
        metier.setCreditDao(dao);
        controleur.setCreditMetier(metier);
        String rep ="" ;
        do{
            System.out.println("=>[Test 1] Calcule de Mentualite de credit <= \n");
            try {
                String input="";
                while(true){
                    System.out.println("=> Entrez l'id du credit ");
                    input=clavier.nextLine();
                    if(estNombre(input))break;
                    System.err.println("Entree non valide ");

                }
                Long id = Long.parseLong(input);
                controleur.afficher_mentualite(id);

            }
            catch (Exception e){

                System.err.println(e.getMessage());

            }
            System.out.println("Voulez vous quittez (oui/non)");
            rep = clavier.nextLine();
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println("Au revoir ^_^");

    }
    public static void test2() throws Exception{
        String daoClass ;
        String serviceClass;
        String controllerClass;
        Properties properties=new Properties();
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        InputStream propertiesfile = classLoader.getResourceAsStream("config.properties");
        if (propertiesfile==null) throw new Exception("fichier config introuvalbe");
        else{
            try{
                properties.load(propertiesfile);
                daoClass=properties.getProperty("DAO");
                serviceClass=properties.getProperty("SERVICE");
                controllerClass = properties.getProperty("CONTROLLER");
                propertiesfile.close();
            }
            catch(IOException e){
                throw new Exception("Probleme de chargement des proprietes du fichier confiq");
            }
            finally {
                properties.clear();
            }

        }
    }
    public static void main(String[] args)  {

    }
}