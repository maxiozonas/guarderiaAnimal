import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Animal {
    // Atributos
    protected String nombre;
    protected int edad;
    protected Dueño dueño;
    protected Sexo sexo;
    protected int peso;

    // Constructores, Getters y Setters

    public Animal(String nombre, int edad, Dueño dueño, Sexo sexo, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dueño = dueño;
        this.sexo = sexo;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dueño=" + dueño +
                ", sexo=" + sexo +
                ", peso=" + peso +
                '}';
    }

    // Metodos
    public static void saludar(List<Animal> listaAnimales) {
        for (Animal animal : listaAnimales) {
            System.out.println("Hola me llamo " + animal.nombre + " y soy un " + animal.getClass().getSimpleName());
        }
    }

    public static void ingresarAnimal(ArrayList<Animal> listaAnimales) {
        Scanner scanner = new Scanner(System.in);
        Animal animal = null;
        // Datos del perro
        String tipo;
        do {
            System.out.println("Ingrese el tipo de animal: ");
            tipo = scanner.nextLine();
            tipo = tipo.toLowerCase();
            if (!(tipo.equals("perro") || tipo.equals("gato") || tipo.equals("hamster") || tipo.equals("mojarrita"))) {
                System.out.println("Tipo de animal inválido. Intente de nuevo.");
            }
        } while (!(tipo.equals("perro") || tipo.equals("gato") || tipo.equals("hamster") || tipo.equals("mojarrita")));

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
        System.out.println("Ingrese el DNI del dueño: ");
        String dni = scanner.nextLine();

        System.out.println("Ingrese el nombre del dueño: ");
        String nombreDueño = scanner.nextLine();

        System.out.println("Ingrese la direccion del dueño: ");
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
                TipoDeAgua tipoAgua = TipoDeAgua.valueOf(scanner.nextLine().toUpperCase());
                animal = new Mojarrita(nombre, edad, new Dueño(dni, nombreDueño, direccion), sexo, peso, tipoAgua);
                break;
            default:
                System.out.println("Tipo de animal inválido.");
        }
        listaAnimales.add(animal);
    }

    public static void removerAnimal(List<Animal> listaAnimales) {
        if (!listaAnimales.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;
            System.out.println("Eliga una opcion: ");
            System.out.println("1 - Todos los animales");
            System.out.println("2 - Un animal");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaAnimales.clear();
                    System.out.println("Todos los animales fueron removidos con exito");
                    break;

                case 2: for (int i = 0; i < listaAnimales.size(); i++) {
                    System.out.println("Lista de animales: ");
                    System.out.println(i + ": " + listaAnimales.get(i).nombre.toUpperCase() + " - Dueño: " + listaAnimales.get(i).dueño.getNombre());
                }

                    System.out.println("Ingrese la posicion del animal en la lista que desea remover: ");
                    int posicion = scanner.nextInt();
                    listaAnimales.remove(posicion);
                    System.out.println("Animal removido con exito!");
                    break;
            }
        } else {
            System.out.println("La lista de animales esta vacia.");
        }

    }

    public static void contarAnimales(List<Animal> listaAnimales) {
        int contador = 0;
        for (Animal animal : listaAnimales) {
            contador++;
        }
        System.out.println("La cantidad total de animales es: " + contador);
    }

    public static void listarAnimales(List<Animal> listaAnimales) {
        if (!listaAnimales.isEmpty()) {
            System.out.println("----Animales actualmente en la guarderia----");
            for (Animal animal : listaAnimales) {
                if (animal instanceof Perro) {
                    Perro perro = (Perro) animal;
                    System.out.println("Tipo Animal: " + animal.getClass().getSimpleName() + "\n" +
                            "Edad: " + animal.edad + "\n" +
                            "Dueño: " + animal.dueño.getNombre() + "\n" +
                            "DNI: " + animal.dueño.getDni() + "\n" +
                            "Direccion: " + animal.dueño.getDireccion() + "\n" +
                            "Sexo: " + animal.sexo + "\n" +
                            "Peso(grs): " + animal.peso + "\n" +
                            "Raza: " + perro.getRaza() + "\n" +
                            "Posicion en la lista: " + listaAnimales.indexOf(animal));
                    System.out.println("---------------------------------");
                } else if (animal instanceof Mojarrita) {
                    Mojarrita mojarrita = (Mojarrita) animal;
                    System.out.println("Tipo Animal: " + animal.getClass().getSimpleName() + "\n" +
                            "Edad: " + animal.edad + "\n" +
                            "Dueño: " + animal.dueño.getNombre() + "\n" +
                            "DNI: " + animal.dueño.getDni() + "\n" +
                            "Direccion: " + animal.dueño.getDireccion() + "\n" +
                            "Sexo: " + animal.sexo + "\n" +
                            "Peso(grs): " + animal.peso + "\n" +
                            "Tipo de agua: " + mojarrita.getTipoAgua() + "\n" +
                            "Posicion en la lista: " + listaAnimales.indexOf(animal));
                    System.out.println("---------------------------------");
                } else {
                    System.out.println("Tipo Animal: " + animal.getClass().getSimpleName() + "\n" +
                            "Edad: " + animal.edad + "\n" +
                            "Dueño: " + animal.dueño.getNombre() + "\n" +
                            "DNI: " + animal.dueño.getDni() + "\n" +
                            "Direccion: " + animal.dueño.getDireccion() + "\n" +
                            "Sexo: " + animal.sexo + "\n" +
                            "Peso(grs): " + animal.peso + "\n" +
                            "Posicion en la lista: " + listaAnimales.indexOf(animal));
                    System.out.println("---------------------------------");
                }
            }
        } else {
            System.out.println("No hay animales en la lista.");
        }
    }
}




