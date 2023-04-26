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

    // Metodos
    public void saludar() {
        System.out.println("Hola me llamo " + nombre + " y soy un " + getClass().getSimpleName());
    }
}



