package gobybusenterprise.gobybus.integracao;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

/**
 * Created by theolinux on 16/06/17.
 */

public class OnibusGPSService {
    private String urlViacao = "http://www.geodftrans.dftrans.df.gov.br:8080/PosicaoGeoService/get-tempo-real";
    private GoogleMap googleMapAtual;
    private String idLinha    = "";
    private String idOnibus   = "";
    boolean isPontoOnibusShow = false;
    private int delayUpdateMapa = 10;
    private int delayUpdateService = 10;
    private ArrayList<PosicaoOnibusVO> listaOnibusGeral = new ArrayList<PosicaoOnibusVO>();
    private ArrayList<PosicaoOnibusVO> listaOnibusFiltro = new ArrayList<PosicaoOnibusVO>();

    public void plotarPins(GoogleMap googleMap){
        this.googleMapAtual = googleMap;
        temporizadorService();
    }

    public void filtrarPosicao(){
        listaOnibusFiltro.clear();
        for (PosicaoOnibusVO item: listaOnibusGeral) {
            if(!idLinha.equals("")){
                if(item.getIdLinha().equalsIgnoreCase(idLinha)) {
                    listaOnibusFiltro.add(item);
                }
            }
            else if(!idOnibus.equalsIgnoreCase("")) {
                if (item.getIdOnibus().equalsIgnoreCase(idOnibus)) {
                    listaOnibusFiltro.add(item);
                }
            }
        }
    }

    private void temporizadorMapa(){
        int delay = 5000;   // delay de 5 seg.
        int interval = delayUpdateMapa * 1000;  // intervalo de 1 seg.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // colocar tarefas aqui ...
            }
        }, delay, interval);
    }

    private void temporizadorService(){
        int delay = 5000;   // delay de 5 seg.
        int interval = delayUpdateService * 1000;  // intervalo de 1 seg.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                obterDados();
            }
        }, delay, interval);
    }

    private void obterDados(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                ativarServico();
            }
        });
    }


    private void ativarServico(){

// Create URL
        URL dfTrans = null;
        try {
            dfTrans = new URL(urlViacao);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

// Create connection
        try {
            HttpURLConnection myConnection =
                    (HttpURLConnection) dfTrans.openConnection();

            // myConnection.setRequestProperty("Accept","application/vnd.github.v3+json");
            myConnection.setRequestProperty("content-type", "text/plain; charset=utf-8");

            if (myConnection.getResponseCode() == 200) {
                Log.d("Response","200");
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader =
                        new InputStreamReader(responseBody, "UTF-8");

                BufferedReader buf = new BufferedReader(responseBodyReader);

                StringBuilder sb = new StringBuilder();
                String s;
                while(true )
                {
                    s = buf.readLine();
                    if(s==null || s.length()==0)
                        break;
                    sb.append(s);

                }
                buf.close();

                //Log.d("Response",sb.toString());
                responseBodyReader.close();
                myConnection.disconnect();

                carregarGPSFrota(sb.toString());
                //Toast.makeText(this, "200", Toast.LENGTH_LONG).show();

            } else {
                //Toast.makeText(this, "Cancel pressed"+myConnection.getResponseCode(), Toast.LENGTH_LONG).show();
                Log.d("Response",""+myConnection.getResponseCode());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarGPSFrota(String json){
        this.listaOnibusGeral.clear();
        //String dados = "{\"COLUMNS\":[\"DATAHORA\",\"ORDEM\",\"LINHA\",\"LATITUDE\",\"LONGITUDE\",\"VELOCIDADE\"],\"DATA\":[[\"16-06-2017 20:16:34\",\"442615\",\"0.301\",-15.805243,-48.074204,46],[\"16-06-2017 19:58:38\",\"442330\",\"09997\",-15.839937,-48.129713,15],[\"16-06-2017 20:11:20\",\"442666\",\"0.339\",-15.84024,-48.126743,23]]}";
        Gson gson = new Gson();

        JsonVO retorno = gson.fromJson(json, JsonVO.class);
        for (int i = 0; i < retorno.getDATA().length; i++) {
            PosicaoOnibusVO posicao = new PosicaoOnibusVO((ArrayList<Object>) retorno.getDATA()[0]);
            this.listaOnibusGeral.add(posicao);
        }
    }

    public String getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(String idLinha) {
        this.idLinha = idLinha;
    }

    public String getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(String idOnibus) {
        this.idOnibus = idOnibus;
    }

    public boolean isPontoOnibusShow() {
        return isPontoOnibusShow;
    }

    public void setPontoOnibusShow(boolean pontoOnibusShow) {
        isPontoOnibusShow = pontoOnibusShow;
    }

    public int getDelayUpdateMapa() {
        return delayUpdateMapa;
    }

    public void setDelayUpdateMapa(int delayUpdateMapa) {
        this.delayUpdateMapa = delayUpdateMapa;
    }

    public int getDelayUpdateService() {
        return delayUpdateService;
    }

    public void setDelayUpdateService(int delayUpdateService) {
        this.delayUpdateService = delayUpdateService;
    }
}


