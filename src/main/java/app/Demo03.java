package app;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo03 {

    private static void apagarLogsHibernate() {

        Logger root = Logger.getLogger("");
        root.setLevel(Level.SEVERE);

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.engine.jdbc").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.jpa").setLevel(Level.OFF);
        Logger.getLogger("org.hibernate.orm").setLevel(Level.OFF);
    }

    private static void imprimirUsuarioDemo03(Usuario u) {
        System.out.println("USUARIO ENCONTRADO");
        System.out.println("Código (cod_usua): " + u.getCodUsua());
        System.out.println("Nombre (nom_usua): " + u.getNomUsua());
        System.out.println("Apellido (ape_usua): " + u.getApeUsua());
        System.out.println("Correo (usr_usua): " + u.getUsrUsua());
        System.out.println("Clave (cla_usua): " + u.getClaUsua());
        System.out.println("Fecha nac. (fna_usua): " + u.getFnaUsua());
        System.out.println("Tipo (idtipo): " + u.getIdtipo());
        System.out.println("Estado (est_usua): " + u.getEstUsua());
    }

    public static void main(String[] args) {

        apagarLogsHibernate();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlconex");
        EntityManager em = emf.createEntityManager();

        try {
            Long codigo = 3L;

            Usuario u = em.find(Usuario.class, codigo);

            if (u == null) {
                System.out.println("No existe usuario con código: " + codigo);
            } else {
                imprimirUsuarioDemo03(u);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}