package com.company;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static Timer timer = new Timer();
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        cronometro.iniciarCiclos();
    }
}
