package sistemaDeCache;
public class NoListaDuplamenteEncadeada {
	String chave;
	String valor;
	NoListaDuplamenteEncadeada anterior;
	NoListaDuplamenteEncadeada proximo;
	
	public NoListaDuplamenteEncadeada(String chave, String valor,
	NoListaDuplamenteEncadeada anterior, NoListaDuplamenteEncadeada proximo) {
		super();
		this.chave = chave;
		this.valor = valor;
		this.anterior = null;
		this.proximo = null;
	}
}