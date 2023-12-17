package com.lpm.view;

import javax.swing.*;

import com.lpm.controller.LoadParkingController;

public class LoadParking extends JFrame {
    private JPanel panel1;
    private JButton btnCarregar;
    private JTextField textField1;
    private JComboBox comboBoxEstacionamentos;
    private JLabel labelCarregarEstacionamento;
    private final LoadParkingController controller;

    public JComboBox getComboBoxEstacionamentos() {
        return comboBoxEstacionamentos;
    }

    public void setComboBoxEstacionamentos(JComboBox comboBoxEstacionamentos) {
        this.comboBoxEstacionamentos = comboBoxEstacionamentos;
    }

    public LoadParking() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);

        controller = new LoadParkingController(this);

        controller.carregarComboBox();

        btnCarregar.addActionListener(e -> {
            dispose();
            new HomeScreen(controller.carregarEstacionamento());
        });
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

}
