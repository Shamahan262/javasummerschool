package sef.module7.activity;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 * 
 * @author Bernards Gulbis
 *
 */
public class DenominationImpl implements Denomination {

	private String name;
	private String symbol;
	private String description;
	
	/**
	 * Creates a new instance with the specified parameters
	 * 
	 * @param name the name of the denomination
	 * @param description a description 
	 * @param symbol
	 */
	public DenominationImpl(String name, String description, String symbol) {
		this.name = name;
		this.symbol = symbol;
		this.description = description;	
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getSymbol()
	 */
	public String getSymbol() {
		return symbol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " " + symbol + " " + description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o != null && o instanceof Denomination) {
			Denomination temp = (Denomination) o;
			return (this.getName() == temp.getName() && this.getSymbol() == temp.getSymbol());
		}
		return false;
	}

}
