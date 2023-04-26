public class Perro extends Animal{
    public Perro(String nombre, int edad, Dueño dueño, Sexo sexo, int peso) {
        super(nombre, edad, dueño, sexo, peso);
    }

    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
