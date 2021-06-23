package online.goudan.utils;

@SuppressWarnings("all")
public enum MailType {
    QQ(new QQMailParam()), ALI(new ALiMailParam());
    private MailParam mailParam;

    MailType(MailParam mailParam) {
        this.mailParam = mailParam;
    }

    public MailParam getMailParam() {
        return mailParam;
    }
}
