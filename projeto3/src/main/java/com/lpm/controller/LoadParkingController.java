package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.dao.ClienteDAO;
import com.lpm.model.dao.EstacionamentoDAO;
import com.lpm.model.dao.VagaDAO;
import com.lpm.view.LoadParking;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadParkingController {
    private final LoadParking view;

    public LoadParkingController(LoadParking view) {
        this.view = view;
    }

    public Estacionamento carregarEstacionamento() {
        String nome = view.getComboBoxEstacionamentos().getSelectedItem().toString();

        if(nome != null) {
            Estacionamento estacionamentoAtual = new EstacionamentoDAO().lerEstacionamento(nome);

            view.exibeMensagem(nome + " lido com sucesso!\n");

            return estacionamentoAtual;
        } else {
            throw new Error("Erro: selecao invalida!");
        }
    }

    public void carregarComboBox() {
        ArrayList<String> nomesEstacionamentos;
        JComboBox auxComboBox = view.getComboBoxEstacionamentos();

        nomesEstacionamentos = new EstacionamentoDAO().lerNomesEstacionamentos();

        Iterator<String> iteratorNomes = nomesEstacionamentos.iterator();

        while(iteratorNomes.hasNext()) {
            auxComboBox.addItem(iteratorNomes.next());
        }
    }
}
