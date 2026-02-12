package app;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo02 {
    private static void apagarLogsHibernate() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.jpa").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.engine").setLevel(Level.OFF);

        Logger root = Logger.getLogger("");
        root.setLevel(Level.SEVERE);

    }



    private static void imprimirUsuarioActualizado(Usuario u) {
        System.out.println("USUARIO ACTUALIZADO");
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
            Usuario u = new Usuario();
            u.setCodUsua(2L);

            // NUEVOS DATOS

            u.setNomUsua("Jorge");
            u.setApeUsua("Luna");
            u.setUsrUsua("joluna@gmail.com");
            u.setClaUsua("mibarriobarrunto***");
            u.setFnaUsua(LocalDate.of(1986, 1, 31));
            u.setIdtipo(1);
            u.setEstUsua(1);

            // ACTUALIZACIÓN

            em.merge(u);
            em.getTransaction().commit();
            imprimirUsuarioActualizado(u);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("ERROR: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

}