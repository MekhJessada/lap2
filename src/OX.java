public class OX {
    public int getRound(){
        return round;
    }
    private String[][] table = {
            {" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"},
    };
    private String player;
    private  int countX;
    private  int countO;
    private  int countDraw;
    private  int round = 0;

    public OX(){
        player = "X";
        countX=0;
        countO=0;
        countDraw=0;
        round = 0;
    }
    public String getTableString() {
        String result="";
        for(int i=0;i<table.length;i++ ){
            for (int j=0;j<table[i].length;j++){
                result = result + table[i][j];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getPlayer() {
        return player;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public int getCountX() {
        return countX;
    }

    public boolean put(int col, int row) {
        if(col+1 > 3 || row+1 > 3){
            return false;
        }else if(!table[row+1][col+1].equals("-")){
            return false;
        }else{
            round++;
            table[row+1][col+1] = getPlayer();
            return true;
        }

    }

    public void switchPlayer() {
        if(player.equals("X")){
            player = "O";
        }else{
            player = "X";
        }

    }

    public boolean checkWin(int col, int row) {
        boolean flax1=true;
        boolean flax2=true;
        boolean flax3=true;
        boolean flax4=true;
        for (int i = 0; i < 3; i++){
            if (table[i+1][col+1].equals("-")||!table[i+1][col+1].equals(player)){
                flax1=false;
            }if(table[row+1][i+1].equals("-")||!table[row+1][i+1].equals(player)){
                flax2=false;
            }if(table[i+1][i+1].equals("-")||!table[i+1][i+1].equals(player)){
                flax3=false;
            }if(table[4-(i+1)][i+1].equals("-")||!table[4-(i+1)][i+1].equals(player)){
                flax4=false;
            }
        }
        if(flax1 || flax2 || flax3 || flax4){
            return true;
        }else{
            return false;
        }

    }public void getOver(String name){
        if(name.equals("X")){
            countX++;
        }else if(name.equals("O")){
            countO++;
        }else if(name.equals("Draw")){
            countDraw++;
        }
    }

    public void reset() {
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                table[i+1][j+1]="-";
            }
        }
        player="X";
        round =0;
    }

    public boolean isDraw() {
        if(getRound() < 9){
            return false;
        }
        return true;
    }
}
