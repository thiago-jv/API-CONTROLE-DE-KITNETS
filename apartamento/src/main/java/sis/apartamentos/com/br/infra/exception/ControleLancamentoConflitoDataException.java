package sis.apartamentos.com.br.infra.exception;

public class ControleLancamentoConflitoDataException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControleLancamentoConflitoDataException(String messagem) {
		super(messagem);
	}

}
