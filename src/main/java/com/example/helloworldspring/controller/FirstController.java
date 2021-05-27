package com.example.helloworldspring.controller;

import com.example.helloworldspring.model.*;
import com.example.helloworldspring.service.DataInAge;
import com.example.helloworldspring.service.Morse;
import com.example.helloworldspring.service.NumerosRomanos;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FirstController {

    @GetMapping(path = "/romano/{number}")
    public String numeroRomano(@PathVariable String number) {
        int numero = Integer.parseInt(number);
        return NumerosRomanos.converterEmRomanos(numero);

    }
    @GetMapping(path = "/morse/{morse}")
    public String conversorDeMorse(@PathVariable String morse){
        return Morse.normal(morse);
    }

    @GetMapping(path = "/{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) throws Exception {
        return DataInAge.dataInAge(day, month, year).toString();
    }

    @PostMapping(path = "/casa")
    public DadosCasa dadosCasa(@RequestBody Casa casa){
       double totalM2 = casa.totalMetrosQuadrados();
       double valorCasa = casa.valorDaCasa();
       Comodo maiorComodo = casa.maiorComodo();
       Map<String, Double> metrosQuadradosPorComodo = casa.metrosQuadradosPorComodo();

       return new DadosCasa(casa.getNome(), totalM2, valorCasa, maiorComodo, metrosQuadradosPorComodo);
    }

    @PostMapping(path = "/diploma")
    public Diploma obterDiploma(@RequestBody Aluno aluno){
        double media = aluno.mediaAluno();
        boolean alunoExcelente = media>=9.0;
        String mensagem = "Certifico que o aluno " + aluno.getNome() + " obteve o diploma de Bacharel em Ciência da Computação.";
        if(alunoExcelente){
            mensagem+=  "Fazemos uma menção honrosa pelo excelente rendimento apresentado no curso, demonstrado através do coeficiente " + media;
        }

        return new Diploma(aluno.getNome(), mensagem, media);
    }
}
