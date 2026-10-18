package trabalho.poo;

import java.time.LocalTime;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Filme filme1 = new Filme("Velozes e Furiosos", 130, 14);
        Filme filme2 = new Filme("Toy Story", 100);
        Filme filme3 = new Filme("O Exorcista", 122, 18);

        // LocalTime.of(hora, minuto) cria o horario da sessao
        Sessao sessao1 = new Sessao("S01", filme1, LocalTime.of(14, 0), 40);
        Sessao sessao2 = new Sessao("S02", filme1, LocalTime.of(18, 0));
        Sessao sessao3 = new Sessao("S03", filme2, LocalTime.of(15, 30), 30);
        Sessao sessao4 = new Sessao("S04", filme2, LocalTime.of(17, 0));
        Sessao sessao5 = new Sessao("S05", filme3, LocalTime.of(21, 0), 60);

        int opcao;
        do {
            System.out.println("\n1 - Gerenciar filmes");
            System.out.println("2 - Gerenciar sessoes e vender ingressos");
            System.out.println("3 - Consultar e atualizar informacoes do cinema");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.println("1 - " + filme1.getTitulo() + " - " + filme1.getCategoria());
                System.out.println("2 - " + filme2.getTitulo() + " - " + filme2.getCategoria());
                System.out.println("3 - " + filme3.getTitulo() + " - " + filme3.getCategoria());
                int n = sc.nextInt();
                sc.nextLine();

                Filme filme = filme3;
                if (n == 1) {
                    filme = filme1;
                } else if (n == 2) {
                    filme = filme2;
                }

                int op;
                do {
                    System.out.println("\n1 - Consultar os dados do filme");
                    System.out.println("2 - Alterar a categoria");
                    System.out.println("3 - Alterar a sinopse");
                    System.out.println("0 - Voltar ao menu principal");
                    op = sc.nextInt();
                    sc.nextLine();

                    if (op == 1) {
                        System.out.println("Titulo: " + filme.getTitulo());
                        System.out.println("Duracao: " + filme.getDuracao() + " min");
                        System.out.println("Classificacao: " + filme.getClassificacao());
                        System.out.println("Categoria: " + filme.getCategoria());
                        System.out.println("Sinopse: " + filme.getSinopse());
                    } else if (op == 2) {
                        System.out.println("Categorias: Ação, Aventura, Comédia, Drama, Terror");
                        System.out.println("Nova categoria:");
                        if (filme.setCategoria(sc.nextLine())) {
                            System.out.println("Alteracao aceita.");
                        } else {
                            System.out.println("Alteracao recusada.");
                        }
                    } else if (op == 3) {
                        System.out.println("Nova sinopse:");
                        filme.setSinopse(sc.nextLine());
                    }
                } while (op != 0);

            } else if (opcao == 2) {
                System.out.println("1 - " + sessao1.getCodigoId() + " - " + sessao1.getFilme().getTitulo() + " - " + sessao1.getHoraInicio());
                System.out.println("2 - " + sessao2.getCodigoId() + " - " + sessao2.getFilme().getTitulo() + " - " + sessao2.getHoraInicio());
                System.out.println("3 - " + sessao3.getCodigoId() + " - " + sessao3.getFilme().getTitulo() + " - " + sessao3.getHoraInicio());
                System.out.println("4 - " + sessao4.getCodigoId() + " - " + sessao4.getFilme().getTitulo() + " - " + sessao4.getHoraInicio());
                System.out.println("5 - " + sessao5.getCodigoId() + " - " + sessao5.getFilme().getTitulo() + " - " + sessao5.getHoraInicio());
                int n = sc.nextInt();
                sc.nextLine();

                Sessao sessao = sessao5;
                if (n == 1) {
                    sessao = sessao1;
                } else if (n == 2) {
                    sessao = sessao2;
                } else if (n == 3) {
                    sessao = sessao3;
                } else if (n == 4) {
                    sessao = sessao4;
                }

                int op;
                do {
                    System.out.println("\n1 - Consultar os detalhes da sessao");
                    System.out.println("2 - Vender ingresso");
                    System.out.println("3 - Consultar os lugares disponiveis");
                    System.out.println("4 - Consultar o horario de termino");
                    System.out.println("0 - Voltar ao menu principal");
                    op = sc.nextInt();
                    sc.nextLine();

                    if (op == 1) {
                        System.out.println("Codigo: " + sessao.getCodigoId());
                        System.out.println("Inicio: " + sessao.getHoraInicio());
                        System.out.println("Termino: " + sessao.getHoraTermino());
                        System.out.println("Filme: " + sessao.getFilme().getTitulo() + ", " + sessao.getFilme().getDuracao()
                                + " min, classificacao " + sessao.getFilme().getClassificacao()
                                + ", " + sessao.getFilme().getCategoria());
                        System.out.println("Capacidade maxima: " + sessao.getCapacidade());
                        System.out.println("Ingressos vendidos: " + sessao.getQtdIngressos());
                        System.out.println("Lugares disponiveis: " + sessao.getLugaresDisponiveis());
                        System.out.printf("Arrecadacao: R$", sessao.getValorArrecadado());
                    } else if (op == 2) {
                        System.out.println("1 - Integral");
                        System.out.println("2 - Meia-entrada");
                        int tipo = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Idade:");
                        int idade = sc.nextInt();
                        sc.nextLine();

                        double antes = sessao.getValorArrecadado();
                        int resultado;
                        if (tipo == 1) {
                            resultado = sessao.venderIngresso(idade);
                        } else {
                            System.out.println("Numero do documento:");
                            resultado = sessao.venderIngresso(idade, sc.nextLine());
                        }

                        if (resultado == 0) {
                            System.out.printf("Valor cobrado: R$ %.2f%n", sessao.getValorArrecadado() - antes);
                        } else if (resultado == -1) {
                            System.out.println("Venda recusada: dados invalidos.");
                        } else if (resultado == -2) {
                            System.out.println("Venda recusada: idade incompativel com a classificacao.");
                        } else {
                            System.out.println("Venda recusada: sem lugar disponivel.");
                        }
                    } else if (op == 3) {
                        System.out.println("Lugares disponiveis: " + sessao.getLugaresDisponiveis());
                    } else if (op == 4) {
                        System.out.println("Termino: " + sessao.getHoraTermino());
                    }
                } while (op != 0);

            } else if (opcao == 3) {
                int op;
                do {
                    System.out.println("\n1 - Consultar o preco integral do ingresso");
                    System.out.println("2 - Alterar o preco integral do ingresso");
                    System.out.println("3 - Consultar os totais de ingressos vendidos e de arrecadacao");
                    System.out.println("0 - Voltar ao menu principal");
                    op = sc.nextInt();
                    sc.nextLine();

                    if (op == 1) {
                        System.out.printf("Preco integral: R$ %.2f%n", Sessao.getPrecoIngresso());
                    } else if (op == 2) {
                        System.out.println("Novo preco:");
                        double novo = Double.parseDouble(sc.nextLine().replace(',', '.'));
                        if (Sessao.setPrecoIngresso(novo)) {
                            System.out.println("Alteracao aceita.");
                        } else {
                            System.out.println("Alteracao recusada.");
                        }
                    } else if (op == 3) {
                        int ingressos = sessao1.getQtdIngressos() + sessao2.getQtdIngressos() + sessao3.getQtdIngressos()
                                + sessao4.getQtdIngressos() + sessao5.getQtdIngressos();
                        double total = sessao1.getValorArrecadado() + sessao2.getValorArrecadado() + sessao3.getValorArrecadado()
                                + sessao4.getValorArrecadado() + sessao5.getValorArrecadado();
                        System.out.println("Ingressos vendidos: " + ingressos);
                        System.out.printf("Arrecadacao total: R$ %.2f%n", total);
                    }
                } while (op != 0);
            }
        } while (opcao != 0);
    }
}