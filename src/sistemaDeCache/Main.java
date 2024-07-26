package sistemaDeCache;

public class Main {
    public static void main(String[] args) {
        // Cria um cache com capacidade para 3 itens
        CacheLRU cache = new CacheLRU(3);

        // Adiciona alguns itens ao cache
        cache.put("1", "A");
        cache.put("2", "B");
        cache.put("3", "C");

        // Imprime o valor associado à chave "1"
        System.out.println("Valor para chave '1': " + cache.get("1")); // Deve imprimir "A"

        // Adiciona mais um item, o cache está cheio, então o item menos recentemente usado será removido
        cache.put("4", "D");

        // Imprime o valor associado à chave "2" (deveria ser removido, pois é o menos usado)
        System.out.println("Valor para chave '2': " + cache.get("2")); // Deve imprimir null (pois foi removido)

        // Imprime o valor associado à chave "3"
        System.out.println("Valor para chave '3': " + cache.get("3")); // Deve imprimir "C"

        // Imprime o valor associado à chave "4"
        System.out.println("Valor para chave '4': " + cache.get("4")); // Deve imprimir "D"

        // Adiciona mais um item ao cache
        cache.put("5", "E");

        // Imprime o valor associado à chave "1" (deve continuar no cache, pois foi recentemente acessado)
        System.out.println("Valor para chave '1': " + cache.get("1")); // Deve imprimir "A"

        // Imprime o valor associado à chave "3" (deve ter sido removido, pois foi o menos recentemente usado)
        System.out.println("Valor para chave '3': " + cache.get("3")); // Deve imprimir null (pois foi removido)

        // Imprime o valor associado à chave "4"
        System.out.println("Valor para chave '4': " + cache.get("4")); // Deve imprimir "D"

        // Imprime o valor associado à chave "5"
        System.out.println("Valor para chave '5': " + cache.get("5")); // Deve imprimir "E"
    }
}
