import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private ArrayList<String> comandos;

    public Arquivo() {
        comandos = new ArrayList<String>();
    }

    public String recebeElementos()
    {
        String linha = "";
        File entrada = new File("ArvoreBinariaBusca/file/arquivo1.txt");
        try {
            FileReader fileReader = new FileReader(entrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            linha = bufferedReader.readLine();

            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return linha;
        }
    }

    public ArrayList recebeComandos()
    {
        File entrada = new File("ArvoreBinariaBusca/file/arquivo2.txt");
        try {
            FileReader fileReader = new FileReader(entrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = " ";
            while ((linha = bufferedReader.readLine()) != null) {
                comandos.add(linha);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return comandos;
        }
    }
}
