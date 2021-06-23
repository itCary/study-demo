package online.goudan.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * @author 刘成龙
 * @date 2021/6/17 09:37
 * @desc 邮件管理组件
 */
public class MailManager {
    private static final Logger logger = LoggerFactory.getLogger(MailManager.class);
    private static MailType mailType = MailType.ALI;

    private static String sender = "liuchenglong@goudan.online";
    private static String password = "LCLacj123";

    /**
     * 发送邮件
     *
     * @param addressee 收件人邮箱地址
     * @param title     邮件主题
     * @param content   邮件内容
     */
    public static boolean sendMail(String addressee, String title, String content) {
        boolean enableSessionDebug = false;
        return sendMail(addressee, title, content, enableSessionDebug);
    }

    public static void setSender(String sender, String password, MailType mailType) {
        MailManager.sender = sender;
        MailManager.password = password;
        MailManager.mailType = mailType;
    }

    /**
     * @param addressee          收件人邮箱地址
     * @param title              邮件主题
     * @param content            邮件内容
     * @param enableSessionDebug 启用session debug日志开关
     */
    private static boolean sendMail(String addressee, String title,
                                    String content, boolean enableSessionDebug) {
        //邮箱配置
        Properties prop = configurationMailProp();
        //获取Session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            //此访求返回用户和密码的对象
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication pa = new PasswordAuthentication(sender, password);
                return pa;
            }
        });
        //设置session的调试模式，发布时取消
        session.setDebug(enableSessionDebug);
        try {
            MimeMessage mimeMessage = createMimeMessage(sender, addressee, title, content, session);
            //发送
            Transport.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            logger.error("发送邮件失败", e);
            return false;
        }
    }

    /**
     * 创建邮件消息对象
     *
     * @param sender
     * @param addressee
     * @param title
     * @param content
     * @param session
     * @return
     * @throws MessagingException
     */
    private static MimeMessage createMimeMessage(String sender, String addressee, String title, String content, Session session) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);
        //设置发送邮箱地址
        mimeMessage.setFrom(new InternetAddress(sender));
        //设置收件件人邮箱地址
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(addressee));
        //设置主题
        mimeMessage.setSubject(title);
        /* 创建用于组合邮件正文和附件的MimeMultipart对象 */
        MimeMultipart multipart = new MimeMultipart();
        // 设置HTML内容
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(content, "text/html;charset=utf-8");
        multipart.addBodyPart(bodyPart);
        //设置正文内容
        mimeMessage.setContent(multipart);

        mimeMessage.saveChanges();
        mimeMessage.setSentDate(new Date());
        return mimeMessage;
    }

    /**
     * 配置邮箱属性
     *
     * @return
     */
    private static Properties configurationMailProp() {
        Properties prop = new Properties();
        //协议
        prop.setProperty(mailType.getMailParam().PROTOCOL.getParamName(), mailType.getMailParam().PROTOCOL.getParamValue());
        //服务器
        prop.setProperty(mailType.getMailParam().HOST.getParamName(), mailType.getMailParam().HOST.getParamValue());
        //端口
        prop.setProperty(mailType.getMailParam().PORT.getParamName(), mailType.getMailParam().PORT.getParamValue());
        //使用smtp身份验证
        prop.setProperty(mailType.getMailParam().AUTH.getParamName(), mailType.getMailParam().AUTH.getParamValue());
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory mailSSLSocketFactory = null;
        try {
            mailSSLSocketFactory = new MailSSLSocketFactory();
            mailSSLSocketFactory.setTrustAllHosts(true);
        } catch (GeneralSecurityException e) {
            logger.error("error", e);
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
        return prop;
    }

}
