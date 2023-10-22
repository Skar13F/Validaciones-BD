package entity;

public enum Puestos {
    GERENTE("Gerente", 1),
    EMPLEADO("Empleado", 2);

    private final String nombre;
    private final int valor;

    Puestos(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
}
    