package org.yourcompany.calculadora;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Posa el teu nom
 */

public class Calculadora {

    public static void main(String[] args) {

        // Exemples de crida per al mètode nombreDigits
        System.out.println("Nombre de dígits de 1234: " + nombreDigits(1234));
        System.out.println("Nombre de dígits de 56789: " + nombreDigits(56789));
        System.out.println("Nombre de dígits de -101010: " + nombreDigits(-101010));
        System.out.println("Nombre de dígits de 0: " + nombreDigits(0));

        // --- Llançament de moneda ---
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIntrodueix el nombre de llançaments: ");
        int numLlançaments = entrada.nextInt();

        int[] resultats = simular(numLlançaments);

        System.out.println("\nResultat després de " + numLlançaments + " llançaments:");
        System.out.println("Cares: " + resultats[0]);
        System.out.println("Creus: " + resultats[1]);

        entrada.close();
    }

    /**
     * Calcula el nombre de dígits d’un número enter.
     * Funciona tant per a nombres positius com negatius.
     * Si el nombre és 0, retorna 1.
     *
     * @param nombre Número del qual es vol saber el nombre de dígits
     * @return Quantitat de dígits que té {@code nombre}
     */
    public static int nombreDigits(int nombre) {
        if (nombre == 0) {
            return 1; // el 0 té un dígit
        }        

        // Passem a positiu si és negatiu
        nombre = Math.abs(nombre);

        int comptador = 0;
        while (nombre != 0) {
            nombre /= 10;
            comptador++;
        }
        return comptador;
    }

    /**
     * Simula el llançament d'una moneda el nombre de vegades indicat.
     * @param numLlançaments Nombre de llançaments
     * @return Array amb dos valors: [nombre de cares, nombre de creus]
     */
    public static int[] simular(int numLlançaments) {
        Random random = new Random();
        int cares = 0;
        int creus = 0;

        for (int i = 0; i < numLlançaments; i++) {
            int resultat = random.nextInt(2); // 0 = cara, 1 = creu
            if (resultat == 0) {
                cares++;
            } else {
                creus++;
            }
        }

        return new int[]{cares, creus};
    }
}
