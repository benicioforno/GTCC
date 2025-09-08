package br.com.benicioforno.GTCC.Model;

public enum Status {
    DISPONIVEL("Disponível"),
    ACEITA("Aceita"),
    EM_ANALISE("Em análise");

    private String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
