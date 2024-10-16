package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

public class PdfValidationException extends RuntimeException {

    public PdfValidationException(String message) {
        super(message);
    }

    public PdfValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PdfValidationException(Throwable cause) {
        super(cause);
    }

    public PdfValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
