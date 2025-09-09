interface DataExport {
    void exportCSV();
    void exportPDF();

    default void exportToJSON() {
        System.out.println("Exporting data in JSON format.");
    }
}

class ReportModule implements DataExport {
    public void exportCSV() {
        System.out.println("Exporting data in CSV format.");
    }
    public void exportPDF() {
        System.out.println("Exporting data in PDF format.");
    }
}