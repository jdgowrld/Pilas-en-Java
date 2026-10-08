/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class Pila {
    private char[] arregloPila;
    private int MAX;
    private int TOP;

    public Pila(int M) {
        this.MAX = M;
        this.arregloPila = new char[MAX];
        this.TOP = -1; // El -1 indica que está vacía al iniciar
    }

    // Método Push: Mete un dato
    public void Push(char v) {
        if (TOP == MAX - 1) { // Si ya llegó al límite (índice 11)
            System.out.println("Stack Overflow");
        } else {
            TOP = TOP + 1;
            arregloPila[TOP] = v;
        }
    }

    // Método Pop: Saca un dato
    public char Pop() {
        if (TOP == -1) {
            System.out.println("Stack Underflow");
            return '$'; // Retornamos un carácter 'basura' para no tronar el programa
        } else {
            TOP = TOP - 1;
            return arregloPila[TOP + 1]; // Borrado lógico: bajamos el piso y retornamos el de arriba
        }
    }


    // verTope: Nos deja asomarnos a ver qué operador está hasta arriba sin sacarlo con Pop.
    // Lo vamos a necesitar a fuerza para comparar jerarquías en la Regla 3.
    public char verTope() {
        if (TOP == -1) {
            return '$';
        }
        return arregloPila[TOP];
    }

    // estaVacia: Nos dice si la pila ya no tiene elementos.
    // Útil para vaciar la pila al final de la expresión.
    public boolean estaVacia() {
        return TOP == -1;
    }
}