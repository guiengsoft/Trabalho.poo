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

    public boolean setCategoria(String novaCategoria) {
        if (novaCategoria == null) {
            return false;
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

    public boolean podeAssistir(int idade) {
        return idade >= 0 && idade >= classificacao;
    }
}