package com.lpm.view;

import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    private JPanel panel1;
    private JButton visaoGeralDoEstacionamentoButton;
    private JButton estatisticasButton;
    private JButton clientesButton;

    public HomeScreen(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        visaoGeralDoEstacionamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewParking(estacionamentoAtual).setVisible(true);
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ClientMenu(estacionamentoAtual).setVisible(true);
            }
        });

        setVisible(true);
        estatisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new StatisticsMenu(estacionamentoAtual).setVisible(true);
            }
        });
    }
}
