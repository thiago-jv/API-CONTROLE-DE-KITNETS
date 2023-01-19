package sis.apartamentos.com.br.infra.exception;

public class LancamentoNaoEncontadoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LancamentoNaoEncontadoException(String messagem) {
		super(messagem);
	}

	public LancamentoNaoEncontadoException(Long idLancamento) {
		this(String.format("Não existe cadastro de lancamento com o código %d", idLancamento));
	}

}
