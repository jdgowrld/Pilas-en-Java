
import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class Main {
    static Scanner scan = new Scanner(System.in);


    static String ultimaInfija = "";
    static String ultimaPosfija = "";

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("- CONVERSOR INFIJA A POSFIJA -");
            System.out.println("1. Introducir expresión ");
            System.out.println("2. Mostrar ");
            System.out.println("3. Créditos ");
            System.out.println("4. Salir ");
            System.out.print("Elige una opción: ");

            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    introducirExpresion();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    creditos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa... ¡bye!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void introducirExpresion() {
        System.out.println("Ingresa la expresión Infija (máximo 50 caracteres):");
        String infija = scan.nextLine();

        // FILTRO DEFENSIVO:
        if (infija.contains("=")) {
            // Cortamos la cadena. Nos quedamos solo con lo que está DESPUÉS del signo igual
            infija = infija.substring(infija.indexOf("=") + 1).trim();
        }

        // Regla estricta del PDF: hasta 50 caracteres de largo
        if (infija.length() > 50) {
            System.out.println("¡Ay caramba! La expresión se pasa de 50 caracteres.");
            return;
        }

        ultimaInfija = infija;
        ultimaPosfija = Conversor.convertirAPosfija(infija);

        // Regla del PDF: Mostrar automáticamente el resultado al terminar
        System.out.println("Conversión terminada. Resultado Posfija: " + ultimaPosfija);
    }

    public static void mostrar() {
        if (ultimaInfija.isEmpty()) {
            System.out.println("Aún no has capturado nada.");
        } else {
            System.out.println("Última Infija: " + ultimaInfija);
            System.out.println("Última Posfija: " + ultimaPosfija);
        }
    }

    public static void creditos() {
        System.out.println("Materia: Estructuras de Datos");
        System.out.println("Desarrollado por: Juan Diego Arroyo Bucio.");
        System.out.println("Matrícula: 25420050");
    }




}