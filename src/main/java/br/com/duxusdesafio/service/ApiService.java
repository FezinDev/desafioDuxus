package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {

        // itera os times da lista para identificar qual time corresponte a data
        for (Time time : todosOsTimes) {
            // compara a data do time com a data informada
            if (time.getData().equals(data)) {
                return time;
            }
        }
        return null;
    }

    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        Integrante integranteMaisUsado = null;
        int maxCont = 0;

        // itera os times
        for (Time time : todosOsTimes) {
            // verifica se a data do time está dentro do intervalo mencionado
            if (!time.getData().isBefore(dataInicial) && !time.getData().isAfter(dataFinal)) {
                // itera os integrantes do time
                for (ComposicaoTime composicao : time.getComposicaoTime()) {
                    Integrante integrante = composicao.getIntegrante();

                    // serve para contar quantas vezes o integrante aparece no intervalo mencionado
                    int cont = 0;

                    // itera os times para contar as aparições do integrante
                    for (Time t : todosOsTimes) {
                        // verifica se a data do time está dentro do intervalo mencionado
                        if (!t.getData().isBefore(dataInicial) && !t.getData().isAfter(dataFinal)) {
                            for (ComposicaoTime c : t.getComposicaoTime()) {
                                if (c.getIntegrante().equals(integrante)) {
                                    cont++;
                                }
                            }
                        }
                    }

                    // atualiza o integrante mais utilizado
                    if (cont > maxCont) {
                        maxCont = cont;
                        integranteMaisUsado = integrante;
                    }
                }
            }
        }

        return integranteMaisUsado;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // variáveis para armazenar o time mais comum e a maior contagem
        Time timeMaisComum = null;
        int maxCount = 0;

        // itera sobre os times para contar as ocorrências de cada um dentro do intervalo
        for (Time time : todosOsTimes) {
            // Verifica se o time está dentro do intervalo de datas
            if (!time.getData().isBefore(dataInicial) && !time.getData().isAfter(dataFinal)) {
                // Conta quantas vezes esse time aparece dentro do intervalo
                int count = 0;
                for (Time t : todosOsTimes) {
                    if (t.equals(time) && !t.getData().isBefore(dataInicial) && !t.getData().isAfter(dataFinal)) {
                        count++;
                    }
                }

                // Atualiza o time mais comum se a contagem for maior que a anterior
                if (count > maxCount) {
                    maxCount = count;
                    timeMaisComum = time;
                }
            }
        }

        // lista para armazenar os nomes dos integrantes do time mais comum
        List<String> nomesIntegrantes = new ArrayList<>();

        // adiciona os nomes dos integrantes do time mais comum
        for (ComposicaoTime composicao : timeMaisComum.getComposicaoTime()) {
            nomesIntegrantes.add(composicao.getIntegrante().getNome());
        }

        return nomesIntegrantes;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // lista para armazenar as funções encontradas no intervalo de datas
        List<String> funcoes = new ArrayList<>();

        // itera todos os times
        for (Time time : todosOsTimes) {
            // verifica se a data do time está dentro do intervalo
            if (!time.getData().isBefore(dataInicial) && !time.getData().isAfter(dataFinal)) {
                // itera a composição do time (jogadores desse time)
                for (ComposicaoTime composicao : time.getComposicaoTime()) {
                    // acessa o integrante do time e sua função
                    String funcao = composicao.getIntegrante().getFuncao();
                    // adiciona a função à lista
                    funcoes.add(funcao);
                }
            }
        }

        // variáveis para encontrar a franquia mais comum
        String funcaoMaisComum = null;
        int maxCount = 0;

        // contando as ocorrências de cada franquia
        for (String funcao : funcoes) {
            int count = 0;
            // conta quantas vezes essa franquia aparece na lista
            for (String f : funcoes) {
                if (f.equals(funcao)) {
                    count++;
                }
            }

            // atualiza se for a franquia mais comum
            if (count > maxCount) {
                maxCount = count;
                funcaoMaisComum = funcao;
            }
        }

        return funcaoMaisComum; // retorna o nome da franquia mais comum
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {

        // lista para armazenar as franquias encontradas no intervalo de datas
        List<String> franquias = new ArrayList<>();

        // itera todos os times
        for (Time time : todosOsTimes) {
            // verifica se a data do time está dentro do intervalo
            if (!time.getData().isBefore(dataInicial) && !time.getData().isAfter(dataFinal)) {
                // itera a composição do time (jogadores desse time)
                for (ComposicaoTime composicao : time.getComposicaoTime()) {
                    // acessa o integrante (jogador) e sua franquia
                    String franquia = composicao.getIntegrante().getFranquia();
                    // adiciona a franquia à lista
                    franquias.add(franquia);
                }
            }
        }

        // variáveis para encontrar a franquia mais comum
        String franquiaMaisComum = null;
        int maxCount = 0;

        // contando as ocorrências de cada franquia
        for (String franquia : franquias) {
            int count = 0;
            // conta quantas vezes essa franquia aparece na lista
            for (String f : franquias) {
                if (f.equals(franquia)) {
                    count++;
                }
            }

            // atualiza se for a franquia mais comum
            if (count > maxCount) {
                maxCount = count;
                franquiaMaisComum = franquia;
            }
        }

        return franquiaMaisComum; // retorna o nome da franquia mais comum
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
