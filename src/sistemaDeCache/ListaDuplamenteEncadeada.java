package sistemaDeCache;

public class ListaDuplamenteEncadeada {
    NoListaDuplamenteEncadeada cabeca;
    NoListaDuplamenteEncadeada cauda;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public void adcionarNaFrente(NoListaDuplamenteEncadeada no) {
        if (cabeca == null) {
            cabeca = cauda = no;
        } else {
            no.proximo = cabeca;
            cabeca.anterior = no;
            cabeca = no;
        }
    }

    public void removeNo(NoListaDuplamenteEncadeada no) {
        if (no == cabeca) {
            cabeca = no.proximo;
        }
        if (no == cauda) {
            cauda = no.anterior;
        }
        if (no.anterior != null) {
            no.anterior.proximo = no.proximo;
        }
        if (no.proximo != null) {
            no.proximo.anterior = no.anterior;
        }
        no.anterior = no.proximo = null;
    }

    public void moverParaFrente(NoListaDuplamenteEncadeada no) {
        removeNo(no);
        adcionarNaFrente(no);
    }

    public String removerCauda() {
        if (cauda != null) {
            String chave = cauda.chave;
            removeNo(cauda);
            return chave;
        }
        return null;
    }
}
