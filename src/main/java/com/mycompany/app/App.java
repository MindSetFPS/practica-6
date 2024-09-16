package com.mycompany.app;

/**
 * Hello world!
 */

// 1.  Sólo se puede mover un disc o cada vez.
// 2.  Un disco de mayor tamaño no puede descansar sobre uno más pequeño que él mismo.   
// 3.  Sólo puedes desplazar el disco que se encuentre arriba en cada varilla.   

// Existen diversas formas de realizar la solución final, todas ellas siguiendo estrategias diversas.   
// Utilizando recursividad realiza un programa recursivo que lea el número de discos que el usuario deseé y 
// describa los movimientos para llevar todas las torres del origen al destino.  

public class App {
    public static void main(String[] args) {
        View.RenderUi();
        Hanoi hanoi = new Hanoi();
        View.createSingleInputView(hanoi);
    }
}