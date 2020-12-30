package coreFramework;
import java.io.IOException;


public class Sendbuildreport {
//public static String strTestcase=ReportUtil.onlyTestCaseName;
public static String strTestcase="Verifycmpleteprocess";
	public static void main(String[] args) {
		 try {
			 String[] parms = {"wscript", "C:\\Users\\dekapil\\Desktop\\Sendmail.vbs",strTestcase};
			 Runtime.getRuntime().exec(parms);
		     // Runtime.getRuntime().exec( "wscript C:\\Users\\dekapil\\Desktop\\Sendmail.vbs" + strTestcase);
		   }
		   catch( IOException e ) {
		      System.out.println(e);
		      System.exit(0);
		   }
		// TODO Auto-generated method stub
//		final String username = "kapildev.j.89@gmail.com";
//        final String password = "#";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        //props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//          });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("kapildev.j.89@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse("capgemini.kapil@daimler.com"));
//            message.setSubject("Test");
//            message.setText("HI");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
		   }  
	}


