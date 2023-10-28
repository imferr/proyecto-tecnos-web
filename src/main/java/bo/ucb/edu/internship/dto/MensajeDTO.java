package bo.ucb.edu.internship.dto;

public class MensajeDTO {

    private int messageId;
    private String messageContent;
    private String sendDate;
    private UsuarioDTO userIdSender;
    private UsuarioDTO userIdReceiver;

    public MensajeDTO() {
    }

    public MensajeDTO(int messageId, String messageContent, String sendDate, UsuarioDTO userIdSender, UsuarioDTO userIdReceiver) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.sendDate = sendDate;
        this.userIdSender = userIdSender;
        this.userIdReceiver = userIdReceiver;
    }

    // getters

    public int getMessageId() {
        return messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSendDate() {
        return sendDate;
    }

    public UsuarioDTO getUserIdSender() {
        return userIdSender;
    }

    public UsuarioDTO getUserIdReceiver() {
        return userIdReceiver;
    }

    // setters

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public void setUserIdSender(UsuarioDTO userIdSender) {
        this.userIdSender = userIdSender;
    }

    public void setUserIdReceiver(UsuarioDTO userIdReceiver) {
        this.userIdReceiver = userIdReceiver;
    }

    @Override
    public String toString() {
        return "MensajeDTO{" +
                "messageId=" + messageId +
                ", messageContent='" + messageContent + '\'' +
                ", sendDate=" + sendDate +
                ", userIdSender=" + userIdSender +
                ", userIdReceiver=" + userIdReceiver +
                '}';
    }
    
}
