package bank.exception;

/************************************************************
 * Cette exception est lev�e par la Classe Account lorsque un d�bit ou cr�dit
 * n'est pas possible. <BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class AccountException extends Exception {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public AccountException() {
		super("Erreur sur un objet de la classe Account");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public AccountException(String message) {
		super(message);
	}
}
