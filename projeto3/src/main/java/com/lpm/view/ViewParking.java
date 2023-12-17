package com.lpm.view;

import com.lpm.controller.ViewParkingController;
import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ViewParking extends JFrame {
    private JLabel nomeEstacionamento;
    private JButton btnReturn;
    private final ViewParkingController controller;

    public ViewParking(Estacionamento estacionamentoAtual) {
        int counter = 0;
        controller = new ViewParkingController(this, estacionamentoAtual);
        nomeEstacionamento.setHorizontalAlignment(SwingConstants.CENTER);
        nomeEstacionamento.setText("Painel de vagas " + estacionamentoAtual.getNome());
        setTitle(estacionamentoAtual.getNome());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painelVagas = new JPanel(new GridLayout(estacionamentoAtual.getQuantFileiras(), estacionamentoAtual.getVagasPorFileira()));

        for(int i = 0; i < estacionamentoAtual.getQuantFileiras(); i++) {
            for(int j = 0; j < estacionamentoAtual.getVagasPorFileira(); j++) {
                painelVagas.add(criarVaga(controller.getVagas().get(counter), estacionamentoAtual));
                counter++;
            }
        }
        add(painelVagas);
        add(btnReturn, BorderLayout.AFTER_LAST_LINE);
        add(nomeEstacionamento, BorderLayout.BEFORE_FIRST_LINE);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new HomeScreen(estacionamentoAtual).setVisible(true);
            }
        });
    }

    private JPanel criarVaga(Vaga vaga, Estacionamento estacionamentoAtual) {
        JPanel result = new JPanel();
        result.add(btnReturn);
        result.setPreferredSize(new Dimension(25, 25)); // Tamanho da vaga

        if(vaga.disponivel()) {
            result.setBackground(Color.GREEN); // Caso disponivel, vaga setada para green
        } else {
            result.setBackground(Color.RED); // Caso contrario, vaga setada para red
        }

        result.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borda preta para destacar as vagas

        result.add(new JLabel(vaga.getId()), SwingConstants.CENTER);

        result.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                if(result.getBackground() == Color.GREEN) {
                    new RegisterSpot(estacionamentoAtual, vaga).setVisible(true);
                } else if (result.getBackground() == Color.RED) {
                    new InfoSpot(estacionamentoAtual, vaga).setVisible(true);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return result;
    }
}
