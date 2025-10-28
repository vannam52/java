package duan;

public class thucPhamChucNang extends quanLyBanThuocYTe {
    private String maTP;
    private String tenTP;
    private String NSX;
    private String HSD;
    private double donGia;
    private int soLuong;

    public thucPhamChucNang() {
    }

    public thucPhamChucNang(thucPhamChucNang other) {
        this.maTP = other.maTP;
        this.tenTP = other.tenTP;
        this.NSX = other.NSX;
        this.HSD = other.HSD;
        this.donGia = other.donGia;
        this.soLuong = other.soLuong;
    }

    public thucPhamChucNang(String maTP, String tenTP, String NSX, String HSD, double donGia, int soLuong) {
        this.maTP = maTP;
        this.tenTP = tenTP;
        this.HSD = HSD;
        this.NSX = NSX;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaTP() {
        return maTP;
    }

    public void setMaTP(String maTP) {
        this.maTP = maTP;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
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

}
