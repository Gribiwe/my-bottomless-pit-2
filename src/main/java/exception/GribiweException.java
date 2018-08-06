package exception;

/**
 * Class for Gribiwe's own exceptions.
 *
 * @author Gribiwe
 */
public class GribiweException extends RuntimeException {

   /**
    * Translates String representation of cause
    * why exception is thrown by human language
    * into GribiweException object
    *
    * @param message String with information about
    *                cause of exception explained
    *                by human's language
    */
   public GribiweException(String message) {
      super(message);
   }

   /**
    * Translates String representation of cause
    * why exception is thrown by human language
    * into GribiweException object, also uses
    * another one for addition (for explain e.g.)
    *
    * @param cause   anther exception for addition
    *                of info
    * @param message stroke with information about
    *                cause of exception explained
    *                by human's language
    */
   public GribiweException(String message, Throwable cause) {
      super(message, cause);
   }

}
