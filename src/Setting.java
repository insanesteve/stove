/*	CSCI306: CO6 - Stove Exercise
 *	AUTHORS: Stephen Agee and Easton Bornemeier
 *	PURPOSE: This enum is used in all burners as the current setting for each burner
 */
public enum Setting {
	OFF ("[---]"), LOW("[--+]"), MEDIUM("[-++]"), HIGH("[+++]");
	private String value;
	
	Setting (String aValue) {
		value = aValue;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
