import java.awt.*;
import java.awt.event.*;

public class game extends Frame implements MouseListener{
//DECLARE
MenuBar mb;
Menu m1, m2, m3;
MenuItem mi1, mi2, mi3, mi4;
Panel gameBoard, header, footer; 
Button gb[]; 
Label announcer, score;

    game(){
        //FRAME ATRIBUTES
        super("TicTacToe");
        setSize(600,400);
        setVisible(true);
        addMouseListener(this);
        
        //INITIALIZE
        //MENUBAR
         mb = new MenuBar ();
         m1 = new Menu("Nuevo Juego");
         m2 = new Menu("Opciones");
         m3 = new Menu("Ayuda");
         mi1 = new MenuItem("");
         mi2 = new MenuItem("");
         mi3 = new MenuItem("");
         //PANEL
         header= new Panel();
         gameBoard = new Panel();
         footer = new Panel();
         announcer = new Label("Announcer:");
         score = new Label("Score:");
         //BUTTONS
         gb = new Button[9];

         //SETTING THE LAYOUTS TO ACCOMODATE THE GAME BOARD
         gameBoard.setLayout(new GridLayout(3, 3));

        //CLOSING WINDOW EVENT
         this.addWindowListener(new WindowAdapter(){          
          public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
          }      
         });
         
         for(int i = 0; i < gb.length; i++){
            gb[i] = new Button();
            gameBoard.add(gb[i]);
         }

     //ADD 
        setMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        header.add(score);
        footer.add(announcer);

    //ADD PANEL TO THE FRAME
        add(gameBoard, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);

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