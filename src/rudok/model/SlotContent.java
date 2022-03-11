package rudok.model;

import java.io.Serializable;

public class SlotContent implements Serializable {
    String s="";
    public SlotContent(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
