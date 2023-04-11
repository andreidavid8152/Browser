import javax.swing.*;

public class main {
    public static void main(String[] args){
        //Crea una instancia de la clase Browser
        Browser b = new Browser();
        //Titulo del JFrame
        b.setTitle("Browser GPT");
        //Tamanio del JFrame
        b.setSize(300, 400);
        //Hace visible el browser (JFrame)
        b.setVisible(true);
        //Indica que la aplicación debe finalizar completamente cuando se cierra la ventana JFrame
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
