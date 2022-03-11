package rudok.command;

import rudok.model.logictree.RuNode;

public class RenameNodeCommand implements AbstractCommand{

    private RuNode cvor;
    private String novoIme;
    private String staroIme;


    public RenameNodeCommand(RuNode cvor, String novoIme) {
        this.cvor = cvor;
        this.novoIme = novoIme;
    }

    @Override
    public void doCommand() {
        this.staroIme = this.cvor.getIme();
        this.cvor.setIme(novoIme);
    }

    @Override
    public void undoCommand() {
        this.cvor.setIme(staroIme);
    }
}
