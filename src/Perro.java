public class Perro extends Animal{
    public Perro(String nombre, int edad, Dueño dueño, Sexo sexo, int peso, String raza) {
        super(nombre, edad, dueño, sexo, peso);
        this.raza = raza;
    }

    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
