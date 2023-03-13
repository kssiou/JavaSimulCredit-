package ma.creditSimula;

import ma.creditSimula.presentation.ICreditControleur;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class CrediSimulator_app {
    static ICreditControleur creditControleur;

    static Scanner clavier = new Scanner(System.in);
    private static boolean estNombre(String input){
        try {Integer.parseInt(input);return true ; }
        catch (Exception e){return false ;}
    }
//    public static void test1(){
//        var dao = new CreditDao();
//        var metier = new CreditMetier();
//        var controleur = new CreditControleur();
//        //injection des dependances
//        metier.setCreditDao(dao);
//        controleur.setCreditMetier(metier);
//        String rep ="" ;
//        do{
//            System.out.println("=>[Test 1] Calcule de Mentualite de credit <= \n");
//            try {
//                String input="";
//                while(true){
//                    System.out.println("=> Entrez l'id du credit ");
//                    input=clavier.nextLine();
//                    if(estNombre(input))break;
//                    System.err.println("Entree non valide ");
//
//                }
//                Long id = Long.parseLong(input);
//                controleur.afficher_mentualite(id);
//
//            }
//            catch (Exception e){
//
//                System.err.println(e.getMessage());
//
//            }
//            System.out.println("Voulez vous quittez (oui/non)");
//            rep = clavier.nextLine();
//        }while (!rep.equalsIgnoreCase("oui"));
//        System.out.println("Au revoir ^_^");
//
//    }
//    public static void test2() throws Exception{
//        String daoClass ;
//        String serviceClass;
//        String controllerClass;
//        Properties properties=new Properties();
//        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
//        InputStream propertiesfile = classLoader.getResourceAsStream("config.properties");
//        if (propertiesfile==null) throw new Exception("fichier config introuvalbe");
//        else{
//            try{
//                properties.load(propertiesfile);
//                daoClass=properties.getProperty("DAO");
//                serviceClass=properties.getProperty("SERVICE");
//                controllerClass = properties.getProperty("CONTROLLER");
//                propertiesfile.close();
//            }
//            catch(IOException e){
//                throw new Exception("Probleme de chargement des proprietes du fichier confiq");
//            }
//            finally {
//                properties.clear();
//            }
//            try{
//                Class cDao =Class.forName(daoClass);
//                Class cMetier=Class.forName(serviceClass);
//                Class cControlleur=Class.forName(controllerClass);
//                var dao =(IDao<Credit,Long>)cDao.getDeclaredConstructor().newInstance();
//                var metier =(ICreditMetier)cMetier.getDeclaredConstructor().newInstance();
//                var creditControleur =(ICreditControleur)cControlleur.getDeclaredConstructor().newInstance();
//                Method setDao =cMetier.getMethod("setCreditDao",IDao.class);
//                setDao.invoke(metier,dao);
//                Method setMetier=cControlleur.getMethod("setCreditMetier",ICreditMetier.class);
//                setMetier.invoke(creditControleur,metier);
//                creditControleur.afficher_mentualite(1L);
//
//            }
//            catch (Exception e){e.printStackTrace();}
//
//        }
   // }
    public static void test3() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("ma/creditSimula/spring-ioc.xml");
        creditControleur =(ICreditControleur)context.getBean("controleur");
        creditControleur.afficher_mentualite(1L);
    }
    public static void test4() throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext("ma.creditSimula.dao","ma.creditSimula.metier","ma.creditSimula.presentation");
        creditControleur=context.getBean(ICreditControleur.class);
        creditControleur.afficher_mentualite(1L);
    }
    public static void main(String[] args) throws Exception {
    test4();
    }
}