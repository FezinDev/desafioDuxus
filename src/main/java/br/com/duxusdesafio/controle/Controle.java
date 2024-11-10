package br.com.duxusdesafio.controle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;

@RestController
public class Controle {

    @Autowired
    private ApiService api;

    // Endpoint para buscar a contagem de franquias no intervalo de datas
    // @GetMapping("/api/contagem-franquias")
    // public Map<String, Long> contagemFranquias(
    //         @RequestParam("dataInicial") String dataInicial,
    //         @RequestParam("dataFinal") String dataFinal) {

    //     // Convertendo as strings de data para LocalDate
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     LocalDate inicio = LocalDate.parse(dataInicial, formatter);
    //     LocalDate fim = LocalDate.parse(dataFinal, formatter);

    //     // Chama o serviço para obter a contagem das franquias
    //     return api.contagemPorFranquia(inicio, fim);
    // }

    //@CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/contagem-franquias/{dataInicial}/{dataFinal}")
    public Map<String, Long> contagemFranquias(
            @PathVariable String dataInicial,
            @PathVariable String dataFinal) {

        // Convertendo as strings de data para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        // Chama o serviço para obter a contagem das franquias
        return api.contagemPorFranquia(inicio, fim);
    }

    @GetMapping("/api/contagem-funcoes")
    public Map<String, Long> contagemFuncoes(@RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        return api.contagemPorFuncao(inicio, fim);

    }

    @GetMapping("/api/time-mais-comum")
    public List<String> timeComum(@RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        return api.timeMaisComum(inicio, fim);
    }

    @GetMapping("/api/franquia-mais-famosa")
    public String franquiaMaisFamosa(@RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        return api.franquiaMaisFamosa(inicio, fim);
    }

    @GetMapping("/api/funcao-mais-comum")
    public String funcaoMaisComum(@RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        return api.funcaoMaisComum(inicio, fim);
    }

    @GetMapping("/api/jogador-mais-usado")
    public String integranteMaisUsado(@RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);

        return api.integranteMaisUsado(inicio, fim).getNome();

    }

    @GetMapping("/api/time-da-data")
    public List timeDaData(@RequestParam("dataInicial") String dataInicial) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(dataInicial, formatter);
        Time time = api.timeDaData2(inicio);

        List<ComposicaoTime> lista = time.getComposicaoTime();
        List<String> nomes = new ArrayList<>();
        

        return lista;

    }

}
