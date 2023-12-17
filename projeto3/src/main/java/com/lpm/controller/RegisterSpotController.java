package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;
import com.lpm.model.dao.UsoDeVagaDAO;
import com.lpm.model.dao.VagaDAO;
import com.lpm.model.dao.VeiculoDAO;
import com.lpm.view.RegisterSpot;
import com.lpm.view.RegisterVehicle;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegisterSpotController {
    private RegisterSpot view;
    private Estacionamento estacionamentoAtual;

    public RegisterSpotController(RegisterSpot view, Estacionamento estacionamentoAtual) {
        this.view = view;
        this.estacionamentoAtual = estacionamentoAtual;
    }

    public boolean registrar(String placa, String idVaga) {
        if(new VeiculoDAO().veiculoRegistrado(placa)) {
            if (!new UsoDeVagaDAO().estaEstacionado(placa)) {
                new UsoDeVagaDAO().cadastrarUsoDeVaga(estacionamentoAtual.estacionar(placa, idVaga), estacionamentoAtual.getNome(), placa);
                new VagaDAO().atualizarEstadoVaga(idVaga, estacionamentoAtual.getNome());
                return true;
            } else {
                view.exibeMensagem("Erro: Veículo já se encontra estacionado. Tente novamente!");
                view.getTextFieldPlaca().setText("");
                return false;
            }
        } else {
            if(view.exibeDialogo("Placa não encontrada na base de dados. Deseja registrar um novo veículo?") == JOptionPane.YES_OPTION) {
                new RegisterVehicle(estacionamentoAtual, placa).setVisible(true);
            }
            return false;
        }
    }
}
