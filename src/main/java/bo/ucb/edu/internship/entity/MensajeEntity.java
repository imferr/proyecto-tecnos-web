package bo.ucb.edu.internship.entity;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "mensaje")
public class MensajeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensajeid")
    private Integer messageId;

    @Column(name = "contenido_mensaje", length = 70, nullable = false)
    private String messageContent;

    @Column(name = "fecha_envio", nullable = false)
    private Date sendDate;

    @ManyToOne
    @JoinColumn(name = "usuario_usuarioid_emisor", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userIdSender;

    @ManyToOne
    @JoinColumn(name = "usuario_usuarioid_receptor", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userIdReceiver;

    public MensajeEntity() {
    }

    public MensajeEntity(Integer messageId, String messageContent, Date sendDate, UsuarioEntity userIdSender, UsuarioEntity userIdReceiver) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.sendDate = sendDate;
        this.userIdSender = userIdSender;
        this.userIdReceiver = userIdReceiver;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public UsuarioEntity getUserIdSender() {
        return userIdSender;
    }

    public UsuarioEntity getUserIdReceiver() {
        return userIdReceiver;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setUserIdSender(UsuarioEntity userIdSender) {
        this.userIdSender = userIdSender;
    }

    public void setUserIdReceiver(UsuarioEntity userIdReceiver) {
        this.userIdReceiver = userIdReceiver;
    }

    @Override
    public String toString() {
        return "MensajeEntity{" +
                "messageId=" + messageId +
                ", messageContent='" + messageContent + '\'' +
                ", sendDate=" + sendDate +
                ", userIdSender=" + userIdSender +
                ", userIdReceiver=" + userIdReceiver +
                '}';
    }

}
