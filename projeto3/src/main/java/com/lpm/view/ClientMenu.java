package com.lpm.view;


import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMenu extends JFrame {

    private JButton btnCadastrar;
    private JPanel panel1;
    private JButton btnVeiculos;
    private JButton btnListagem;
    private JLabel labelClientes;
    private JButton btnVoltar;

    public ClientMenu(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        labelClientes.setText("Clientes (" + estacionamentoAtual.getNome() + ")");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterClient(estacionamentoAtual).setVisible(true);
            }
        });

        btnListagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new ListClient(estacionamentoAtual).setVisible(true);
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new HomeScreen(estacionamentoAtual).setVisible(true);
            }
        });
    }
}
