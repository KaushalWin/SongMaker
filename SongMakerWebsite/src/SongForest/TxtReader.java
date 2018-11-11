package SongForest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

public class TxtReader {

       private File file;

    TxtReader() {
    }

    ArrayList<Note> alm;

    public ArrayList<Note> getAlm() {
        return alm;
    }

    public void setAlm(ArrayList<Note> alm) {
        this.alm = alm;
    }
     public void openFile(File selectedFile) {
      //  System.out.println("yoyo");
        file=selectedFile;
        try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String content = new Scanner(selectedFile).useDelimiter("\\Z").next();
            String arr[] = content.split(" ");
            int k;
            alm=new ArrayList<Note>();
            for(String str:arr)
            {
                k=convertToNote(str);
                if(k!=-1)
                {
                    alm.add(new Note(k));
                    
                }
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private int convertToNote(String str) {
        switch (str) {
            case "SA_L":
                return 0;
            case "sa_L":
                return 0;
//          
            case "re_L":
                return 1;
//                 
            case "RE_L":
                return 2;
//                 
            case "ga_L":
                return 3;
//                 
            case "GA_L":
                return 4;
//                 
            case "ma_L":
                return 5;
                 
            case "MA_L":
                return 6;
                 
            case "PA_L":
                return 7;
            case "pa_L":
                return 7;
                 
            case "dha_L":
                return 8;
                 
            case "DHA_L":
                return 9;
                 
            case "ni_L":
                return 10;
                 
            case "NI_L":
                return 11;
                 
            case "SA":
                return 12;
            case "sa":
                return 12;
                 
            case "re":
                return 13;
                 
            case "RE":
                return 14;
                 
            case "ga":
                return 15;
                 
            case "GA":
                return 16;
                 
            case "ma":
                return 17;
                 
            case "MA":
                return 18;
                 
            case "PA":
                return 19;
            case "pa":
                return 19;
            case "dha":
                return 20;
                 
            case "DHA":
                return 21;
                 
            case "ni":
                return 22;
                 
            case "NI":
                return 23;
                 
            case "SA_U":
                return 24;
                
             case "sa_U":
                return 24;
                
            case "re_U":
                return 25;
                 
            case "RE_U":
                return 26;
                 
            case "ga_U":
                return 27;
                 
            case "GA_U":
                return 28;
                 
            case "ma_U":
                return 29;
                 
            case "MA_U":
                return 30;
                 
            case "PA_U":
                return 31;
             case "pa_U":
                return 31;
                 
            case "dha_U":
                return 32;
                 
            case "DHA_U":
                return 33;
                 
            case "ni_U":
                return 34;
                 
            case "NI_U":
                return 35;
            case "S_L":
                return 0;
             case "s_L":
                return 0;
//          
            case "r_L":
                return 1;
//                 
            case "R_L":
                return 2;
//                 
            case "g_L":
                return 3;
//                 
            case "G_L":
                return 4;
//                 
            case "m_L":
                return 5;
                 
            case "M_L":
                return 6;
                 
            case "P_L":
                return 7;
            case "p_L":
                return 7;
            case "d_L":
                return 8;
                 
            case "D_L":
                return 9;
                 
            case "n_L":
                return 10;
                 
            case "N_L":
                return 11;
                 
            case "S":
                return 12;
            case "s":
                return 12;
                 
            case "r":
                return 13;
                 
            case "R":
                return 14;
                 
            case "g":
                return 15;
                 
            case "G":
                return 16;
                 
            case "m":
                return 17;
                 
            case "M":
                return 18;
                 
            case "P":
                return 19;
                
            case "p":
                return 19;
                 
            case "d":
                return 20;
                 
            case "D":
                return 21;
                 
            case "n":
                return 22;
                 
            case "N":
                return 23;
                 
            case "S_U":
                return 24;
            case "s_U":
                return 24;
                 
            case "r_U":
                return 25;
                 
            case "R_U":
                return 26;
                 
            case "g_U":
                return 27;
                 
            case "G_U":
                return 28;
                 
            case "m_U":
                return 29;
                 
            case "M_U":
                return 30;
                 
            case "P_U":
                return 31;
            
            case "p_U":
                return 31; 
            
            case "d_U":
                return 32;
                 
            case "D_U":
                return 33;
                 
            case "n_U":
                return 34;
                 
            case "N_U":
                return 35;
            default:
                return -1;
        }
    }
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}
