package edu.spbu;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Evgueni on 27.09.2016.
 */
abstract public class Matrix {
    int n; //number of raws
    int m; //number of coloumns

    public abstract String toString ();

    public void toFile (String filename){
        try (FileWriter wr = new FileWriter(filename, false)){
            wr.write(this.toString());
            wr.flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public abstract double getelement ( int i, int j);

    public boolean equals (Matrix other){
        if ((this.n == other.n) & (this.m == other.m)) {
            for (int i = 1; i < this.n; i++)
                for (int j = 1; j < this.m; j++){
                    if (this.getelement(i,j) != other.getelement(i,j)) return false;
                }
            return true;
        }
        else return false;
    }

    public abstract Matrix mul(Matrix other);
}