package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

public class QrCodeGenerationException extends RuntimeException {
  public QrCodeGenerationException() {
  }

  public QrCodeGenerationException(String message) {
    super(message);
  }

  public QrCodeGenerationException(String message, Throwable cause) {
    super(message, cause);
  }

  public QrCodeGenerationException(Throwable cause) {
    super(cause);
  }

  public QrCodeGenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
