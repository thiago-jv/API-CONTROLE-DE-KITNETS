package sis.apartamentos.com.br.infra.exception;

public class ApartamentoNaoEncontadoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApartamentoNaoEncontadoException(String messagem) {
		super(messagem);
	}

	public ApartamentoNaoEncontadoException(Long idApartamento) {
		this(String.format("Não existe cadastro de apartamento com o código %d", idApartamento));
	}

}
