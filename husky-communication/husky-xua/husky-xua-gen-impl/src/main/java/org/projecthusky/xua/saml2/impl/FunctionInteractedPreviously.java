package org.projecthusky.xua.saml2.impl;

import java.util.List;

import org.herasaf.xacml.core.function.AbstractFunction;
import org.herasaf.xacml.core.function.Function;
import org.herasaf.xacml.core.function.FunctionProcessingException;

public class FunctionInteractedPreviously extends AbstractFunction {

	/** XACML function ID. */
	public static final String ID = "urn:ihe:2017:record:function:interactedPreviously";

	private static final int VALID_LENGTH = 3;
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFunctionId() {
		return ID;
	}

	@Override
	public Object handle(Object... args) throws FunctionProcessingException {
		try {
			if (args.length != VALID_LENGTH) {
				throw new FunctionProcessingException("Invalid number of parameters");
			}
			Function function = (Function) args[0];

			// This instanceof test is essential to find out which parameter is
			// the list.
			// The XACML specification describes for the anyOffunction, which
			// parameter has to be a list. But in this case the specification is
			// wrong. The behaviour of nested Functions with an AnyOfAllFunction
			// is different to the behaviour of nested Functions with an
			// AllOfAnyFunction.
			if (args[2] instanceof List<?>) {
				for (Object obj : ((List<?>) args[2])) {
					if ((boolean) function.handle(args[1], obj)) {
						return true;
					}
				}
			} else if (args[1] instanceof List<?>) {
				for (Object obj : ((List<?>) args[1])) {
					if ((boolean) function.handle(obj, args[2])) {
						return true;
					}
				}
			}

			return false;
		} catch (FunctionProcessingException e) {
			throw e;
		} catch (Exception e) {
			throw new FunctionProcessingException(e);
		}
	}
}
