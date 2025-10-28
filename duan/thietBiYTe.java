package duan;

public class thietBiYTe extends quanLyBanThuocYTe {
    private String maTB;
    private String tenTB;
    private String loaiTB;
    private String NSX;
    private String HSD;
    private double donGia;
    private int soLuong;

    public thietBiYTe() {
    }

    public thietBiYTe(thietBiYTe other) {
        this.maTB = other.maTB;
        this.tenTB = other.tenTB;
        this.loaiTB = other.loaiTB;
        this.NSX = other.NSX;
        this.HSD = other.HSD;
        this.donGia = other.donGia;
        this.soLuong = other.soLuong;
    }

    public thietBiYTe(String maTB, String tenTB, String loaiTB, String NSX, String HSD, double donGia, int soLuong) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.loaiTB = loaiTB;
        this.HSD = HSD;
        this.NSX = NSX;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public void setLoaiTB(String loaiTB) {
        this.loaiTB = loaiTB;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    // public double getDonGia() {
    // return donGia;
    // }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return this.soLuong * this.donGia;
    }

    public boolean kiemTraHetHang(){
        return false;
    }

    public boolean kiemTraConHang(){
        return this.soLuong > 0;
    }

}
