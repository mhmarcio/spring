package com.welyab.teste.programador.springboottestebasico.extra.provaconceitos.web.alternativas;

public abstract class AbstractAlternativa implements Alternativa {
    private final LetraAlternativa letraAlternativa;
    private final String respostaTextual;

    public AbstractAlternativa(LetraAlternativa letraAlternativa, String respostaTextual) {
        this.letraAlternativa = letraAlternativa;
        this.respostaTextual = respostaTextual;
    }

    @Override
    public LetraAlternativa getLetraAlternativa() {
        return letraAlternativa;
    }

    @Override
    public String getRespostaTextual() {
        return respostaTextual;
    }
}
