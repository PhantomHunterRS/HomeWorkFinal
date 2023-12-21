public class NoteBook {
    private int ram;
    private int ssd;
    private String operSyst;
    private String color;

    public NoteBook(int ram , int ssd) {
        setRam(ram);
        setSsd(ssd);
        this.operSyst = "withOut_OS";
        this.color = "white";
    }
    public NoteBook(int ram, int ssd, String operSyst, String color) {
        setRam(ram);
        setSsd(ssd);
        this.operSyst = operSyst;
        this.color = color;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        int multiplicity = ram/8;
        ram = (multiplicity ==0)?8:8*multiplicity;
        if (ram >256){
            this.ram = 256;
        }else {
            this.ram = ram;
        }
    }
    public int getSsd() {
        return ssd;
    }
    public void setSsd(int ssdM2) {
        int multiplicity = ssdM2/128;
        this.ssd = (multiplicity == 0)?ssdM2*1:ssdM2;
    }
    public String getOperSyst() {
        return operSyst;
    }
    public void setOperSyst(String operSyst) {
        this.operSyst = operSyst;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "ram=" + ram +
                ", ssd=" + ssd +
                ", operSyst='" + operSyst + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
