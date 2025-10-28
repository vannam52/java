package duan;

public class phieuNhapHang {
    private String maPNH;
    private String maNV;
    private String maNCC;
    private String ngayNhap;
    private double tongTien;

    public phieuNhapHang(){}

    public phieuNhapHang(phieuNhapHang other){
        this.maPNH = other.maPNH;
        this.maNV = other.maNV;
        this.maNCC = other.maNCC;
        this.ngayNhap = other.ngayNhap;
        this.tongTien = other.tongTien;
    }

    public phieuNhapHang(String maPNH, String maNV, String maNCC, String ngayNhap, double tongTien) {
        this.maPNH = maPNH;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }
    public String getMaPNH() {
        return maPNH;
    }
    public String getMaNV() {
        return maNV;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public String getNgayNhap() {
        return ngayNhap;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void tinhTongTien(double tien) {
        this.tongTien += tien;
    }
    public void taoPhieuNhapHang(){
        System.out.println("Phieu nhap hang tao tu ma la: " + maPNH);
    }
    public void xoaPhieuNhapHang(){
        System.out.println("Phieu nhap hang bi xoa co ma la: " + maPNH);
    }

    public void taoPhieuNhap(){
        System.out.println("Phieu nhap hang duoc tao voi ma la: " + maPNH);
    }   
    public void hienThiPhieuNhap(){
        System.out.println("Ma phieu nhap hang: " + maPNH);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Tong tien: " + tongTien);
    }

    public void tinhTongTien(){
        System.out.println("Tong tien phieu nhap hang voi ma " + maPNH + " la: " + tongTien);
    }
}
