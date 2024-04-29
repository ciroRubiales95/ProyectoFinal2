package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //contadores de jugadores y clase main
    static int counter1 = 0;
    static int counter2 = 0;
    public static void main(String[] args) {
        //explicamos las reglas y llamamos a la función round
        System.out.println("Piedra, papel o tijera:");
        System.out.println("Reglas: Cada jugador introducirá un valor\n" +
                        "númerico entre 1 y 3 por cada jugada.");
        System.out.println("Piedra -> 1\n" +
                "Tijeras -> 2\n" +
                "Papel -> 3" + "\n");
        System.out.println("Gana el jugador que alcance tres puntos");
        round();
    }

    private static void round() {
        //Marcador
        System.out.println("Marcador\n" + "Jugador 1 = " + counter1 + "\n" + "Jugador 2 = " + counter2 + "\n");
        //Mensaje final de partida
        if (counter1 == 3) {
            System.out.println("Gana el Jugador 1");
        } else if (counter2 == 3) {
            System.out.println("Gana el Jugador 2");
        }
        //Bucle principal de juego. Termina cuando algún jugador llega a 3.
        while (counter1 < 3 && counter2 < 3) {
            Scanner teclado = new Scanner(System.in);
            //turnos de jugadores. se estudia que las entrada esperada en el rango 1 - 3
            try {
                System.out.println("Jugador 1, introduzca su jugada:");
                int game1 = teclado.nextInt();
                System.out.println("Jugador 2, introduzca su jugada:");
                int game2 = teclado.nextInt();
                if (game1 < 1 || game1 > 3 || game2 < 1 || game2 > 3) {
                    throw new InputMismatchException("Ingresa número válido (1, 2 o 3): ");
                }
                //se llama a la lógica del juego para determinar el resultado de la ronda
                logica(game1, game2);
            } catch (InputMismatchException e) {
                System.err.println("Error: " + e.getMessage());
                teclado.nextLine();
            }
        }

    }
    //lógica del juego
    private static void logica( int game1, int game2) {
        //situación de empate
        if (game1 == game2) {
            System.out.println("Empate");
        //game condition jugador 1
        } else if ((game1 == 1 && game2 == 2) || (game1 == 2 && game2 == 3) || (game1 == 3 && game2 == 1)) {
            System.out.println("Jugador 1 --> +1");
            counter1++;
        //si pierde jugador 1 y no es empate
        } else {
            System.out.println("Jugador 2 --> +1");
            counter2++;
        }
        //iniciamos una nueva ronda
        round();
    }

}