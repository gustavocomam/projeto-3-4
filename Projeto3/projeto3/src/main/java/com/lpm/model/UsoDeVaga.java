package com.lpm.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UsoDeVaga {

    private static double FRACAO_USO = 0.25;
    private static double VALOR_FRACAO = 4.0;
    private static double VALOR_MAXIMO = 50.0;

    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public UsoDeVaga(Vaga vaga) {

        if (vaga != null && vaga.disponivel()) {
            vaga.estacionar();
            this.vaga = vaga;
            entrada = LocalDateTime.now();
        } else {
            throw new Error("Erro: vaga ocupada / inexistente");
        }
    }

    public UsoDeVaga(Vaga vaga, LocalDateTime entrada, LocalDateTime saida) {
        this.vaga = vaga;
        this.entrada = entrada;
        this.saida = saida;
    }

    public boolean sair() {
        saida = LocalDateTime.now();

        vaga.sair();

        return true;
    }

    public double valorPago() {
        long tempoTotal;
        double precoEstimado;

        if (saida != null) {
            tempoTotal = ChronoUnit.HOURS.between(entrada, saida);

            precoEstimado = VALOR_FRACAO * (tempoTotal / FRACAO_USO);

            if (precoEstimado <= VALOR_MAXIMO) {
                return precoEstimado;
            } else {
                return VALOR_MAXIMO;
            }
        } else {
            throw new Error("Erro: o ocupante ainda nao saiu da vaga.");
        }
    }

}
