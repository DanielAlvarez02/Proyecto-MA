package com.company;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    Timer temporizador = new Timer();
    IteradorPomodoro iterador;

    int tiempoDeActividad = 5; // tiempo de actividad en segundos
    int tiempoDeDescansoCorto = 1; // tiempo de descanso corto en segundos
    int tiempoDeDescansoLargo = 3; // tiempo de descanso largo en segundos
    int numeroDeCiclosParaDescansoLargo = 3;

    int segundosRestantesActuales = tiempoDeActividad;
    int cantidadDeCiclosActuales = 0;
    FaseDelPomodoro fase = FaseDelPomodoro.actividad;

    public void iniciar(){
        iterador= new IteradorPomodoro(segundosRestantesActuales, cantidadDeCiclosActuales, fase);
        temporizador.scheduleAtFixedRate(iterador, 0, 1000);
    }

    public void pausar(){
        this.segundosRestantesActuales = iterador.getSegundosRestantes();
        this.cantidadDeCiclosActuales = iterador.getCantidadDeCiclos();
        this.fase = iterador.getFase();
        temporizador.cancel();
        temporizador.purge();
    }


    class IteradorPomodoro extends TimerTask {
        int segundosRestantes = tiempoDeActividad;
        int cantidadDeCiclos = 0;
        FaseDelPomodoro fase = FaseDelPomodoro.actividad;


        public IteradorPomodoro(int segundosRestantes, int cantidadDeCiclos, FaseDelPomodoro fase){
            this.segundosRestantes = segundosRestantes;
            this.cantidadDeCiclos = cantidadDeCiclos;
            this.fase = fase;
        }


        @Override
        public void run() {
            if(segundosRestantes > 0){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Segundos restantes: " + segundosRestantes +"\nEscriba p para pausar");
                Scanner scanner = new Scanner(System.in);
                if(scanner.next().equals("p")){
                    pausar();
                }
                segundosRestantes--;
            }
            else{
                rotarTarea();
            }

        }

        public void rotarTarea(){
            switch (fase){
                case actividad:
                    if(cantidadDeCiclos % numeroDeCiclosParaDescansoLargo == 0){
                        segundosRestantes = tiempoDeDescansoLargo;
                        fase = FaseDelPomodoro.descansoLargo;
                    }
                    else {
                        segundosRestantes = tiempoDeDescansoCorto;
                        fase = FaseDelPomodoro.desansoCorto;
                    }
                    break;
                case desansoCorto:
                case descansoLargo:
                    segundosRestantes = tiempoDeActividad;
                    fase = FaseDelPomodoro.actividad;
                    cantidadDeCiclos++;
                    break;
            }
        }

        public int getSegundosRestantes() {
            return segundosRestantes;
        }

        public int getCantidadDeCiclos() {
            return cantidadDeCiclos;
        }

        public FaseDelPomodoro getFase() {
            return fase;
        }
    }

    enum FaseDelPomodoro{
        actividad, desansoCorto, descansoLargo;
    }
}

