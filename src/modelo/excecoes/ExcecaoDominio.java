package modelo.excecoes;

public class ExcecaoDominio extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ExcecaoDominio(String mensagem) {
		super(mensagem);
	}
	
	
}
