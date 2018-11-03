import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class cells {
    private int w =4;
    private int xl = 500;
    private int yl = 500;
    private boolean[][] table = new boolean[xl][yl];
    private ArrayList<int[]> tlist;
    public cells(String t) throws FileNotFoundException {
        File f = new File(t);
        Scanner sc = new Scanner(f);
        tlist = new ArrayList<>();
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            table[x][y] = true;
            int[] l = {x,y};
            tlist.add(l);
        }
//        System.out.println(Arrays.toString(table[0]));
    }
    public ArrayList getlist(){
        return this.tlist;
    }
    public boolean[][] gettable(){
        return this.table;
    }
    public void recalculate(){
        boolean[][] temtable = new boolean[xl][yl];
        this.tlist.clear();
        for(int i =0;i<xl;i+=w){
            for(int j=0;j<yl;j+=w){
                int nc = getNeighborCount(table,i,j,xl,yl);
                if(table[i][j]){
                    if(nc<2){
                        temtable[i][j] = false;
                    }else if(nc>3){
                        temtable[i][j] = false;
                    }else{
//                        System.out.println("in");
                        temtable[i][j] = true;
                        int[] pos = {i,j};
                        tlist.add(pos);
                    }
                }else{
                    if(nc == 3){
//                        System.out.println("in");
                        temtable[i][j] = true;
                        int[] pos = {i,j};
                        tlist.add(pos);
                    }
                }
            }
        }
//        System.out.println(tlist.toString());
        table = temtable;
    }
    //function taked from wikipedia.org
    public int getNeighborCount(boolean[][] board, int x, int y, int xsize, int ysize){
        int nc = 0;   // this function rather messily counts up the neighbors

        if (board[mod(x+w,xsize)][y]){
            nc++;
        }
        if (board[mod(x+w,xsize)][mod(y+w, ysize)]){
            nc++;
        }
        if (board[x][mod(y+w,ysize)]){
            nc++;
        }
        if (board[x][mod(y-w,ysize)]){
            nc++;
        }
        if (board[mod(x+w,xsize)][mod(y-w,ysize)]){
            nc++;
        }
        if (board[mod(x-w,xsize)][y]){
            nc ++;
        }
        if (board[mod(x-w,xsize)][mod(y-w,ysize)]){
            nc ++;
        }
        if (board[mod(x-w,xsize)][mod(y+w,ysize)]){
            nc ++;
        }
        return nc;
    }
    public static int mod (int x, int m){ // deals with java's % returning negative vals for
        m = Math.abs(m);                   // negative inputs
        return (x % m + m) % m;
    }

}
