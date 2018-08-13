package ua.com.oliinyk.service;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

/**
 * Created for JavaStudy.ru on 28.02.2016.
 */
@Service
public class EmailService {

	/* Email From */
	public static final String FROM = "from";
	/* Email To */
	public static final String TO = "to";
	/* Email Subject */
	public static final String SUBJECT = "subject";
	/* Email BCC */
	public static final String BCC_LIST = "bccList";
	/* Email CCC */
	public static final String CCC_LIST = "ccList";

	@Autowired
	private JavaMailSender mailSender;

//todo: use Freemarker instead
	private VelocityEngine velocityEngine;

	public boolean sendEmail(final String templateName, final VelocityContext velocityContext) {
		boolean res = false;
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					String from = (String) velocityContext.get(FROM);
					String to = (String) velocityContext.get(TO);
					String subject = (String) velocityContext.get(SUBJECT);

					@SuppressWarnings("unchecked")
					List<String> bccList = (List<String>) velocityContext.get(BCC_LIST);
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
					message.setFrom(from);
					message.setTo(to);
					message.setSubject(subject);
					message.setSentDate(new Date());
					if (bccList != null) {
						for (String bcc : bccList) {
							message.addBcc(bcc);
						}
					}

					velocityContext.put("noArgs", new Object());
					StringWriter stringWriter = new StringWriter();
					velocityEngine.mergeTemplate(templateName, "UTF-8", velocityContext, stringWriter);
					message.setText(stringWriter.toString(), true);

				}
			};

			mailSender.send(preparator);
			res = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
	}

}