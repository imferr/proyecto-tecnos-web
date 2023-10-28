package bo.ucb.edu.internship.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "convocatoriapractica")

public class ConvocatoriaPracticaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convocatoriaid")
    private Integer convocatoriaId;

    @Column(name = "titulo_convocatoria", length = 50, nullable = false)
    private String tituloConvocatoria;

    @Column(name = "descripcion_convocatoria", length = 50, nullable = false)
    private String descripcionConvocatoria;

    @Column(name = "fecha_publicacion", nullable = false)
    private Date fechaPublicacion;

    @Column(name = "estado_aprobacion", nullable = false)
    private Boolean estadoAprobacion;

    @ManyToOne
    @JoinColumn(name = "institucionempresa_empresaid", referencedColumnName = "empresaid", nullable = false)
    private EmpresaEntity companyId;

    @ManyToOne
    @JoinColumn(name = "usei_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UseiEntity useiId;

    public ConvocatoriaPracticaEntity() {
    }

    public ConvocatoriaPracticaEntity(Integer convocatoriaId, String tituloConvocatoria, String descripcionConvocatoria, Date fechaPublicacion, Boolean estadoAprobacion, EmpresaEntity companyId, UseiEntity useiId) {
        this.convocatoriaId = convocatoriaId;
        this.tituloConvocatoria = tituloConvocatoria;
        this.descripcionConvocatoria = descripcionConvocatoria;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoAprobacion = estadoAprobacion;
        this.companyId = companyId;
        this.useiId = useiId;
    }

    public Integer getConvocatoriaPracticaId() {
        return convocatoriaId;
    }

    public String getTitleConvocatoria() {
        return tituloConvocatoria;
    }

    public String getDescriptionConvocatoria() {
        return descripcionConvocatoria;
    }

    public Date getDateConvocatoria() {
        return fechaPublicacion;
    }

    public Boolean getStateConvocatoria() {
        return estadoAprobacion;
    }

    public EmpresaEntity getCompanyId() {
        return companyId;
    }

    public UseiEntity getUseiId() {
        return useiId;
    }

    public void setConvocatoriaPracticaId(Integer convocatoriaId) {
        this.convocatoriaId = convocatoriaId;
    }

    public void setTitleConvocatoria(String tituloConvocatoria) {
        this.tituloConvocatoria = tituloConvocatoria;
    }

    public void setDescriptionConvocatoria(String descripcionConvocatoria) {
        this.descripcionConvocatoria = descripcionConvocatoria;
    }

    public void setDateConvocatoria(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setStateConvocatoria(Boolean estadoAprobacion) {
        this.estadoAprobacion = estadoAprobacion;
    }

    public void setCompanyId(EmpresaEntity companyId) {
        this.companyId = companyId;
    }

    public void setUseiId(UseiEntity useiId) {
        this.useiId = useiId;
    }

    @Override
    public String toString() {
        return "ConvocatoriaPracticaEntity{" +
                "convocatoriaId=" + convocatoriaId +
                ", tituloConvocatoria='" + tituloConvocatoria + '\'' +
                ", descripcionConvocatoria='" + descripcionConvocatoria + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", estadoAprobacion=" + estadoAprobacion +
                ", companyId=" + companyId +
                ", useiId=" + useiId +
                '}';
    }
    
}
