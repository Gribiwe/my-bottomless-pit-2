package exception;

public class GribiweException extends RuntimeException {

   public GribiweException(String message) {
      super(message);
   }

   public GribiweException(String message, Throwable cause) {
      super(message, cause);
   }

   public GribiweException(Throwable cause) {
      super(cause);
   }

   public GribiweException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
   }
}
