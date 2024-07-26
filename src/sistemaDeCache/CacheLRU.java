package sistemaDeCache;

import java.util.HashMap;

public class CacheLRU {
    private int capacidade;
    private TabelaHash cache;
    private ListaDuplamenteEncadeada acessarOrdem;
    private HashMap<String, NoListaDuplamenteEncadeada> nos;

    public CacheLRU(int capacidade) {
        this.capacidade = capacidade;
        this.cache = new TabelaHash(capacidade);
        this.acessarOrdem = new ListaDuplamenteEncadeada();
        this.nos = new HashMap<>();
    }

    public String get(String chave) {
        NoListaDuplamenteEncadeada no = nos.get(chave);
        if (no == null) {
            return null;
        }
        acessarOrdem.moverParaFrente(no);
        return no.valor;
    }

    public void put(String chave, String valor) {
        if (nos.containsKey(chave)) {
            NoListaDuplamenteEncadeada no = nos.get(chave);
            no.valor = valor;
            acessarOrdem.moverParaFrente(no);
        } else {
            if (nos.size() >= capacidade) {
                String chaveAntiga = acessarOrdem.removerCauda();
                nos.remove(chaveAntiga);
                cache.remove(chaveAntiga);
            }
            NoListaDuplamenteEncadeada novoNo = new NoListaDuplamenteEncadeada(chave, valor, null, null);
            acessarOrdem.adcionarNaFrente(novoNo);
            nos.put(chave, novoNo);
            cache.insert(chave, valor);
        }
    }
}