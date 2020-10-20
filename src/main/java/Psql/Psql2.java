package Psql;

import java.text.DecimalFormat;

public class Psql2 {
    private String cno = new String();
    private double avg;
//    private DecimalFormat df = new DecimalFormat( "0.00");
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {

        this.avg = avg;
    }
}
