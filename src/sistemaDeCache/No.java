package sistemaDeCache;
public class No {
	String chave;
	String valor;
	No proximo;
	
	public No(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
		this.proximo = null;
		}

}