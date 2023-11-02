import java.util.ArrayList;

public class ArvoreBinariaBusca {
    private ArrayList<Integer> nosArray;
    private No raiz = null;

    public ArvoreBinariaBusca()
    {
        nosArray = new ArrayList<Integer>();
    }

    public void inserirNo(int dado)
    {
        raiz = inserirNo(dado, raiz);
    }

    public No inserirNo(int dado, No raiz)
    {
        if (raiz == null) {
            raiz = new No(dado);
            return raiz;
        }

        if (dado < raiz.getDado()) {
            raiz.setNoEsquerdo(inserirNo(dado, raiz.getNoEsquerdo()));
        } else if (dado > raiz.getDado()) {
            raiz.setNoDireito(inserirNo(dado, raiz.getNoDireito()));
        }

        return raiz;
    }

    public void imprimeArvore()
    {
        imprimeArvore(raiz);
    }

    public void imprimeArvore(No raiz)
    {
        if(raiz != null) {
            imprimeArvore(raiz.getNoEsquerdo());
            System.out.print(raiz.getDado() + " | ");
            imprimeArvore(raiz.getNoDireito());
        }
    }

    public ArrayList<Integer> listaElementos()
    {
        return nosArray;
    }
}
