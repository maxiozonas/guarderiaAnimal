import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// Cosas para hacer: condicional en ingresarAnimal para verificar que el tipo de animal ingresado sea correcto desde un principio
// Corregir mojarritas en el momento de ingresar animal, para dar solo dos opciones (agua fria o agua caliente),
//
public class GuarderiaAnimal {
    public static void main(String[] args) {

        ArrayList<Animal> listaAnimales = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // Menu de opciones por consola, usando un ciclo While y Switch
        while (opcion != 0) {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Ingresar animal a la guardería");
            System.out.println("2 - Retirar animal de la guardería");
            System.out.println("3 - Calcular cantidad de animales en la guardería");
            System.out.println("4 - Listar todos los animales con sus datos");
            System.out.println("5 - Hacer saludar a todos los animales");
            System.out.println("0 - Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Animal.ingresarAnimal(listaAnimales);
                    break;
                case 2:
                    Animal.removerAnimal(listaAnimales);
                    break;
                case 3:
                    Animal.contarAnimales(listaAnimales);
                    break;
                case 4:
                    Animal.listarAnimales(listaAnimales);
                    break;
                case 5:
                    Animal.saludar(listaAnimales);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor ingrese una opción válida.");
                    break;
            }
        }
    }
}