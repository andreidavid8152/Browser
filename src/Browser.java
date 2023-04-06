import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Browser extends JFrame{
    private JTextField search;
    private JButton enter;
    private JButton back;
    private JButton fordward;
    private JTextArea searches;
    private JPanel panelBrowser;

    //Stack para las busquedas (activas);
    Stack<String> viewSearches = new Stack<String>();
    //Stack para las busquedas eliminadas;
    Stack<String> deleteSearches = new Stack<String>();
    //Se usara para mostrar en el text area
    String texto;

    public Browser() {
        //Se crea un evento para el boton enter
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se inicializa el String texto
                texto = "";

                //Condicion que verificara que el jtextfield (search) no contenga espacios y tampoco este vacio;
                if(!search.getText().equals("") && !search.getText().startsWith(" ")){
                    //Se agrega la busqueda al stack de las busquedas activas
                    viewSearches.push(search.getText());
                    //Se vacia el stack de las busquedas eliminadas
                    deleteSearches.clear();
                    //Se desactiva el boton fordward
                    fordward.setEnabled(false);
                }

                //Condicion que verifica si el stack de busquedas activas no este vacio
                if(!viewSearches.isEmpty()){
                    //Se recorre el for en base al stack de busquedas activas
                    for (int i = 0; i < viewSearches.size(); i++){
                        //Se concatena el texto con los elementos del stack de busquedas activas
                        texto += viewSearches.get(i) + "  ";
                    }
                }else{
                    //Si el stack de busquedas activas esta vacio, el texto pasa a mostrar "Sin busquedas"
                    texto = "Sin busquedas";
                }

                //se muestra el texto correspondiente en el text area
                searches.setText(texto);
            }
        });

        //Se crea un evento para el boton back
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se inicializa el String texto
                texto = "";

                //Condicion que verifica si el stack de busquedas activas no este vacio
                if(!viewSearches.isEmpty()){
                    //Se habilita el boton fordward
                    fordward.setEnabled(true);
                    //Se agrega al stack de busquedas eliminadas el ultimo elemento del stack de busquedas activas
                    deleteSearches.push(viewSearches.pop());
                    //Se recorre el for en base al stack de busquedas activas
                    for (int i = 0; i < viewSearches.size(); i++){
                        //Se concatena el texto con los elementos del stack de busquedas activas
                        texto += viewSearches.get(i) + "  ";
                    }
                }else{
                    //Si el stack de busquedas activas esta vacio, el texto pasa a mostrar "Sin busquedas"
                    texto = "Sin busquedas";
                }

                //se muestra el texto correspondiente en el text area
                searches.setText(texto);
            }
        });

        //Se crea un evento para el boton fordward
        fordward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se inicializa el String texto
                texto = "";

                //Se verifica que el stack de busquedas eliminadas no este vacio
                if(!deleteSearches.isEmpty()){
                    //Se agrega al stack de busquedas activas el ultimo elemento del stack de busquedas eliminadas y ademas ese elemento se elimina de dicho stack
                    viewSearches.push(deleteSearches.pop());
                    //Se recorre el for en base al stack de busquedas activas
                    for (int i = 0; i < viewSearches.size(); i++){
                        //Se concatena el texto con los elementos del stack de busquedas activas
                        texto += viewSearches.get(i) + "  ";
                    }
                    //Condicion que verifica que el stack de busquedas eliminadas este vacio
                    if(deleteSearches.isEmpty()){
                        //Se desactiva el boton fordward
                        fordward.setEnabled(false);
                    }
                }

                //se muestra el texto correspondiente en el text area
                searches.setText(texto);
            }
        });
    }

    public static void main(String[] args){
        //Crea una instancia de la clase Browser
        Browser b = new Browser();
        //Establece el panel que se mostrará en una ventana JFrame
        b.setContentPane(b.panelBrowser);
        //Titulo del JFrame
        b.setTitle("Browser GPT");
        //Tamanio del JFrame
        b.setSize(300, 400);
        //Hace visible el browser (JFrame)
        b.setVisible(true);
        //Indica que la aplicación debe finalizar completamente cuando se cierra la ventana JFrame
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Deshabilita el boton fordward
        b.fordward.setEnabled(false);
    }
}
