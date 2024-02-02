import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class CarbonEmission {
    public static void main(String[] args) {
        String emailUsername = InputReader.readUsername();
        String emailPassword = InputReader.readPassword();
        String emailDomain = InputReader.readEmailDomain();

        Properties pop3Properties = MailConfiguration.getPop3Properties(emailDomain);
        Session mailSession = Session.getDefaultInstance(pop3Properties, new MailAuthenticator(emailUsername, emailPassword));

        try {
            Store mailStore = mailSession.getStore("pop3");
            mailStore.connect(pop3Properties.getProperty("mail.pop3.host"), emailUsername, emailPassword);

            int inboxMessageCount = MailboxOperations.getInboxMessageCount(mailStore);

            double InboxCarbonEmission = CarbonEmissionCalculator.calculateCarbonEmission(inboxMessageCount);
            System.out.println("Carbon Emission of INBOX is: " + InboxCarbonEmission);

            mailStore.close();
        } catch (Exception exception) {
            System.out.println(exception + " error");
        }
    }
}