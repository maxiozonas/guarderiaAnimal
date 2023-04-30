public class Mojarrita extends Animal{
    public Mojarrita(String nombre, int edad, Dueño dueño, Sexo sexo, int peso, TipoDeAgua tipoAgua) {
        super(nombre, edad, dueño, sexo, peso);
        this.tipoAgua = tipoAgua;
    }

    // Atributos
    private TipoDeAgua tipoAgua;

    // Getters y Setters
    public TipoDeAgua getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(TipoDeAgua tipoAgua) {
        this.tipoAgua = tipoAgua;
    }
}
