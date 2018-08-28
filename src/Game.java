import java.util.Scanner;

public class Game {
    private static OX ox;
    static Scanner k = new Scanner(System.in);
    static int col,row;
    static void input(){
        System.out.print(ox.getPlayer()+" (col): ");
        col=k.nextInt();
        System.out.print(ox.getPlayer()+" (Row): ");
        row=k.nextInt();
    }
    public static void main(String[] args){
        ox= new OX();
        while (true) {
            System.out.print(ox.getTableString());
            input();
            ox.put(col, row);
            if(ox.checkWin(col, row)){
                System.out.print(ox.getTableString());
                ox.getOver(ox.getPlayer());
                System.out.println("X win "+ox.getCountX());
                System.out.println("O win "+ox.getCountO());
                System.out.println("Draw "+ox.getCountDraw());
                ox.reset();
                continue;

            }else if(ox.isDraw()){
                System.out.print(ox.getTableString());
                ox.getOver("Draw");
                System.out.println("X win "+ox.getCountX());
                System.out.println("O win "+ox.getCountO());
                System.out.println("Draw "+ox.getCountDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }
}
