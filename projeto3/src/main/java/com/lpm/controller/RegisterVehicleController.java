package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.UsoDeVaga;
import com.lpm.model.Veiculo;
import com.lpm.model.dao.ClienteDAO;
import com.lpm.model.dao.UsoDeVagaDAO;
import com.lpm.model.dao.VeiculoDAO;
import com.lpm.view.RegisterVehicle;
import com.lpm.view.ViewParking;

import java.util.Iterator;

public class RegisterVehicleController {
    RegisterVehicle view;
    Estacionamento estacionamentoAtual;

    public RegisterVehicleController(RegisterVehicle view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void registrarVeiculo(String placa, String cpfCliente) {
        Veiculo veiculo = new Veiculo(placa);
        Iterator<Cliente> iteratorClientes = estacionamentoAtual.getClientes().iterator();
        Cliente auxCliente;

        while(iteratorClientes.hasNext()) {
            auxCliente = iteratorClientes.next();

            if(auxCliente.getId().equalsIgnoreCase(cpfCliente)) {
                auxCliente.addVeiculo(veiculo);
                new VeiculoDAO().cadastrarVeiculo(veiculo, cpfCliente);
                view.dispose(); new ViewParking(estacionamentoAtual).setVisible(true);
            }
        }

    }
}
