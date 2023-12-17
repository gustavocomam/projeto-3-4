package com.lpm.view;

import com.lpm.controller.RegisterVehicleController;
import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterVehicle extends JFrame {

    private JPanel panel1;
    private JTextField textFieldPlaca;
    private JButton btnCadastrar;
    private JLabel labelPlaca;
    private JTextField textFieldCpfCliente;
    private JLabel labelCpfCliente;
    private final RegisterVehicleController controller;

    public RegisterVehicle(Estacionamento estacionamentoAtual, String placa) {
        this.controller = new RegisterVehicleController(this, estacionamentoAtual);

        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textFieldPlaca.setText(placa);
        textFieldPlaca.setEnabled(false);

        add(panel1);


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registrarVeiculo(placa, textFieldCpfCliente.getText());
            }
        });
    }

}
