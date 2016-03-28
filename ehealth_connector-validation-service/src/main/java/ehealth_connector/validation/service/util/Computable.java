package ehealth_connector.validation.service.util;

public interface Computable<A, V> {
	V compute(A arg) throws Exception;
}
