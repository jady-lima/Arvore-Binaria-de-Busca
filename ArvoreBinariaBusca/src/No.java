public class No {
    private int valor;
    private No noEsquerdo = null;
    private No noDireito = null;
    private int idSimetrico;

    public No(int valor)
    {
        this.valor = valor;
    }

    public int getValor()
    {
        return valor;
    }

    public void setValor(int valor)
    {
        this.valor = valor;
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

    public int getIdSimetrico()
    {
        return idSimetrico;
    }

    public void setIdSimetrico(int idSimetrico)
    {
        this.idSimetrico = idSimetrico;
    }
}
