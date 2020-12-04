package bank.exception;

/************************************************************
 * Cette exception est lev�e par la Classe BankAgency lorsque un compte existe dans l'angence.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class ABAccountAlreadyExistingException  extends Exception  {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public ABAccountAlreadyExistingException() {
		this("Erreur sur un objet de la classe BankAgency");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public ABAccountAlreadyExistingException(String message) {
		super(message);
	}

}
