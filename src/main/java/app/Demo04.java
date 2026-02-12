package app;



import model.Usuario;



import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import java.time.LocalDate;

import java.util.logging.Level;

import java.util.logging.Logger;



public class Demo04 {



    private static void apagarLogsHibernate() {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Logger.getLogger("org.hibernate.jpa").setLevel(Level.OFF);

        Logger.getLogger("org.hibernate.engine").setLevel(Level.OFF);



        Logger root = Logger.getLogger("");

        root.setLevel(Level.SEVERE);

    }



    private static void imprimirUsuario(String titulo, Usuario u) {

        System.out.println(titulo);

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

            Long codigo = 16L; // <-- CAMBIE AQUÍ el código a modificar



            em.getTransaction().begin();



            Usuario u = em.find(Usuario.class, codigo);



            if (u == null) {

                System.out.println("usuario no existe");

                em.getTransaction().rollback();

                return;

            }



            // 1) MOSTRAR ANTES

            imprimirUsuario("USUARIO ENCONTRADO (ANTES)", u);



            // 2) MODIFICAR DATOS (edite lo que quiera)

            u.setNomUsua("Luis");

            u.setApeUsua("Romero");

            u.setUsrUsua("luis.romero@gmail.com");

            u.setClaUsua("romero123");

            u.setFnaUsua(LocalDate.of(1995, 8, 20));

            u.setIdtipo(1);

            u.setEstUsua(1);



            // 3) GUARDAR CAMBIOS

            // Como u fue obtenido con find(), ya está "gestionado".

            // Con commit se actualiza en la BD.

            em.getTransaction().commit();



            // 4) MOSTRAR DESPUÉS

            imprimirUsuario("USUARIO ACTUALIZADO (DESPUÉS)", u);



        } catch (Exception e) {

            if (em.getTransaction().isActive()) em.getTransaction().rollback();

            System.out.println("ERROR: " + e.getMessage());

        } finally {

            em.close();

            emf.close();

        }

    }

}