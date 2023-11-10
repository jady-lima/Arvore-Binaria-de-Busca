import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca ABB = new ArvoreBinariaBusca();
        Arquivo arquivo = new Arquivo();

        String elementos[] = arquivo.recebeElementos().split(" ");

        for (int i = 0; i < elementos.length; i++) {
            ABB.inserirNo(Integer.parseInt(elementos[i]));
        }

        ABB.inserirNivelId();

        ArrayList<String> comandos = arquivo.recebeComandos();
        for (int i = 0; i < comandos.size(); i++) {
            //System.out.println(comandos.get(i));

            if (comandos.get(i).equals("CHEIA")) {
                if (ABB.arvoreCheia()) {
                    System.out.println("A árvore é cheia");
                } else {
                    System.out.println("A árvore não é cheia");
                }
            }

            else if (comandos.get(i).equals("COMPLETA")) {
                if (ABB.arvoreCompleta()) {
                    System.out.println("A árvore é completa");
                } else {
                    System.out.println("A árvore não é completa");
                }
            }

            else if (comandos.get(i).equals("PREORDEM")) {
                System.out.println(ABB.preOrdem());
            }

            else if (comandos.get(i).equals("MEDIANA")) {
                System.out.println(ABB.encontraMediana());
            }

            else {
                String com[] = comandos.get(i).split(" ");

                if (com[0].equals("ENESIMO")) {
                    System.out.println(ABB.buscarElemento(Integer.parseInt(com[1])));
                }

                else if (com[0].equals("IMPRIMA")) {
                    ABB.imprimeArvore(Integer.parseInt(com[1]));
                }

                else if (com[0].equals("REMOVA")) {
                    ABB.removerNo(Integer.parseInt(com[1]));
                    System.out.println(com[1] + " removido");
                    ABB.inserirNivelId();
                }

                else if (com[0].equals("INSIRA")) {
                    ABB.inserirNo(Integer.parseInt(com[1]));
                    ABB.inserirNivelId();
                }

                else if (com[0].equals("MEDIA")) {
                    System.out.println(ABB.calculaMedia(Integer.parseInt(com[1])));
                }

                else if (com[0].equals("BUSCAR")) {
                    int n = ABB.buscarElemento(Integer.parseInt(com[1]));
                    if (n == 0) {
                        System.out.println("Chave não encontrada");
                    } else {
                        System.out.println("Chave encontrada");
                    }
                }

                else if (com[0].equals("POSICAO")) {
                    System.out.println(ABB.buscarElemento(Integer.parseInt(com[1])));
                }

                else {
                    System.out.print("Comando não existe.");
                }
            }
        }
    }
}