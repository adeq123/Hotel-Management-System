package adro.hms.services.helper;

import java.util.LinkedList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    private EmailMessage(EmailBuilder builder){

	this.from = builder.from;
	this.to = builder.to;
	this.subject = builder.subject;
	this.content = builder.content;
	this.mimeType = builder.mimeType;
	this.cc = builder.cc ;
	this.bcc = builder.bcc ;

    }

    public String getFrom(){
	return from;
    }

    public LinkedList<String> getTo(){
	return this.to;
    }

    public String getSubject(){
	return subject;
    }

    public String getContent(){
	return content;
    }

    public String getMimeType(){
	return from;
    }

    public LinkedList<String> getCc(){
	return cc;
    }

    public LinkedList<String> getBcc(){
	return bcc;
    }

    /**
     * The clas builds the Email with a given input
     * @author ADRO
     *
     */
    public static class EmailBuilder {

	private String from;
	private LinkedList<String> to;
	private String subject;
	private String content;
	private String mimeType; 
	private LinkedList<String> cc;
	private LinkedList<String> bcc;

	public EmailBuilder(String from, LinkedList<String> to) {
	    this.from = from;
	    this.to = to;  

	}

	public EmailBuilder addSubject(String subject){
	    this.subject = subject;
	    return this;
	}

	public EmailBuilder addContent (String content){
	    this.content = content;
	    return this;
	}

	public EmailBuilder addMimeType (String mimeType){
	    this.mimeType = mimeType;
	    return this;
	}

	public EmailBuilder addCc (LinkedList<String> cc){
	    this.cc = cc;
	    return this;
	}

	public EmailBuilder addBcc (LinkedList<String> bcc){
	    this.bcc = bcc;
	    return this;
	}

	public EmailMessage build() {
	    EmailMessage emailMessage = new EmailMessage(this);
	    return emailMessage;
	}



    }
/**
 * Sends this email message within SSL protocole
 * @param pwd, password to email box
 * @param host, String, host name of email provider
 * @param port, int, port used to send
 * @throws MessagingException
 */
    public void send(String pwd, String host, int port) throws MessagingException {

	Authenticator auth = new myAuthenticator(this.getFrom(), pwd);
	Properties props = new Properties();
	props.put("mail.transport.protocol", "smtps"); // protokol z ssl
	props.put("mail.smtps.auth", "true");

	Session mailSession = Session.getDefaultInstance(props,auth); 
	mailSession.setDebug(true);

	MimeMessage message = new MimeMessage(mailSession);
	message.setFrom(this.getFrom()); //required
	message.setSubject(this.getSubject());
	message.setContent(this.getContent(), "text/plain; charset=ISO-8859-2");
	
	if(this.getTo().size()>0){
	    // for(int i=0;i<this.getTo().size();i++)
	    message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getTo().get(0)));
	}

	if(this.getCc() != null && this.getCc().size() >0){
	    for(int i=0;i<this.getCc().size();i++)
		message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.getCc().get(i)));
	}

	if(this.getBcc() != null && this.getBcc().size()>0){
	    for(int i=0;i<this.getBcc().size();i++)
		message.addRecipient(Message.RecipientType.BCC, new InternetAddress(this.getBcc().get(i)));
	}

	Transport transport = mailSession.getTransport();// rowniez mosliweTransport transport = session.getTransport("smtps");//z s SSL
	transport.connect(host, port, this.getFrom(), pwd);


	transport.sendMessage(message, message
		.getRecipients(Message.RecipientType.TO));
	transport.close();
    }
}

/**
 * Creates new Authenticator for a given username and password
 * @author ADRO
 *
 */
class myAuthenticator extends Authenticator {
    String username;
    String password;

    //konstruktor
    public myAuthenticator(String username,String password){
	this.username = username;
	this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username, password);
    }

}



