package com.company;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    //configuración del pomodoro
    private int tiempoDeActividad; // tiempo de actividad en segundos
    private int tiempoDeDescansoCorto; // tiempo de descanso corto en segundos
    private int tiempoDeDescansoLargo; // tiempo de descanso largo en segundos
    private int numeroDeCiclosParaDescansoLargo = 4;

    // estado del pomodoro
    private FaseDelPomodoro faseDelPomodoroActual;
    private int segundosRestantes;
    private int cantidadDeCiclosTranscurridos;

    public Cronometro() {
        this.tiempoDeActividad = 25*60;
        this.tiempoDeDescansoCorto = 5*60;
        this.tiempoDeDescansoLargo = 15*60;
        this.numeroDeCiclosParaDescansoLargo = 5;
        this.faseDelPomodoroActual = FaseDelPomodoro.actividad;
        this.segundosRestantes = tiempoDeActividad;
        this.cantidadDeCiclosTranscurridos = 0;
    }

    public void iniciarCiclos(){

        Scanner sc = new Scanner(System.in);
        String input = "";
        Timer temporizador = new Timer();
        temporizador.schedule( obtenerNuevaTarea(),0,1*1000 );

        boolean running = true;
        while(true){
            input = sc.nextLine();
            if( input.equals("p") )
            {
                running = false;
                temporizador.cancel();
                temporizador.purge();
            }
            if( input.equals("c") && running == false)
            {
                running = true;
                temporizador = new Timer();
                temporizador.schedule( obtenerNuevaTarea(),0,1*1000 );
            }
            if(input.equals("q")) return;
        }
    }

    public void pausarCiclos(){

    }

    private TimerTask obtenerNuevaTarea(){
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(segundosRestantes <= 0) rotarFase();;
                segundosRestantes--;
                imprimirMensaje();
            }
        };
        return tarea;
    }

    private void imprimirMensaje(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Segundos restantes: " + segundosRestantes
                +"\nEscriba \"p\" para pausar"
                +"\nO escriba \"q\" para salir del programa\n");
    }

    private void rotarFase() {
        switch (faseDelPomodoroActual) {
            //Cambia al descanso largo si ya pasaron los ciclos necesarios
            case actividad:
                if (cantidadDeCiclosTranscurridos % numeroDeCiclosParaDescansoLargo == 0) {
                    segundosRestantes = tiempoDeDescansoLargo;
                    faseDelPomodoroActual = FaseDelPomodoro.descansoLargo;
                } else {
                    segundosRestantes = tiempoDeDescansoCorto;
                    faseDelPomodoroActual = FaseDelPomodoro.desansoCorto;
                }
                break;
            // Cambia a actividad después del descanso
            case desansoCorto:
            case descansoLargo:
                segundosRestantes = tiempoDeActividad;
                faseDelPomodoroActual = FaseDelPomodoro.actividad;
                cantidadDeCiclosTranscurridos++;
                break;
        }
    }

    // Setters

    public void modificarTiempoDeActividad(int tiempoDeActividad) {
        this.tiempoDeActividad = tiempoDeActividad;
    }

    public void modificarTiempoDeDescansoCorto(int tiempoDeDescansoCorto) {
        this.tiempoDeDescansoCorto = tiempoDeDescansoCorto;
    }

    public void modificarTiempoDeDescansoLargo(int tiempoDeDescansoLargo) {
        this.tiempoDeDescansoLargo = tiempoDeDescansoLargo;
    }

    public void modificarNumeroDeCiclosParaDescansoLargo(int numeroDeCiclosParaDescansoLargo) {
        this.numeroDeCiclosParaDescansoLargo = numeroDeCiclosParaDescansoLargo;
    }

    public int getTiempoDeActividad() {
        return tiempoDeActividad;
    }

    public int getTiempoDeDescansoCorto() {
        return tiempoDeDescansoCorto;
    }

    public int getTiempoDeDescansoLargo() {
        return tiempoDeDescansoLargo;
    }

    public int getNumeroDeCiclosParaDescansoLargo() {
        return numeroDeCiclosParaDescansoLargo;
    }

    public FaseDelPomodoro getFaseDelPomodoroActual() {
        return faseDelPomodoroActual;
    }

    public int getSegundosRestantes() {
        return segundosRestantes;
    }

    public int getCantidadDeCiclosTranscurridos() {
        return cantidadDeCiclosTranscurridos;
    }


// Enum para la fase del pomodoro

    private enum FaseDelPomodoro{
        actividad, desansoCorto, descansoLargo;
    }
}

