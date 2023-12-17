package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.UsoDeVaga;
import com.lpm.model.Veiculo;
import com.lpm.model.dao.VeiculoDAO;
import com.lpm.view.ListClient;
import com.lpm.view.ListVehicles;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ListVehiclesController {
    private Estacionamento estacionamentoAtual;
    private ListVehicles view;
    public ListVehiclesController(ListVehicles view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void popularTabela(DefaultTableModel tableModel, String cpfCliente) {
        Veiculo auxVeiculo;
        ArrayList<Veiculo> auxVeiculos;
        ArrayList<UsoDeVaga> auxUsosVeiculo;
        UsoDeVaga auxUltimoUso;

        auxVeiculos = new VeiculoDAO().lerVeiculos(cpfCliente, estacionamentoAtual.getNome());

        Iterator<Veiculo> iteratorVeiculos = auxVeiculos.iterator();

        while (iteratorVeiculos.hasNext()) {
            auxVeiculo = iteratorVeiculos.next();
             auxUsosVeiculo = auxVeiculo.getUsos();
             if (!auxUsosVeiculo.isEmpty()) {
                 auxUltimoUso = auxUsosVeiculo.get(auxUsosVeiculo.size() - 1);
                 if (auxUltimoUso.getSaida() == null) {
                     tableModel.addRow(new Object[]{auxVeiculo.getPlaca(), auxUltimoUso.getVaga().getId() + ", " + estacionamentoAtual.getNome()});
                 } else {
                     tableModel.addRow(new Object[]{auxVeiculo.getPlaca(), "-"});
                 }
             } else {
                 tableModel.addRow(new Object[]{auxVeiculo.getPlaca(), "-"});
             }
        }
    }
}
