package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;
import com.lpm.view.ViewParking;

import java.util.ArrayList;

public class ViewParkingController {
    private ViewParking view;
    private Estacionamento estacionamento;

    public ViewParkingController(ViewParking view, Estacionamento estacionamento) {this.view = view; this.estacionamento = estacionamento;}

    public ArrayList<Vaga> getVagas() {return estacionamento.getVagas();}

}
