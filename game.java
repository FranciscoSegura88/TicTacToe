    import java.awt.*;
    import java.awt.event.*;

    public class game extends Frame implements MouseListener, ActionListener{
    //DECLARE
    Panel gameBoard, footer, header; 
    Button gb[], newgame; 
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
            //PANEL
            gameBoard = new Panel();
            header = new Panel();
            footer = new Panel();
            announcer = new Label("Announcer:");
            announcer.setPreferredSize(new Dimension(102, 30));
            //BUTTONS
            gb = new Button[9];
            newgame = new Button();

            //SETTING THE LAYOUTS TO ACCOMODATE THE GAME BOARD
            gameBoard.setLayout(new GridLayout(3, 3));

            //CLOSING WINDOW EVENT
            this.addWindowListener(new WindowAdapter(){          
            public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
            }      
            });

            //ADDING THE BUTTONS & LABEL
            newgame.addActionListener(this);
            newgame.setLabel("New Game");
            header.add(newgame);
            footer.add(announcer);
            //GAMEBOARD
            for(int i = 0; i < gb.length; i++){
                gb[i] = new Button();
                gb[i].addMouseListener(this); //Dumbest fucking mistake in my life
                gameBoard.add(gb[i]);
            }

        //ADD PANEL TO THE FRAME
            add(gameBoard, BorderLayout.CENTER);
            add(header, BorderLayout.NORTH);
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

        //MOUSE EVENTS
        @Override
        public void mouseClicked(MouseEvent e){}
        
        @Override
        public void mouseEntered(MouseEvent e){}

        @Override
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
        
        //ANNOUNCER
        if (Win() && player == 0) {
            announcer.setText("Announcer: O wins!");
        } else if (Win() && player == 1) {
            announcer.setText("Announcer: X wins!");
        } else if (allButtonsFilled) {
            announcer.setText("Announcer: It's a tie!");
        }
                
        }

        //ACTIONS EVENTS
        public void actionPerformed(ActionEvent e){ //<-NOT WORKING
            //New game
            //System.out.println("Ya funciona!!#!");
            if(e.getActionCommand().equals("New Game")){
                for(int i = 0; i < gb.length; i++){
                    gb[i].setLabel("");
                    gb[i].setBackground(null);
                }
            announcer.setText("Announcer:");
            player = 0;
            }
        }
        
        public void mouseReleased(MouseEvent e){}

        public static void main(String[] args){

            game g = new game();

        }

    }