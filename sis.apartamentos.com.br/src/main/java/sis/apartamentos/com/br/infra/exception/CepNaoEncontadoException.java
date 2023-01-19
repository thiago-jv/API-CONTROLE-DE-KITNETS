package sis.apartamentos.com.br.infra.exception;

public class CepNaoEncontadoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CepNaoEncontadoException(String messagem) {
		super(messagem);
	}

	public CepNaoEncontadoException() {
		this(String.format("Não foi possivel encontrar o cep"));
	}

}
