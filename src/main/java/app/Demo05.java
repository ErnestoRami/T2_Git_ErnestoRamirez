package app;



import model.Usuario;



import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import java.util.logging.Level;

import java.util.logging.Logger;



public class Demo05 {



    private static void apagarLogsHibernate() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Logger.getLogger("org.hibernate.jpa").setLevel(Level.OFF);

        Logger.getLogger("org.hibernate.engine").setLevel(Level.OFF);



        Logger root = Logger.getLogger("");

        root.setLevel(Level.SEVERE);

    }



    private static void imprimirUsuario(Usuario u) {

        System.out.println("USUARIO ENCONTRADO");

        System.out.println("Código      : " + u.getCodUsua());

        System.out.println("Nombre      : " + u.getNomUsua());

        System.out.println("Apellido    : " + u.getApeUsua());

        System.out.println("Correo      : " + u.getUsrUsua());

        System.out.println("Clave       : " + u.getClaUsua());

        System.out.println("Fecha nac.  : " + u.getFnaUsua());

        System.out.println("Tipo        : " + u.getIdtipo());

        System.out.println("Estado      : " + u.getEstUsua());

        System.out.println("------------------------------------");

    }



    public static void main(String[] args) {



        apagarLogsHibernate();



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlconex");

        EntityManager em = emf.createEntityManager();



        try {

            Long codigo = 8L; // <-- CAMBIE AQUÍ el código a eliminar



            em.getTransaction().begin();



            Usuario u = em.find(Usuario.class, codigo);



            if (u == null) {

                System.out.println("usuario no existe");

                em.getTransaction().rollback(); // no hubo cambios, cerramos limpio

            } else {

                imprimirUsuario(u);



                em.remove(u); // ELIMINACIÓN FÍSICA

                em.getTransaction().commit();



                System.out.println("USUARIO ELIMINADO CORRECTAMENTE");

            }



        } catch (Exception e) {

            if (em.getTransaction().isActive()) em.getTransaction().rollback();

            System.out.println("ERROR: " + e.getMessage());

        } finally {

            em.close();

            emf.close();

        }

    }

}