package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{

	private Map<String, RadarContact> contacts;
	
	/**
	 *  Constructs a new Radar 
	 */
	public RadarImpl() {
		contacts = new HashMap<String, RadarContact>();
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {
		if (contact == null) {
			return null;
		}
		contacts.put(contact.getContactID(), contact);
		return (RadarContact) contacts.get(contact.getContactID());
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {
		return (RadarContact) contacts.get(id);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		return contacts.size();
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {
		return (RadarContact) contacts.remove(id);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
		
		List<RadarContact> temp = new ArrayList<RadarContact>() ;
		temp.addAll(contacts.values());
		return temp;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
		List<RadarContact> temp = new ArrayList<RadarContact>();
		temp.addAll(contacts.values());
		Collections.sort(temp, comparator);
		return temp;
	}

	
}
