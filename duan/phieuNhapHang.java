package duan;

import java.util.Scanner;

public class phieuNhapHang {
    private String maPNH;
    private String maNV;
    private String maNCC;
    private String ngayNhap;
    private double tongTien;

    public phieuNhapHang() {}

    public phieuNhapHang(String maPNH, String maNV, String maNCC, String ngayNhap, double tongTien) {
        this.maPNH = maPNH;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public phieuNhapHang(phieuNhapHang other) {
        if (other == null) return;
        this.maPNH = other.maPNH;
        this.maNV = other.maNV;
        this.maNCC = other.maNCC;
        this.ngayNhap = other.ngayNhap;
        this.tongTien = other.tongTien;
    }

    public String getMaPNH() { return maPNH; }
    public void setMaPNH(String maPNH) { this.maPNH = maPNH; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }
    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    public void nhapPhieuNhapHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma cua phieu nhap hang: ");
        this.maPNH = sc.nextLine();
        System.out.println("Nhap ma nhan vien: "); 
        this.maNV = sc.nextLine();
        System.out.println("Nhap ma nha cung cap: "); 
        this.maNCC = sc.nextLine();
        System.out.println("Nhap ngay nhap (dd/MM/yyyy): "); 
        this.ngayNhap = sc.nextLine();
        System.out.println("Nhap tong tien: ");
        this.tongTien = sc.nextDouble();
        sc.nextLine();
        System.out.println("nhap thong tin thanh cong.");
    }

    public void Xuat() {
        final String LINE = "═════════════════════════════════════════════════════════════════════════════";
        final int W = 77; 

        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ------------------- THONG TIN PHIEU NHAP HANG ---------------------------   ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma phieu nhap hang: %-" + (W - 22) + "s ║%n", maPNH);
        System.out.printf("║ Ma nhan vien: %-" + (W - 16) + "s ║%n", maNV);
        System.out.printf("║ Ma nha cung cap: %-" + (W - 19) + "s ║%n", maNCC);
        System.out.printf("║ Ngay nhap: %-" + (W - 13) + "s ║%n", ngayNhap);
        System.out.printf("║ Tong tien: %-" + (W - 13) + ".2f ║%n", tongTien);
        System.out.println("╚" + LINE + "╝");
    }

    @Override
    public String toString() {
        return "Mã PNH: " + maPNH +
                ", Mã NV: " + maNV +
                ", Mã NCC: " + maNCC +
                ", Ngày Nhập: " + ngayNhap +
                ", Tổng Tiền: " + tongTien;
    }
}