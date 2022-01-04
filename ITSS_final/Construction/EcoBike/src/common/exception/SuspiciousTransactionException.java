package common.exception;;
/**
 * This exception is thrown when the transaction is suspicious
 *
 * @author BachDV
 * @version 1.0
 */
public class SuspiciousTransactionException extends PaymentException {
	/**
	 * Exception Construction
	 */
	public SuspiciousTransactionException() {
		super("ERROR: Suspicious Transaction Report!");
	}
}
