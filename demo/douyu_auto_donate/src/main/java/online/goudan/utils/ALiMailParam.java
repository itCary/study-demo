package online.goudan.utils;

public class ALiMailParam extends MailParam {
    public ALiMailParam() {
        PROTOCOL = new Param("mail.transport.protocol", "smtp", "协议");
        HOST = new Param("mail.smtp.host", "smtp.qiye.aliyun.com", "主机host");
        PORT = new Param("mail.smtp.port", "465", "邮箱端口");
        AUTH = new Param("mail.smtp.auth", "true", "是否使用smtp验证");
    }
}