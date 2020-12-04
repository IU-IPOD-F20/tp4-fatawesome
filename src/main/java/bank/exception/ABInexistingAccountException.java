package bank.exception;

/************************************************************
 * Cette exception est lev�e par la Classe BankAgency lorsque un compte n'existe pas dans l'agence.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class ABInexistingAccountException  extends Exception  {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public ABInexistingAccountException() {
		this("Erreur sur un objet de la classe BankAgency");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public ABInexistingAccountException(String message) {
		super(message);
	}

}
