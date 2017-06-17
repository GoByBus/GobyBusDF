package gobybusenterprise.gobybus.integracao;

import java.util.ArrayList;

/**
 * Created by theolinux on 16/06/17.
 */

public class PosicaoOnibusVO {
    private String idOnibus    = null;
    private String idLinha     = null;
    private String nomeLinha   = null;
    private Double latitude    = null;
    private Double longitude   = null;
    private Double velocidade  = null;
    private String dataHora    = null;

    public PosicaoOnibusVO(){

    }

    public PosicaoOnibusVO(ArrayList<Object> listaDados){
        this.dataHora   = (String) listaDados.get(0);
        this.idOnibus   = (String) listaDados.get(1);
        this.idLinha    = (String) listaDados.get(2);
        this.latitude   = (Double) listaDados.get(3);
        this.longitude  = (Double) listaDados.get(4);
        this.velocidade = (Double) listaDados.get(5);
    }

    public String getIdOnibus() {
        return idOnibus;
    }

    public String getIdLinha() {
        return idLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public String getDataHora() {
        return dataHora;
    }
}
