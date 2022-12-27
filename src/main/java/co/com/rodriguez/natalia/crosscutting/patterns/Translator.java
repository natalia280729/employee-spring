package co.com.rodriguez.natalia.crosscutting.patterns;

import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;

/**
 * Patron de diseño Translator
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 * @param <I>
 * @param <O>
 */
@FunctionalInterface
public interface Translator<I, O> {

  O translate(final I input) throws CustomException;
}
