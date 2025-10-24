package org.yourcompany.calculadora;
import java.util.Random;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        System.out.println("Nombre de dígits de 1234: " + nombreDigits(1234));
        System.out.println("Nombre de dígits de 56789: " + nombreDigits(56789));
        System.out.println("Nombre de dígits de -101010: " + nombreDigits(-101010));
        System.out.println("Nombre de dígits de 0: " + nombreDigits(0));

        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIntrodueix el nombre de llançaments: ");
        int numLlançaments = entrada.nextInt();

        int[] resultats = simular(numLlançaments);

        System.out.println("\nResultat després de " + numLlançaments + " llançaments:");
        System.out.println("Cares: " + resultats[0]);
        System.out.println("Creus: " + resultats[1]);

        System.out.print("\nIntrodueix el preu base de l’entrada: ");
        double preuBase = entrada.nextDouble();

        System.out.print("És cap de setmana? (true/false): ");
        boolean capSetmana = entrada.nextBoolean();

        System.out.print("Té Carnet Jove? (true/false): ");
        boolean carnetJove = entrada.nextBoolean();

        double preuFinal = preuCinema(preuBase, capSetmana, carnetJove);
        System.out.println("\nEl preu final de l’entrada és: " + preuFinal + " €");

        entrada.close();
    }

    public static int nombreDigits(int nombre) {
        if (nombre == 0) return 1;
        nombre = Math.abs(nombre);
        int comptador = 0;
        while (nombre != 0) {
            nombre /= 10;
            comptador++;
        }
        return comptador;
    }

    public static int[] simular(int numLlançaments) {
        Random random = new Random();
        int cares = 0;
        int creus = 0;
        for (int i = 0; i < numLlançaments; i++) {
            int resultat = random.nextInt(2);
            if (resultat == 0) cares++;
            else creus++;
        }
        return new int[]{cares, creus};
    }

    public static double preuCinema(double preuBase, boolean capSetmana, boolean carnetJove) {
        double preuFinal = preuBase;
        if (capSetmana) preuFinal *= 1.10;
        if (carnetJove) preuFinal *= 0.85;
        return preuFinal;
    }
}

