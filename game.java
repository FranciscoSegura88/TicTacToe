import java.awt.*;
import java.awt.event.*;

public class game extends Frame implements MouseListener{
//DECLARE
MenuBar mb;
Menu m1, m2, m3;
MenuItem mi1, mi2, mi3, mi4;




    game(){
        //FRAME ATRIBUTES
        super("TicTacToe");
        setSize(600,400);
        setVisible(true);
        addMouseListener(this);
         mb = new MenuBar ();
         m1 = new Menu("Nuevo Juego");
         m2 = new Menu("Opciones");
         m3 = new Menu("Ayuda");
         mi1 = new MenuItem("");
         mi2 = new MenuItem("");
         mi3 = new MenuItem("");

        //INITIALIZE

         this.addWindowListener(new WindowAdapter(){          //closing window event
          public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
          }      
         });
   
     // ADD 
      setMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
    }

    //MOUSE EVENTS
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public static void main(String[] args){

        game g = new game();

    }

}