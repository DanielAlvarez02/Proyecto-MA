package com.company;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    Timer temporizador = new Timer(); // nos permite contar intervalos de tiempo
    TareaDeTemporizador iterador; //nos permite hacer algo después de cierto intervalo de tiempo

    int tiempoDeActividad = 5; // tiempo de actividad en segundos
    int tiempoDeDescansoCorto = 1; // tiempo de descanso corto en segundos
    int tiempoDeDescansoLargo = 3; // tiempo de descanso largo en segundos
    int numeroDeCiclosParaDescansoLargo = 4; //Numero de ciclos que deben pasar para que se ejecute el tiempo largo de espera

    //Cuando se pausa el cronómetro debe crearse un nuevo iterador, por lo tanto se crearon las siguientes variables
    //para conservar el estado del objeto iterador.
    int segundosRestantesActuales = tiempoDeActividad;
    int cantidadDeCiclosActuales = 0;
    FaseDelPomodoro fase = FaseDelPomodoro.actividad;

    //Se inicia el cronómetro, creando un iterador y haciendo que se corra cada 1000ms (1 segundo)
    public void iniciar(){
        iterador= new TareaDeTemporizador(segundosRestantesActuales, cantidadDeCiclosActuales, fase);
        temporizador.scheduleAtFixedRate(iterador, 0, 1000);
    }

    //Se extrae el estado del iterador y postariormente se elimina del temporizador.
    public void pausar(){
        this.segundosRestantesActuales = iterador.getSegundosRestantes();
        this.cantidadDeCiclosActuales = iterador.getCantidadDeCiclos();
        this.fase = iterador.getFase();
        temporizador.cancel();
        temporizador.purge();
        iterador = null;
    }

    //Clase que tiene las acciones que van a ser ejecutadas por el Cronómetro
    class TareaDeTemporizador extends TimerTask {
        //El estado de esta clase se conforma del valor de sus atributos
        int segundosRestantes = tiempoDeActividad; //Segundos restantes del ciclo
        int cantidadDeCiclos = 0; // Cantidad de ciclos transcurridos
        FaseDelPomodoro fase = FaseDelPomodoro.actividad; //Fase actual del pomodoro (actividad, descanso largo, descanso corto)

        // Constructor que toma como entrada, los segundos restantes, cantidad de ciclos y fase
        // Este objeto sirve para crear un nuevo objeto con el mismo estado de otro objeto
        public TareaDeTemporizador(int segundosRestantes, int cantidadDeCiclos, FaseDelPomodoro fase){
            this.segundosRestantes = segundosRestantes;
            this.cantidadDeCiclos = cantidadDeCiclos;
            this.fase = fase;
        }

        //Este es el método que el cronómetro ejecuta cada 1 segundo


        // ****Por ahora solo imprime los segundos restantes y rota de fase****
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
                // rota la fase cuando el tiempo se termina... Ver los comentarios de rotar fase para más detalles
                rotarFase();
            }

        }


        // El método rota la fase, esto quiere decir que cuando acaba x tiempo sigue al siguiente tiempo.
        // Ejemplo:
        // Si en el primer ciclo el iterador está en la fase de actividad y se llama a este método,
        // el iterador va a pasar a la fase de ciclo corto

        public void rotarFase(){
            switch (fase){
                // si el iterador está en la fase de actividad:
                case actividad:
                    // se verifica si ya pasaron los ciclos suficientes para el descanso largo
                    if(cantidadDeCiclos % numeroDeCiclosParaDescansoLargo == 0){
                        // si sí: el tiempo pasa a ser el tiempo de descanso largo
                        segundosRestantes = tiempoDeDescansoLargo;
                        // y la fase pasa a ser la de descanso largo
                        fase = FaseDelPomodoro.descansoLargo;
                    }
                    else {
                        //si no han pasado los ciclos suficientes
                        //el tiempo pasa a ser el tiempo de descanso corto
                        segundosRestantes = tiempoDeDescansoCorto;
                        // y la fase pasa a ser la fase de descanso corto
                        fase = FaseDelPomodoro.desansoCorto;
                    }
                    break;
                case desansoCorto:
                case descansoLargo:
                    // Si el iterador está en la fase de descanso corto o largo
                    // los segundos restantes pasan a ser el tiempo de actividad
                    segundosRestantes = tiempoDeActividad;
                    // la fase pasa a ser la fase de actividad
                    fase = FaseDelPomodoro.actividad;
                    // aumenta la cantidad de ciclos
                    cantidadDeCiclos++;
                    break;
            }
        }

        //getters para el estado del iterador

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

    //fases del pomodoro: actividad, descanso corto y descanso largo
    enum FaseDelPomodoro{
        actividad, desansoCorto, descansoLargo;
    }
}

