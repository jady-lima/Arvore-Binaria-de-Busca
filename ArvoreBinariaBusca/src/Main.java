public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca ABB = new ArvoreBinariaBusca();

        ABB.inserirNo(50);
        ABB.inserirNo(30);
        ABB.inserirNo(20);
        ABB.inserirNo(40);
        ABB.inserirNo(70);
        ABB.inserirNo(60);
        ABB.inserirNo(80);
        ABB.inserirNo(90);
        ABB.inserirNo(15);
        ABB.inserirNo(100);
        ABB.inserirNo(110);

        System.out.println("Impresão da árvore: " + ABB.preOrdem());

        ABB.inserirID();

        int elemento = ABB.buscarElemento(5);
        if (elemento == 0) {
            System.out.println("Elemento não está na árvore");
        } else {
            System.out.println("Elemento de valor: " + elemento);
        }

        elemento = ABB.buscarPosicao(30);
        if (elemento == 0) {
            System.out.println("Elemento não está na árvore");
        } else {
            System.out.println("Elemento na posição: " + elemento);
        }

        System.out.println("Mediana: " + ABB.encontraMediana());
    }
}