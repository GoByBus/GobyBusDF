package gobybusenterprise.gobybus.integracao;

/**
 * Created by theolinux on 16/06/17.
 */

public class JsonVO {
    public String COLUMNS [];
    public Object DATA [];

    public String[] getCOLUMNS() {
        return COLUMNS;
    }

    public void setCOLUMNS(String[] COLUMNS) {
        this.COLUMNS = COLUMNS;
    }

    public Object[] getDATA() {
        return DATA;
    }

    public void setDATA(Object[] DATA) {
        this.DATA = DATA;
    }
}
