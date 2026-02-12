package app;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo01 {



    private static void apagarLogsHibernate() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.jpa").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.engine").setLevel(Level.OFF);

        Logger root = Logger.getLogger("");
        root.setLevel(Level.SEVERE);

    }


    private static void imprimirUsuario(Usuario u) {
        System.out.println("USUARIO REGISTRADO");
        System.out.println("Código      : " + u.getCodUsua());
        System.out.println("Nombre      : " + u.getNomUsua());
        System.out.println("Apellido    : " + u.getApeUsua());
        System.out.println("Correo      : " + u.getUsrUsua());
        System.out.println("Clave       : " + u.getClaUsua());
        System.out.println("Fecha nac.  : " + u.getFnaUsua());
        System.out.println("Tipo        : " + u.getIdtipo());
        System.out.println("Estado      : " + u.getEstUsua());
    }



    public static void main(String[] args) {
        apagarLogsHibernate();
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("mysqlconex");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Usuario u = new Usuario(
                    "Ernesto",
                    "Ramirez",
                    "manuelrt19@gmail.com",
                    "manurate",
                    LocalDate.of(1990, 1, 1),
                    1,
                    1
            );

            em.persist(u);
            em.getTransaction().commit();

            imprimirUsuario(u);


        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();

            System.out.println("ERROR: " + e.getMessage());
        } finally {
            em.close();
            emf.close();

        }

    }

}