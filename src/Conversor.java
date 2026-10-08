/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class Conversor {

    public static int jerarquia(char operador) {
        if (operador == '^') return 3;
        if (operador == '*' || operador == '/') return 2;
        if (operador == '+' || operador == '-') return 1;
        return 0;
    }

    public static String convertirAPosfija(String infija) {
        // Regla Pila de tamaño 12 solamente
        Pila pila = new Pila(12);
        String posfija = ""; // Aquí iremos armando la salida (EP)

        // Recorremos la expresión Infija letra por letra
        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            // Ignoramos los espacios en blanco
            if (c == ' ') continue;

            // REGLA 4 DEL PIZARRÓN: Si c == Letra || Digito => EP
            // Se va directo a la cadena de respuesta sin tocar la pila
            if (Character.isLetterOrDigit(c) || c == '.') {
                posfija += c;
            }
            // REGLA 1 DEL PIZARRÓN: Si c == '(' => Push(c)
            else if (c == '(') {
                pila.Push(c);
            }
            // REGLA 2 DEL PIZARRÓN: Si c == ')' => Pop() hasta '(' => EP
            else if (c == ')') {
                // Sacamos operadores de la pila a la salida hasta topar con el '('
                while (!pila.estaVacia() && pila.verTope() != '(') {
                    posfija += pila.Pop();
                }
                // Sacamos el '(' de la memoria de la pila, pero NO lo guardamos en la salida
                if (!pila.estaVacia() && pila.verTope() == '(') {
                    pila.Pop();
                }
            }
            // REGLA 3 DEL PIZARRÓN: Si c == Operador (+ - * / ^)
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // "Push(c) Si c > Pop() Si no Pop() => EP"
                // Traducido a memoria: Mientras el operador de la pila tenga MAYOR o IGUAL jerarquía,
                // lo sacamos (Pop) y lo mandamos a la salida (EP).
                while (!pila.estaVacia() && pila.verTope() != '(' && jerarquia(c) <= jerarquia(pila.verTope())) {
                    posfija += pila.Pop();
                }
                //  metemos el operador actual a la pila
                pila.Push(c);
            }
        }

        // PASO FINAL: Si ya leímos toda la expresión, pero quedaron operadores,
        // les hacemos Pop() a todos y los pegamos al final.
        while (!pila.estaVacia()) {
            posfija += pila.Pop();
        }

        return posfija; // Ahora sí, retornamos la conversión completa
    }
}