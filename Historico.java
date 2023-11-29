import greenfoot.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Historico  
{
    private HashMap<String, Integer> tabelaPontos;
    private ArrayList<String> arrayNome;
    private ArrayList<Integer> arrayPontos;

    public Historico()
    {
        tabelaPontos = new HashMap<>();
    }

    public void setInfo(String nomePlayer, int pontos){
        tabelaPontos.put(nomePlayer, pontos);
        ordenarPontos();
    }

    public void ordenarPontos() {
        // Criar uma lista de entradas (chave-valor) a serem ordenadas
        ArrayList<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(tabelaPontos.entrySet());

        // Ordenar a lista usando um comparador personalizado
        listaEntradas.sort((entrada1, entrada2) -> entrada2.getValue().compareTo(entrada1.getValue()));

        // Limpar a tabela original
        tabelaPontos.clear();

        // Preencher a tabela ordenada com as entradas ordenadas
        for (Map.Entry<String, Integer> entrada : listaEntradas) {
            tabelaPontos.put(entrada.getKey(), entrada.getValue());
        }

        // Preencher os arrays para facilitar o acesso posterior
        arrayNome = new ArrayList<>(tabelaPontos.keySet());
        arrayPontos = new ArrayList<>(tabelaPontos.values());

        System.out.println(arrayNome);
        System.out.println(arrayPontos);
    }
}
