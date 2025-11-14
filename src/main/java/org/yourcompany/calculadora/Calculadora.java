package org.yourcompany.calculadora;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            int opcio;
            
            do {
                mostrarMenuConsola();
                System.out.print("Selecciona una opció: ");
                opcio = entrada.nextInt();
                
                switch (opcio) {
                    case 1 -> {
                        System.out.print("Introdueix un nombre per sumar els primers n números: ");
                        int nSuma = entrada.nextInt();
                        System.out.println("La suma dels primers " + nSuma + " números és: " + sumaPrimersNumeros(nSuma));
                    }
                    case 2 -> {
                        System.out.print("Introdueix un nombre per calcular el factorial: ");
                        int nFactorial = entrada.nextInt();
                        System.out.println("El factorial de " + nFactorial + " és: " + calcularFactorial(nFactorial));
                    }
                    case 3 -> {
                        System.out.print("Introdueix un nombre per sumar els quadrats dels primers n números: ");
                        int nQuadrats = entrada.nextInt();
                        System.out.println("La suma dels quadrats dels primers " + nQuadrats + " números és: " + sumaQuadrats(nQuadrats));
                    }
                    case 4 -> {
                        System.out.print("Introdueix la base per calcular la potència: ");
                        int base = entrada.nextInt();
                        System.out.print("Introdueix l'exponent per calcular la potència: ");
                        int exponent = entrada.nextInt();
                        System.out.println(base + " elevat a la potència " + exponent + " és: " + calcularPotencia(base, exponent));
                    }
                    case 5 -> {
                        System.out.print("Introdueix un nombre per calcular el nombre de dígits: ");
                        int nombre = entrada.nextInt();
                        System.out.println("El nombre de dígits de " + nombre + " és: " + nombreDigits(nombre));
                    }
                    case 6 -> System.out.println("Sortint del programa...");
                    default -> System.out.println("Opció no vàlida. Intenta-ho de nou.");
                }
            } while (opcio != 6);
        }
    }

    /** 
    * Mostra el menú d'operacions
    */
    public static void mostrarMenuConsola() {
        System.out.println("\nMenú de SuperCalculadora:");
        System.out.println("1- Suma dels primers n números");
        System.out.println("2- Factorial d'un nombre");
        System.out.println("3- Suma dels quadrats dels primers n números");
        System.out.println("4- Potència d'un nombre");
        System.out.println("5- Nombre de dígits d'un nombre");
        System.out.println("6- Sortir");
    }

    /** 
    * Suma dels primers n números
    */
    public static int sumaPrimersNumeros(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }

    // Calcula el factorial d'un nombre
    public static int calcularFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
    * Suma dels quadrats dels primers n números
    */
    public static int sumaQuadrats(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i * i;
        }
        return suma;
    }

    /**
    * Calcula la potència d'un nombre
    */
    public static int calcularPotencia(int base, int exponent) {
        int potencia = 0;
        for (int i = 1; i <= exponent; i++) {
            potencia += base;
        }
        return potencia;
    }

    /**
    * Calcula el nombre de dígits d'un nombre
    */
    public static int nombreDigits(int n) {
        if (n == 0) return 1;
        n = Math.abs(n); // Fer que el nombre sigui positiu
        int comptador = 0;
        while (n != 0) {
            n /= 10;
            comptador++;
        }
        return comptador;
    }
}
