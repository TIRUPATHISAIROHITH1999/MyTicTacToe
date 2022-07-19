
import java.util.Scanner;

public class myTicTacAlpha {
    static Scanner sc=new Scanner(System.in);
    
    static int player=1;
    static int draw=3;
    static int winner=0;
    public static void main(String[] args) {
        System.out.println("Enter the board size: ");
        int size=sc.nextInt();
        int [][] board=new int [size][size];
        int circum=(size*size);
        while(winner==0)
        {
        // Displays the name of the player turn
            displayName(player);
        // Takes the cords from the player
         System.out.println("Enter your row: ");
         int x=sc.nextInt();
         System.out.println("Enter your col: ");
         int y=sc.nextInt();
         if(board[x][y]==0)
         {
            board[x][y]=player;
            // Checking the winner
            checkwinnerFunction(x,y,board,circum,size);
         }
         else
         {
            System.out.println("Sheep watch out ,Dont stamp me!!!");
            System.out.println();
         }
        
        }
    }
    private static void checkwinnerFunction( int x, int y,int board[][],int circum,int size) {
        // checkWinner function
        int rowScore=0;
        int colScore=0;
        int diaScore=0;
        int crossDiaScore=0;
        int totalTurns=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]!=0)
                {
                    totalTurns++;
                }
            }
        }
       
        for(int i=0;i<board[0].length;i++)
        {
            if(board[x][i]==player)
            {
                rowScore++;
            }
        }
        // col score check
        for(int i=0;i<board.length;i++)
        {
            if(board[i][y]==player)
            {
                colScore++;
            }
        }
         // dia score check
         for(int i=0,j=0;i<board.length && j<board[0].length;i++,j++)
         {
                if(board[i][j]==player)
                {
                    diaScore++;
                }
         }
          // dia score check 2
          for(int i=0,j=board[0].length-1;i<board.length && j>=0;i++,j--)
          {
                if(board[i][j]==player)
                {
                    crossDiaScore++;
                }
          }
// System.out.println("winner"+winner+"rowScore"+rowScore+"colScore"+colScore);
if(totalTurns<circum)
{
    if(rowScore==size || colScore==size || diaScore==size || crossDiaScore==size)
        {
           winner=player;
           if(player==1)
           {
               System.out.println("Congratulation HANMA !!! Party hard");
           }
           else if(player==2)
           {
               System.out.println("Congratulation CASSY !!! Party hard");
           }
           printBoard(x, y, board);
        }
        else
        {
           if(player==1)
           {
              player=2;
           }
           else if(player==2)
           {
              player=1;
           }
            printBoard(x,y,board);
        }
       //  checkwinner end
}
else
{
    printBoard(x, y, board);
    winner=draw;
    System.out.println();
    System.out.println("Have break take a kit kat !!!");
    System.out.println();
}
        
    }
    private static void displayName(int player) {
        if(player==1)
        {
            System.out.println("Please Make your move Hanma: ");
        }
        else if(player!=1)
        {
            System.out.println("Please Make your move Cassy: ");
        }
    }
    private static void printBoard(int x, int y, int[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
               
                System.out.print("          "+board[i][j]);
               
            }
            System.out.println();
            System.out.println("__________________________________________________________________________________________________________________________________");
            System.out.println();
        }
        
    }
    
}
