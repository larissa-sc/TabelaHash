package sistemaDeCache;

public class TabelaHash {
    private No[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
    }

    private int hash(String chave) {
        return Math.abs(chave.hashCode() % tamanho);
    }

    public void insert(String chave, String valor) {
        int index = hash(chave);
        No newNo = new No(chave, valor);
        if (tabela[index] == null) {
            tabela[index] = newNo;
        } else {
            No atual = tabela[index];
            while (atual.proximo != null) {
                if (atual.chave.equals(chave)) {
                    atual.valor = valor;
                    return;
                }
                atual = atual.proximo;
            }
            if (atual.chave.equals(chave)) {
                atual.chave = valor;
            } else {
                atual.proximo = newNo;
            }
        }
    }

    public String busca(String chave) {
        int index = hash(chave);
        No atual = tabela[index];
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public boolean remove(String chave) {
        int index = hash(chave);
        No atual = tabela[index];
        No anterior = null;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                if (anterior == null) {
                    tabela[index] = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }
}
