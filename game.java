import java.awt.*;
import java.awt.event.*;

public class game extends Frame implements MouseListener, ActionListener{
//DECLARE
MenuBar mb;
Menu m1;
Panel gameBoard, footer; 
Button gb[]; 
Label announcer;
int player;

    game(){
        //FRAME ATRIBUTES
        super("TicTacToe");
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        
        //INITIALIZE
        player = 0; //Player
        //MENUBAR
         mb = new MenuBar ();
         m1 = new Menu("New Game");
         //PANEL
         gameBoard = new Panel();
         footer = new Panel();
         announcer = new Label("Announcer:");
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

        m1.addActionListener(this);

         //ADDING THE BUTTONS TO THE GAMEBOARD
         for(int i = 0; i < gb.length; i++){
            gb[i] = new Button();
            gb[i].addMouseListener(this); //Dumbest fucking mistake in my life
            gameBoard.add(gb[i]);
         }

     //ADD 
        setMenuBar(mb);
        mb.add(m1);
        footer.add(announcer);

    //ADD PANEL TO THE FRAME
        add(gameBoard, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

    }

    public boolean Win(){

            // Define the winning combinations (rows, columns, and diagonals)
            int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6} // Diagonals
            };
        
            // Check each winning combination
            for (int[] combo : winCombinations) {
                int a = combo[0];
                int b = combo[1];
                int c = combo[2];
        
                if (!gb[a].getLabel().isEmpty() &&
                    gb[a].getLabel().equals(gb[b].getLabel()) &&
                    gb[a].getLabel().equals(gb[c].getLabel())) {
                    
                    //CHANGE BG TO WINNING COMBINATION
                    gb[a].setBackground(Color.GREEN);
                    gb[b].setBackground(Color.GREEN);
                    gb[c].setBackground(Color.GREEN);

                    return true; // We found a winning combination
                    
                }
            }
        
            return false; // No winning combination found
    }
    //ACTIONS EVENTS
    public void actionPerformed(ActionEvent e){ //<-NOT WORKING
        //New game
        if(e.getSource().equals(m1)){
            for(int i = 0; i < gb.length; i++){
                gb[i].setLabel("");
                gb[i].setBackground(null);
            }
        announcer.setText("");
        player = 0;
        //System.out.pritnln("Estas presionando New Game"); //TEST
        }
    }

    //MOUSE EVENTS
    public void mouseClicked(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}
    
    public void mouseExited(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    boolean allButtonsFilled = true;
    
    for (int i = 0; i < gb.length; i++) {
        if (player == 0) {
            if (e.getSource().equals(gb[i])) {
                if (gb[i].getLabel().isEmpty() && !Win()) { // Checks if it's empty and no win yet
                    gb[i].setLabel("X"); // Sets X
                    player = 1; // Switch over to O
                }
            }
        } else {
            if (e.getSource().equals(gb[i])) {
                if (gb[i].getLabel().isEmpty() && !Win()) { // Checks if it's empty and no win yet
                    gb[i].setLabel("O"); // Sets O
                    player = 0; // Switch over to X
                }
            }
        }
        
        if (gb[i].getLabel().isEmpty()) {
            allButtonsFilled = false;
        }
    }
    
    if (Win() && player == 0) {
        announcer.setText("O wins!");
    } else if (Win() && player == 1) {
        announcer.setText("X wins!");
    } else if (allButtonsFilled) {
        announcer.setText("It's a tie!");
    }
            
    }
    
    public void mouseReleased(MouseEvent e){}

    public static void main(String[] args){

        game g = new game();

    }

}