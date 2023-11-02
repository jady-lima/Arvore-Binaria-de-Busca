public class No {
    private int dado;
    private No noEsquerdo = null;
    private No noDireito = null;

    public No(int dado)
    {
        this.dado = dado;
    }

    public int getDado()
    {
        return dado;
    }

    public void setDado(int dado)
    {
        this.dado = dado;
    }

    public No getNoEsquerdo()
    {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo)
    {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito()
    {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }
}
