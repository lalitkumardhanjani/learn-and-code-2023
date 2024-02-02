import java.util.Properties;

public class MailConfiguration {
    public static Properties getPop3Properties(String emailDomain) {
        Properties pop3Properties = new Properties();
        pop3Properties.put("mail.pop3.host", "pop." + emailDomain);
        pop3Properties.put("mail.pop3.user", "username");
        pop3Properties.put("mail.pop3.socketFactory", 995);
        pop3Properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pop3Properties.put("mail.pop3.port", 995);
        return pop3Properties;
    }
}