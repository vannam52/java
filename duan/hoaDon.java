package duan;

public class hoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String ngayLap;
    private double tongTien;
    private chiTietHoaDon[] chiTietHoaDons;
    private int soLuongChiTiet;
    private final int MAX_CHI_TIET = 100;

    public hoaDon() {
    }

    public hoaDon(hoaDon other){
        this.maHD = other.maHD;
        this.maKH = other.maKH;
        this.maNV = other.maNV;
        this.ngayLap = other.ngayLap;
        this.tongTien = other.tongTien;
        this.soLuongChiTiet = other.soLuongChiTiet;
        this.chiTietHoaDons = new chiTietHoaDon[MAX_CHI_TIET];
        for (int i = 0; i < other.soLuongChiTiet; i++){
            this.chiTietHoaDons[i] = new chiTietHoaDon(other.chiTietHoaDons[i]);
        }
    }

    public hoaDon(String maHD, String maKH, String maNV, String ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.chiTietHoaDons = new chiTietHoaDon[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
    }

    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public void tinhTongTien(double tien) {
        this.tongTien += tien;
    }
 

}

