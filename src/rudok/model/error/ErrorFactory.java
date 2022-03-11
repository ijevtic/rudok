package rudok.model.error;

import rudok.observer.APublisher;

public class ErrorFactory extends APublisher {

    private static ErrorFactory instance = null;
    private ErrorFactory(){}

    public static ErrorFactory getInstance() {
        if(instance == null)
            instance = new ErrorFactory();
        return instance;
    }

    public void makeError(ErrorType type) {
        String [] m = getInstance().errorToInfo(type);
        ErrorClass c = new ErrorClass(m[0], m[1], type);
        notifySubscribers(c);
    }

    private String[] errorToInfo(ErrorType type) {
        String []niz = {"",""};
        if(type == ErrorType.INVALID_FILE_TYPE) {
            niz[0] = "Tip odabranog fajla nije podržan.";
            niz[1] = "images/invalid-file.png";
        }
        if(type == ErrorType.EMPTY_FIELD) {
            niz[0] = "Molimo Vas unesite vrednost u polje.";
            niz[1] = "images/warning.png";
        }
        if(type == ErrorType.ILLEGAL_ACTION) {
            niz[0] = "Akcija nad ovim objektom nije dozvoljena.";
            niz[1] = "images/forbidden.png";
        }
        if(type == ErrorType.NOTHING_SELECTED) {
            niz[0] = "Molimo Vas odaberite selekciju.";
            niz[1] = "images/noselection.png";
        }
        return niz;
    }

}
