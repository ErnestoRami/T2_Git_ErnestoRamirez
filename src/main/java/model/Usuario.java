package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usua")

    private Long codUsua;
    @Column(name = "nom_usua", nullable = false, length = 60)

    private String nomUsua;
    @Column(name = "ape_usua", nullable = false, length = 60)

    private String apeUsua;
    @Column(name = "usr_usua", nullable = false, length = 80)

    private String usrUsua;
    @Column(name = "cla_usua", nullable = false, length = 30)

    private String claUsua;
    @Column(name = "fna_usua", nullable = false)

    private LocalDate fnaUsua;
    @Column(name = "idtipo", nullable = false)

    private Integer idtipo;
    @Column(name = "est_usua", nullable = false)

    private Integer estUsua;

    public Usuario() {}

    public Usuario(String nomUsua, String apeUsua, String usrUsua, String claUsua,
                   LocalDate fnaUsua, Integer idtipo, Integer estUsua) {

        this.nomUsua = nomUsua;
        this.apeUsua = apeUsua;
        this.usrUsua = usrUsua;
        this.claUsua = claUsua;
        this.fnaUsua = fnaUsua;
        this.idtipo = idtipo;
        this.estUsua = estUsua;

    }



    public Long getCodUsua() { return codUsua; }
    public void setCodUsua(Long codUsua) { this.codUsua = codUsua; }

    public String getNomUsua() { return nomUsua; }
    public void setNomUsua(String nomUsua) { this.nomUsua = nomUsua; }

    public String getApeUsua() { return apeUsua; }
    public void setApeUsua(String apeUsua) { this.apeUsua = apeUsua; }

    public String getUsrUsua() { return usrUsua; }
    public void setUsrUsua(String usrUsua) { this.usrUsua = usrUsua; }

    public String getClaUsua() { return claUsua; }
    public void setClaUsua(String claUsua) { this.claUsua = claUsua; }

    public LocalDate getFnaUsua() { return fnaUsua; }
    public void setFnaUsua(LocalDate fnaUsua) { this.fnaUsua = fnaUsua; }

    public Integer getIdtipo() { return idtipo; }
    public void setIdtipo(Integer idtipo) { this.idtipo = idtipo; }

    public Integer getEstUsua() { return estUsua; }
    public void setEstUsua(Integer estUsua) { this.estUsua = estUsua; }


    @Override

    public String toString() {
        return "Usuario{" +
                "codUsua=" + codUsua +
                ", nomUsua='" + nomUsua + '\'' +
                ", apeUsua='" + apeUsua + '\'' +
                ", usrUsua='" + usrUsua + '\'' +
                ", fnaUsua=" + fnaUsua +
                ", idtipo=" + idtipo +
                ", estUsua=" + estUsua +
                '}';
    }

}