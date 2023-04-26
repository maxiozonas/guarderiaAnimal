import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

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
                    ingresarAnimal(listaAnimales);
                    break;
                case 2:
                    // código para retirar animal
                    break;
                case 3:
                    // código para calcular cantidad de animales
                    break;
                case 4:
                    // código para listar animales
                    break;
                case 5:
                    // código para hacer saludar a los animales
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

    public static void ingresarAnimal(ArrayList<Animal> listaAnimales) {
        Scanner scanner = new Scanner(System.in);
        Animal animal = null;
        // Datos del perro
        System.out.println("Ingrese el tipo de animal: ");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad del animal: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el sexo (macho o hembra): ");
        Sexo sexo = Sexo.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Ingrese el peso del animal (Gramos): ");
        int peso = scanner.nextInt();
        scanner.nextLine();

        // Ahora los datos del Dueno
        System.out.println("Ingrese los DNI del dueño: ");
        String dni = scanner.nextLine();

        System.out.println("Ingrese el nombre del dueño: ");
        String nombreDueño = scanner.nextLine();

        System.out.println("Ingrese la direccino del dueño: ");
        String direccion = scanner.nextLine();


        switch (tipo.toLowerCase()) {
            case "perro":
                System.out.println("Ingrese la raza del perro: ");
                String raza = scanner.nextLine();
                animal = new Perro(nombre, edad, new Dueño(dni, nombreDueño, direccion), sexo, peso, raza);
                break;
            case "gato":
                animal = new Gato(nombre, edad, new Dueño(dni, nombreDueño, direccion), sexo, peso);
                break;
            case "hamster":
                animal = new Hamster(nombre, edad, new Dueño(dni, nombreDueño, direccion), sexo, peso);
                break;
            case "mojarrita":
                System.out.println("Ingrese el tipo de agua de la mojarrita: ");
                String tipoAgua = scanner.nextLine();
                animal = new Mojarrita(nombre, edad, new Dueño(dni, nombreDueño, direccion), sexo, peso, tipoAgua);
                break;
            default:
                System.out.println("Tipo de animal inválido.");
        }
        listaAnimales.add(animal);
    }
}