public class ArvoreBinariaBusca {
    private No raiz = null;
    private static int idSimetrico = 1;

    public void inserirNo(int valor)
    {
        raiz = inserirNo(valor, raiz);
    }

    private No inserirNo(int valor, No raiz)
    {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.getValor()) {
            raiz.setNoEsquerdo(inserirNo(valor, raiz.getNoEsquerdo()));
        } else if (valor > raiz.getValor()) {
            raiz.setNoDireito(inserirNo(valor, raiz.getNoDireito()));
        } else if (valor == raiz.getValor()) {
            System.out.println("Elemento já encontra-se na árvore.");
        }

        return raiz;
    }

    public void inserirID()
    {
        inserirID(raiz);
    }

    private void inserirID(No raiz)
    {
        if (raiz != null) {
            inserirID(raiz.getNoEsquerdo());
            raiz.setIdSimetrico(idSimetrico);
            idSimetrico++;
            System.out.println(raiz.getValor() + " -> " + raiz.getIdSimetrico());
            inserirID(raiz.getNoDireito());
        }
    }

    private No buscarNo(int n)
    {
        return buscarNo(n, raiz);
    }

    private No buscarNo(int n, No raiz)
    {
        No elemento = null;
        if (raiz != null) {
            if (raiz.getIdSimetrico() == n) {
                elemento = raiz;
            } else if (raiz.getIdSimetrico() < n) {
                elemento = buscarNo(n, raiz.getNoDireito());
            } else if (raiz.getIdSimetrico() > n) {
                elemento = buscarNo(n, raiz.getNoEsquerdo());
            }
        }
        return elemento;
    }

    public int buscarElemento(int n)
    {
        return buscarElemento(n, raiz);
    }

    private int buscarElemento(int n, No raiz)
    {
        int elemento = 0;
        if (raiz != null) {
            if (raiz.getIdSimetrico() == n) {
                elemento = raiz.getValor();
            } else if (raiz.getIdSimetrico() < n) {
                elemento = buscarElemento(n, raiz.getNoDireito());
            } else if (raiz.getIdSimetrico() > n) {
                elemento = buscarElemento(n, raiz.getNoEsquerdo());
            }
        }
        return elemento;
    }

    public int buscarPosicao(int n)
    {
        return buscarPosicao(n, raiz);
    }

    private int buscarPosicao(int n, No raiz)
    {
        int elemento = 0;
        if ((raiz != null)) {
            if (raiz.getValor() == n) {
                elemento = raiz.getIdSimetrico();
            } else if (raiz.getValor() < n) {
                elemento = buscarPosicao(n, raiz.getNoDireito());
            } else if (raiz.getValor() > n) {
                elemento = buscarPosicao(n, raiz.getNoEsquerdo());
            }
        }
        return elemento;
    }

    public int encontraMediana()
    {
        if ((idSimetrico - 1) % 2 != 0) {
            return buscarElemento(((idSimetrico - 1) / 2 ) + 1);
        } else {
            return buscarElemento(((idSimetrico - 1) / 2 ));
        }
    }

    public double calculaMedia(int n)
    {
        No elemento = buscarNo(n);
    }

    public String preOrdem()
    {
        return preOrdem(raiz);
    }

    public String preOrdem(No raiz)
    {
        String retorno = "|";
        if(raiz == null) {
            retorno = "";
        }

        if (raiz != null) {
            retorno = retorno.concat(String.valueOf(raiz.getValor()));
            retorno = retorno.concat(preOrdem(raiz.getNoEsquerdo()));
            retorno = retorno.concat(preOrdem(raiz.getNoDireito()));
        }
        return retorno;
    }

}
