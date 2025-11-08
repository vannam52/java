// package duan;

// import java.util.Scanner;

// public class PhieuNhapHang {
//     private String maPNH;
//     private String maNV;
//     private String maNCC;
//     private String ngayNhap; // dd/MM/yyyy (chuoi)
//     private double tongTien;

//     public PhieuNhapHang() {
//     }

//     public PhieuNhapHang(String maPNH, String maNV, String maNCC, String ngayNhap, double tongTien) {
//         this.maPNH = maPNH;
//         this.maNV = maNV;
//         this.maNCC = maNCC;
//         this.ngayNhap = ngayNhap;
//         this.tongTien = tongTien;
//     }

//     public PhieuNhapHang(PhieuNhapHang other) {
//         if (other == null)
//             return;
//         this.maPNH = other.maPNH;
//         this.maNV = other.maNV;
//         this.maNCC = other.maNCC;
//         this.ngayNhap = other.ngayNhap;
//         this.tongTien = other.tongTien;
//     }

//     public String getMaPNH() {
//         return maPNH;
//     }

//     public void setMaPNH(String maPNH) {
//         this.maPNH = maPNH;
//     }

//     public String getMaNV() {
//         return maNV;
//     }

//     public void setMaNV(String maNV) {
//         this.maNV = maNV;
//     }

//     public String getMaNCC() {
//         return maNCC;
//     }

//     public void setMaNCC(String maNCC) {
//         this.maNCC = maNCC;
//     }

//     public String getNgayNhap() {
//         return ngayNhap;
//     }

//     public void setNgayNhap(String ngayNhap) {
//         this.ngayNhap = ngayNhap;
//     }

//     public double getTongTien() {
//         return tongTien;
//     }

//     public void setTongTien(double tongTien) {
//         this.tongTien = tongTien;
//     }

//     // input / output
//     public void nhap() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap ma phieu nhap: ");
//         this.maPNH = sc.nextLine();
//         System.out.print("Nhap ma nhan vien: ");
//         this.maNV = sc.nextLine();
//         System.out.print("Nhap ma nha cung cap: ");
//         this.maNCC = sc.nextLine();
//         System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
//         this.ngayNhap = sc.nextLine();
//         System.out.print("Nhap tong tien: ");
//         this.tongTien = Double.parseDouble(sc.nextLine());
//     }

//     public void hienThiPhieuNhapHang() {
//         System.out.println("Ma phieu nhap: " + maPNH);
//         System.out.println("Ma nhan vien: " + maNV);
//         System.out.println("Ma nha cung cap: " + maNCC);
//         System.out.println("Ngay nhap: " + ngayNhap);
//         System.out.println("Tong tien: " + tongTien + " VND");
//     }

//     public void Xuat() {
//         final String LINE = "══════════════════════════════════════════════════════════════════════════════════════";
//         final String ROW_FMT = "║ %-18s %-66s ║%n";

//         System.out.println("╔" + LINE + "╗");
//         System.out
//                 .println("║                                PHIEU NHAP HANG                                         ║");
//         System.out.println("╠" + LINE + "╣");
//         System.out.printf(ROW_FMT, "Ma phieu nhap:", maPNH);
//         System.out.println("╠" + LINE + "╣");
//         System.out.printf(ROW_FMT, "Ma nhan vien:", maNV);
//         System.out.printf(ROW_FMT, "Ma nha cung cap:", maNCC);
//         System.out.printf(ROW_FMT, "Ngay nhap:", ngayNhap);
//         System.out.printf(ROW_FMT, "Tong tien: VND", tongTien);
//         System.out.println("╚" + LINE + "╝");
//     }

//     public void taoPhieuNhapHang() {
//         System.out.println("Da tao phieu nhap: " + maPNH);
//     }

//     public void xoaPhieuNhapHang() {
//         System.out.println("Da xoa phieu nhap: " + maPNH);
//     }

//     @Override
//     public String toString() {
//         return maPNH + "," + maNV + "," + maNCC + "," + ngayNhap + "," + tongTien;
//     }
// }