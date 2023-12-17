package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.Veiculo;
import com.lpm.view.RegisterClient;

import javax.swing.*;
import java.util.ArrayList;

public class RegisterClientController {
    private RegisterClient view;
    private Estacionamento estacionamentoAtual;

    public RegisterClientController(RegisterClient view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void registrarCliente() {
        estacionamentoAtual.addCliente(new Cliente(view.getTextId().getText(), view.getTextName().getText(), new ArrayList<Veiculo>()));
    }
}
