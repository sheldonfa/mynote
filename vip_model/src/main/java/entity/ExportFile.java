package entity;

import java.io.FileInputStream;

public class ExportFile {

    private String fileName;

    private FileInputStream file;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileInputStream getFile() {
        return file;
    }

    public void setFile(FileInputStream file) {
        this.file = file;
    }
}
