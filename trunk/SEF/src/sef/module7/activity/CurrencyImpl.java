package sef.module7.activity;

import java.util.Calendar;

/**
 * Represents an implementation of the Currency interface.  The equality test for
 * this currency implementation requires that the value and the name of the denomination
 * must be true in order to be considered equal.
 * 
 * @author Bernards Gulbis
 *
 */
public class CurrencyImpl implements Currency {

	float value;
	Calendar createDate;
	Denomination denomination;

	/**
	 * Creates an instance of the Currency class with the specified
	 * value and denomination
	 * 
	 * @param value the value of the currency 
	 * @param denomination the denomination of the currency
	 */
	public CurrencyImpl(float value, Denomination denomination) {
		this.value = value;
		this.denomination = (Denomination) new DenominationImpl(
				denomination.getName(),
				denomination.getDescription(), 
				denomination.getSymbol()
		);
		this.createDate = Calendar.getInstance();
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getValue()
	 */
	public float getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getDenomination()
	 */
	public Denomination getDenomination() {
		return (Denomination) new DenominationImpl(
				this.denomination.getName(),
				this.denomination.getDescription(),
				this.denomination.getSymbol()
		);
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getCreateDate()
	 */
	public Calendar getCreateDate() {
		return Calendar.getInstance(createDate.getTimeZone());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.valueOf(this.value) + 
			   " " + this.denomination.toString() + 
			   " " + this.createDate.getTime();
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o != null && o instanceof Currency) {
			Currency temp = (Currency) o;
			return (this.getValue() == temp.getValue() &&
					this.getDenomination().equals(temp.getDenomination()));
		}
		return false;
	}

}
