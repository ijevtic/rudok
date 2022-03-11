package rudok.utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {

    @Override
    public String getDescription() {
        return "GrafEditor Project Files (*.gpf)";
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".gpf"));
    }

}

