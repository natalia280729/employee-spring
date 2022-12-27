package co.com.rodriguez.natalia.crosscutting.domain.exceptions;

import java.io.Serializable;
/**
 * CustomException
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
public class CustomException extends Exception implements Serializable {
  /** */
  private static final long serialVersionUID = -8755391481029161748L;

  private String value;

  public CustomException(String value) {
    this.value = value;
  }

  public String toString() {
    return this.value.toString();
  }
}
