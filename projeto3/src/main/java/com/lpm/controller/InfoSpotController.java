package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;
import com.lpm.model.dao.UsoDeVagaDAO;
import com.lpm.model.dao.VagaDAO;
import com.lpm.view.InfoSpot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class InfoSpotController {
    InfoSpot view;
    Estacionamento estacionamentoAtual;

    public InfoSpotController(InfoSpot view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void buscarDadosUsoAtual(String idVaga) {
        String[] dados = new UsoDeVagaDAO().consultarInfoUsoAtual(idVaga, estacionamentoAtual.getNome());

        view.getLabelVeiculo().setText(dados[0]);
        view.getLabelEntrada().setText(dados[1]);
    }

    public void registrarSaida(String idVaga) {
        double aPagar;
        aPagar = estacionamentoAtual.procurarVeiculo(view.getLabelVeiculo().getText()).sair();

        // update nas tabelas
        new VagaDAO().atualizarEstadoVaga(idVaga, estacionamentoAtual.getNome());
        new UsoDeVagaDAO().registrarSaida(view.getLabelVeiculo().getText(), view.getLabelEntrada().getText(), LocalDateTime.now().toString());

        view.exibeMensagem("Vaga liberada! Faça a cobrança de R$" + aPagar + " ao cliente");
    }
}
