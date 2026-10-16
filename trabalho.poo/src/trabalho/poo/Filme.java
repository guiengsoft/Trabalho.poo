package trabalho.poo;

public class Filme {

    private final String titulo;
    private final int duracao;
    private final int classificacao;
    private String categoria;
    private String sinopse;

    public Filme(String titulo, int duracao, int classificacao) {
        this.titulo = titulo;
        if (duracao > 0) {
            this.duracao = duracao;
        } else {
            this.duracao = 90;
        }
        if (classificacao >= 0) {
            this.classificacao = classificacao;
        } else {
            this.classificacao = 0;
        }
        this.categoria = "Ação";
        this.sinopse = "Não informada";
    }

    public Filme(String titulo, int duracao) {
        this(titulo, duracao, 0);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
 
     //aqui vai tentar alterar a categoria do filme 
    public boolean setCategoria(String novaCategoria) {
    	//Se não veio nada null, recusa antes de comparar, para nao dar erro no programa
        if (novaCategoria == null) {
            return false;
            // Compara o texto digitado com cada categoria permitida, ignorando maiúsculas e minúsculas 
            //Na primeira que bater, grava a categoria escrita do jeito oficial e pula as demais.
        }
        if (novaCategoria.equalsIgnoreCase("Ação")) {
            this.categoria = "Ação";
        } else if (novaCategoria.equalsIgnoreCase("Aventura")) {
            this.categoria = "Aventura";
        } else if (novaCategoria.equalsIgnoreCase("Comédia")) {
            this.categoria = "Comédia";
        } else if (novaCategoria.equalsIgnoreCase("Drama")) {
            this.categoria = "Drama";
        } else if (novaCategoria.equalsIgnoreCase("Terror")) {
            this.categoria = "Terror";
        } else {
            return false;
        }
        return true;
    }
    //Retorna true se a idade não for negativa e for maior ou igual à classificação do filme; senão, false.
    public boolean podeAssistir(int idade) {
        return idade >= 0 && idade >= classificacao;
    }
}