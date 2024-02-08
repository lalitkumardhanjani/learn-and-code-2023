import java.util.Properties;

public class MailConfiguration {
    public static Properties getPop3Properties(String emailDomain) {
        Properties mailConfigurationProperties = new Properties();
        mailConfigurationProperties.put(Constants.MAIL_POP3_HOST, "pop." + emailDomain);
        mailConfigurationProperties.put(Constants.MAIL_POP3_USER, "username");
        mailConfigurationProperties.put(Constants.MAIL_POP3_SOCKET_FACTORY, 995);
        mailConfigurationProperties.put(Constants.MAIL_POP3_SOCKET_FACTORY_CLASS, "javax.net.ssl.SSLSocketFactory");
        mailConfigurationProperties.put(Constants.MAIL_POP3_PORT, 995);
        return mailConfigurationProperties;
    }
}
