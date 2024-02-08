import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class MailboxOperations {
    public static int getInboxMessageCount(Store mailStore) throws MessagingException {
        Folder inboxFolder = mailStore.getFolder("INBOX");
        inboxFolder.open(Folder.HOLDS_MESSAGES);
        int messageCount = inboxFolder.getMessageCount();
        inboxFolder.close(false);
        return messageCount;
    }
}