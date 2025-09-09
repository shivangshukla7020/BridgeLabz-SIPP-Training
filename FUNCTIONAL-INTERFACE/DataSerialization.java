import java.io.Serializable;

class BackupData implements Serializable {
    private String data;

    public BackupData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}