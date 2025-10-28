package duan;

public class chiTietPhieuNhapHang {
    private String maPNH;
    private String maThuoc;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public chiTietPhieuNhapHang() {
    }

    public chiTietPhieuNhapHang(chiTietPhieuNhapHang other){
        this.maPNH = other.maPNH;
        this.maThuoc = other.maThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    public chiTietPhieuNhapHang(String maPNH, String maThuoc, int soLuong, double donGia) {
        this.maPNH = maPNH;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }
    public String getMaPNH() {
        return maPNH;
    }
    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }
    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public double getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    public void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }
}
