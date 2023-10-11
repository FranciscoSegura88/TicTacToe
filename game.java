import java.awt.*;
import java.awt.event.*;

public class game extends Frame implements MouseListener{
//DECLARE

    game(){
        //FRAME ATRIBUTES
        super("TicTacToe");
        setSize(600,400);
        setVisible(true);
        addMouseListener(this);

        //INITIALIZE
        
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
