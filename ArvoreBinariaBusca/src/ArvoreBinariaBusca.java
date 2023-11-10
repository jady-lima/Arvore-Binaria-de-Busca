public class ArvoreBinariaBusca {
    private No raiz = null;
    private static int idSimetrico = 1;
    private double media = 0, soma = 0;

    public void inserirNo(int valor)
    {
        raiz = inserirNo(valor, raiz);
    }

    private No inserirNo(int valor, No raiz)
    {
        if (raiz == null) {
            System.out.println(valor + " inserido");
            return new No(valor);
        }

        if (valor < raiz.getValor()) {
            raiz.setNoEsquerdo(inserirNo(valor, raiz.getNoEsquerdo()));
        } else if (valor > raiz.getValor()) {
            raiz.setNoDireito(inserirNo(valor, raiz.getNoDireito()));
        } else if (valor == raiz.getValor()) {
            System.out.println(valor + " já esta na árvore, não pode ser inserido");
        }

        return raiz;
    }

    public void removerNo(int valor)
    {
        removerNo(valor, raiz);
    }

    public No removerNo(int valor, No raiz)
    {
        if (raiz != null) {
            if (valor < raiz.getValor()) {
                raiz.setNoEsquerdo(removerNo(valor, raiz.getNoEsquerdo()));
            } else if (valor > raiz.getValor()) {
                raiz.setNoDireito(removerNo(valor, raiz.getNoDireito()));
            } else {
                if (raiz == buscarNo(valor)) {
                    if (raiz.getNoEsquerdo() == null) {
                        return raiz.getNoDireito();
                    } else if (raiz.getNoDireito() == null) {
                        return raiz.getNoEsquerdo();
                    }
                    raiz.setValor(encontrarMenor(raiz.getNoDireito()).getValor());
                    raiz.setNoDireito(removerNo(raiz.getValor(), raiz.getNoDireito()));
                } else {
                    System.out.println(valor + " não está na árvore, não pode ser removido");
                }
            }
        }
        return raiz;
    }

    public No encontrarNoDireito(No raiz)
    {
        while (raiz.getNoDireito() != null) {
            raiz = raiz.getNoDireito();
        }
        return raiz;
    }

    private No encontrarMenor(No raiz)
    {
        if (raiz == null) {
            return null;
        } if (raiz.getNoEsquerdo() != null) {
            return encontrarNoDireito(raiz.getNoEsquerdo());
        } else {
            No menor = raiz.getPredecessor();
            while (menor != null && raiz == menor.getNoEsquerdo()) {
                raiz = menor;
                menor = menor.getPredecessor();
            }
            return menor;
        }
    }

    private int alturaArvore(No raiz)
    {
        if (raiz == null) {
            return 0;
        } else {
            int alturaDireita = alturaArvore(raiz.getNoDireito());
            int alturaEsquerda = alturaArvore(raiz.getNoEsquerdo());
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public void inserirNivelId()
    {
        for (int i = 0; i <= alturaArvore(raiz); i++) {
            inserirNivel(raiz, i);
        }
        inserirID(raiz);
    }

    private void inserirID(No raiz)
    {
        if (raiz != null) {
            inserirID(raiz.getNoEsquerdo());
            raiz.setIdSimetrico(idSimetrico);
            idSimetrico++;
            inserirID(raiz.getNoDireito());
        }
    }

    private void inserirNivel(No no, int nivel)
    {
        if (no == null) {
            return;
        } if (nivel < alturaArvore(raiz) + 1) {
            inserirNivel(no.getNoEsquerdo(), nivel-1);
            inserirNivel(no.getNoDireito(), nivel-1);
            no.setNivel(nivel);
        } else if(nivel == alturaArvore(raiz) + 1) {
            no.setNivel(nivel);
        }
    }

    public No buscarNo(int n)
    {
        return buscarNo(n, raiz);
    }

    private No buscarNo(int n, No raiz)
    {
        if (raiz == null || n == raiz.getValor()) {
            return raiz;
        } else if (raiz.getValor() < n) {
            return buscarNo(n, raiz.getNoDireito());
        } else {
            return buscarNo(n, raiz.getNoEsquerdo());
        }
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
        if (raiz != null) {
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
        return calculaMedia(n, buscarNo(n));
    }

    private double calculaMedia(int n, No raiz)
    {
        if (raiz == null) {
            return 0;
        }

        calculaMedia(raiz.getValor(), raiz.getNoEsquerdo());
        media += raiz.getValor();
        soma++;
        calculaMedia(raiz.getValor(), raiz.getNoDireito());

        return media/soma;
    }

    public boolean arvoreCheia()
    {
        return arvoreCheia(raiz);
    }

    private boolean arvoreCheia(No raiz)
    {
        if (raiz == null) {
            return true;
        } else {
            if (raiz.getNoEsquerdo() == null && raiz.getNoDireito() == null) {
                return true;
            } else if (raiz.getNoEsquerdo() != null && raiz.getNoDireito() != null) {
                return arvoreCheia(raiz.getNoEsquerdo()) && arvoreCheia(raiz.getNoDireito());
            }
            return false;
        }
    }

    public boolean arvoreCompleta()
    {
        return arvoreCompleta(raiz);
    }

    private boolean arvoreCompleta(No raiz)
    {
        if (raiz == null) {
            return true;
        } if (arvoreCheia()) {
            return true;
        } else {
            if (raiz.getNivel() >= 2) {
                if (raiz.getNoEsquerdo() == null || raiz.getNoDireito() == null) {
                    return true;
                } else {
                    return arvoreCompleta(raiz.getNoEsquerdo()) && arvoreCompleta(raiz.getNoDireito());
                }
            }
        }
        return false;
    }

    public String preOrdem()
    {
        return preOrdem(raiz);
    }

    public String preOrdem(No raiz)
    {
        String retorno = " ";
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

    public void imprimeArvore(int s)
    {
        if (s == 1) {
            for (int i = 1; i <= alturaArvore(raiz); i++) {
                primeiraImpressao(raiz, i);
            }
            System.out.println("");
        } else if (s == 2) {
            segundaImpressao(raiz);
            System.out.println("");
        } else {
            System.out.println("Formato não disponível.");
        }
    }

    private void primeiraImpressao(No raiz, int nivel)
    {
        if(raiz == null) {
            System.out.print("\t");
        } else if (nivel == 1) {
            System.out.println(raiz.getValor() + "-------".repeat((raiz.getNivel()) + 1));
            System.out.print("      ");
        } else if (nivel > 1){
            primeiraImpressao(raiz.getNoEsquerdo(), nivel-1);
            primeiraImpressao(raiz.getNoDireito(), nivel-1);
            System.out.print("      ");
        }
    }

    private void segundaImpressao(No raiz)
    {
        if (raiz != null) {
            System.out.print("(" + raiz.getValor());
            segundaImpressao(raiz.getNoEsquerdo());
            segundaImpressao(raiz.getNoDireito());
            System.out.print(")");
        }
    }
}
