/*
    Numerais romanos foram criados na Roma Antiga.
    Os números eram representados por sete diferentes
    símbolos, listados a seguir:
        • I, unus, 1, (um)
        • V, quinque, 5 (cinco)
        • X, decem, 10 (dez)
        • L, quinquaginta, 50 (cinquenta)
        • C, centum, 100 (cem)
        • D, quingenti, 500 (quinhentos)
        • M, mille, 1.000 (mil)

    Para representar outros números, os romanos
    combinavam estes símbolos, começando do
    algarismo de maior valor e seguindo a regra:
        • Algarismos de menor ou igual valor à direita
            são somados ao algarismo de maior valor;
        • Algarismos de menor valor à esquerda são subtraídos
            do algarismo de maior valor.
        • Nenhum símbolo pode ser repetido lado
            a lado por mais de 3 vezes (Ex: 4 é representado
            por IV, e não por IIII).

    Exemplo:
        • XV = 15
        • XIV = 14

 */

import java.util.HashMap;
import java.util.Map;

public class ConversorDeNumeroRomano {

    private static Map<Character, Integer> tabela =
            new HashMap<Character, Integer>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};

    public int converte(String numeroEmRomano) {
        int acumulador = 0;
        int ultimoVizinhoDaDireita = 0;

        for(int i = numeroEmRomano.length() - 1; i >= 0; i--) {
            // pega o inteiro referente ao simbolo atual
            int atual = tabela.get(numeroEmRomano.charAt(i));
            // se o da direita for menor, o multiplicaremos
            // por -1 para torná-lo negativo
            int multiplicador = 1;
            if(atual < ultimoVizinhoDaDireita) multiplicador = -1;
            acumulador += tabela.get(numeroEmRomano.charAt(i)) * multiplicador;
            // atualiza o vizinho da direita
            ultimoVizinhoDaDireita = atual;
        }
        return acumulador;
    }

}
