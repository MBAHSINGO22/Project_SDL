import Model.*;
import GUI.*;
import Control.*;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;

public class AppMain {
    public static void main(String[] args) {
        TitlePane titlePane = new TitlePane();
        ActionPane actionPane = new ActionPane();
        DaftarPane daftarPane = new DaftarPane();
        AddAkademikPane addAkademikPane = new AddAkademikPane();
        AddNonAkademikPane addNonAkademikPane = new AddNonAkademikPane();
        RightPane rightPane = new RightPane();
        
        CombinedPane combinedPane = new CombinedPane(titlePane, actionPane, daftarPane, addAkademikPane,
                addNonAkademikPane, rightPane);


        MainFrame mainFrame = new MainFrame(combinedPane);

        DataHandle handle = new DataHandle();

        ArrayList<Peserta> peserta = null;
        Controller controller = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("assets/DataPeserta.txt"));
            peserta = (ArrayList<Peserta>) ois.readObject();
            System.out.println("Data read success!!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Read failed!!");
        }
        
        controller = new Controller(mainFrame, handle, peserta);
        controller.initController();
    }
}
