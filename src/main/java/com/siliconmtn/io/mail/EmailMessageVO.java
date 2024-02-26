package com.siliconmtn.io.mail;

// JDK 11.x
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Spacelib java 1.2.2
import com.siliconmtn.data.text.StringUtil;

// Lombok 1.x
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/****************************************************************************
 * <b>Title</b>: EmailMessageVO.java <b>Project</b>: ntfc-msg-svc
 * <b>Description: </b> Data bean to hold the information to be emailed
 * <b>Copyright:</b> Copyright (c) 2022 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 5, 2022
 * @updates:
 ****************************************************************************/
@Data
@AllArgsConstructor
public class EmailMessageVO {

	/**
	 * Enum to specify the types of recipients
	 */
	public enum RecipientType {
		TO, CC, BCC;
	}
	
	// Members
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Map<RecipientType, List<String>> allRecipients;

	private String fromEmail;
	private String replyTo;
	private String subject;
	private StringBuilder message;
	private Map<String, byte[]> attachments;
	
	/**
	 * Initializes the recipient types
	 */
	public EmailMessageVO() {
		// Initialize and create an empty list for each type
		allRecipients = new EnumMap<>(RecipientType.class);
		attachments = new HashMap<>();

		for (RecipientType rt : RecipientType.values()) {
			allRecipients.put(rt, new ArrayList<>());
		}
	}

	/**
	 * Helper method to determine if the message has attachments
	 * 
	 * @return True if attachments 
	        helper.setReplyTo(vo.getReplyTo());are present. False otherwise
	 */
	public boolean hasAttachments() {
		return !attachments.isEmpty();
	}
	
	/**
	 * Get the replyTo when provided, get fromEmail when not
	 * @return
	 */
	public String getReplyTo() {
		return StringUtil.isEmpty(replyTo)? fromEmail : replyTo;
	}

	/**
	 * Add a single to recipient
	 * @param recipient
	 */
	public void addToRecipient(String recipient) {
		addRecipient(recipient, RecipientType.TO);
	}
	
	/**
	 * Add a single CC recipient
	 * @param recipient
	 */
	public void addCCRecipient(String recipient) {
		addRecipient(recipient, RecipientType.CC);
	}
	
	/**
	 * Add a single BCC recipient
	 * @param recipient
	 */
	public void addBCCRecipient(String recipient) {
		addRecipient(recipient, RecipientType.BCC);
	}

	/**
	 * Adds a recipient to the list
	 * 
	 * @param recipient Email address or phone number of the recipient
	 * @param type      Type of recipient to, cc, bcc
	 */
	public void addRecipients(List<String> recipients, RecipientType type) {
		if (recipients == null || recipients.isEmpty() || type == null)
			return;
		this.allRecipients.put(type, recipients);
	}

	/**
	 * Adds a recipient to the list
	 * 
	 * @param recipient Email address or phone number of the recipient
	 * @param type      Type of recipient to, cc, bcc
	 */
	public void addRecipient(String recipient, RecipientType type) {
		if(!StringUtil.isEmpty(recipient) && type != null) {
			allRecipients.get(type).add(recipient);
		}
	}

	/**
	 * Adds a TO recipient to the list
	 * 
	 * @param recipient Email address or phone number of the recipient
	 */
	public void addRecipient(String recipient) {
		allRecipients.get(RecipientType.TO).add(recipient);
	}

	/**
	 * Returns a list of recipients by the type. Empty list if no recipients
	 * 
	 * @param type Recipient Type to send
	 * @return List of recipients matching the type. Empty list if none
	 */
	public String[] getRecipients(RecipientType type) {
		return allRecipients.get(type).toArray(new String[0]);
	}
	
	/**
	 * Get all To addresses
	 * @return
	 */
	public String[] getTo() {
		return getRecipients(RecipientType.TO);
	}
	
	/**
	 * Get all CC addresses
	 * @return
	 */
	public String[] getCC() {
		return getRecipients(RecipientType.CC);
	}
	
	/**
	 * Get all BCC addresses
	 * @return
	 */
	public String[] getBCC() {
		return getRecipients(RecipientType.BCC);
	}

	/**
	 * Adds an attachment to be sent
	 * 
	 * @param attachment
	 */
	public void addAttachment(String fileNm, byte[] attachment) {
		attachments.put(fileNm, attachment);
	}
}
