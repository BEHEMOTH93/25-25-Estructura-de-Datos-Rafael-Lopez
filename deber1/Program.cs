using System;

// Esta clase representa un círculo y permite calcular su área y perímetro
class Circulo
{
    // Variable para guardar el radio del círculo
    private double radio;

    // Constructor: se usa para darle un valor al radio cuando se crea el círculo
    public Circulo(double r)
    {
        radio = r;
    }

    // Método para calcular el área del círculo
    public double CalcularArea()
    {
        // Fórmula: π * radio^2
        return Math.PI * radio * radio;
    }

    // Método para calcular el perímetro del círculo
    public double CalcularPerimetro()
    {
        // Fórmula: 2 * π * radio
        return 2 * Math.PI * radio;
    }
}

// Esta clase representa un rectángulo
class Rectangulo
{
    // Variables para el largo y el ancho del rectángulo
    private double largo;
    private double ancho;

    // Constructor: se usa para darle valor al largo y al ancho
    public Rectangulo(double l, double a)
    {
        largo = l;
        ancho = a;
    }

    // Método para calcular el área del rectángulo
    public double CalcularArea()
    {
        // Fórmula: largo * ancho
        return largo * ancho;
    }

    // Método para calcular el perímetro del rectángulo
    public double CalcularPerimetro()
    {
        // Fórmula: 2 * (largo + ancho)
        return 2 * (largo + ancho);
    }
}

// Clase principal que contiene el método Main
class Programa
{
    static void Main()
    {
        // Crear un círculo con radio 3
        Circulo miCirculo = new Circulo(3);
        Console.WriteLine("Área del círculo: " + miCirculo.CalcularArea());
        Console.WriteLine("Perímetro del círculo: " + miCirculo.CalcularPerimetro());

        // Crear un rectángulo con largo 5 y ancho 2
        Rectangulo miRectangulo = new Rectangulo(5, 2);
        Console.WriteLine("Área del rectángulo: " + miRectangulo.CalcularArea());
        Console.WriteLine("Perímetro del rectángulo: " + miRectangulo.CalcularPerimetro());
    }
}
