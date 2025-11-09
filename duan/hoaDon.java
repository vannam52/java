package duan;

import java.util.Scanner;

public class hoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String ngayLap;
    private double tongTien;
    public chiTietHoaDon[] chiTietHoaDon;
    private int soLuongChiTiet;

    public hoaDon() {
        this.chiTietHoaDon = new chiTietHoaDon[0];
        this.soLuongChiTiet = 0;
    }

    public hoaDon(hoaDon other) {
        this.maHD = other.maHD;
        this.maKH = other.maKH;
        this.maNV = other.maNV;
        this.ngayLap = other.ngayLap;
        this.tongTien = other.tongTien;
        this.soLuongChiTiet = other.soLuongChiTiet;
        this.chiTietHoaDon = new chiTietHoaDon[other.soLuongChiTiet];
        for (int i = 0; i < other.soLuongChiTiet; i++) {
            this.chiTietHoaDon[i] = new chiTietHoaDon(other.chiTietHoaDon[i]);
        }
    }

    public hoaDon(String maHD, String maKH, String maNV, String ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.chiTietHoaDon = new chiTietHoaDon[0];
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

    public chiTietHoaDon[] getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(chiTietHoaDon[] chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double tinhTongTien() {
        this.tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            this.tongTien += chiTietHoaDon[i].getThanhTien();
        }
        return this.tongTien;
    }

    public void taoHoaDon() {
        System.out.println("Hoa don tao tu ma la: " + maHD);
    }

    public void xoaHoaDon() {
        System.out.println("Hoa don bi xoa co ma la: " + maHD);
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin hoa don:");
        System.out.print("Nhap ma HD: ");
        this.maHD = sc.nextLine();
        System.out.print("Nhap ma KH: ");
        this.maKH = sc.nextLine();
        System.out.print("Nhap ma NV: ");
        this.maNV = sc.nextLine();
        while (true) {
            try {
                System.out.print("Nhap ngay lap (dd/mm/yyyy): ");
                this.ngayLap = sc.nextLine();
                String[] parts = this.ngayLap.split("/");
                if (parts.length != 3) {
                    throw new Exception("Ngay lap khong hop le");
                }
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2025) {
                    throw new Exception("Ngay lap khong hop le");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + ". Vui long nhap lai.");
            }
        }
        while (true) {
            try {
                System.out.print("Nhap so luong chi tiet hoa don: ");
                this.soLuongChiTiet = Integer.parseInt(sc.nextLine());
                if (this.soLuongChiTiet <= 0) {
                    System.out.println("So luong phai lon hon 0. Vui long nhap lai.");
                    continue;
                }
                this.chiTietHoaDon = new chiTietHoaDon[this.soLuongChiTiet];
                break;
            } catch (NumberFormatException e) {
                System.out.println("So luong chi tiet hoa don khong hop le. Vui long nhap lai.");
            }
        }
        for (int i = 0; i < this.soLuongChiTiet; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ": ");
            this.chiTietHoaDon[i] = new chiTietHoaDon();
            this.chiTietHoaDon[i].setMaHD(this.maHD);
            this.chiTietHoaDon[i].Nhap();
        }
        this.tongTien = this.tinhTongTien();
    }

    public void Xuat() {
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════";

        System.out.println("╔" + LINE + "╗");
        System.out.println("║                                  HOA DON BAN THUOC                                   ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma hoa don: %-72s ║%n", maHD);
        System.out.printf("║ Ma khach hang: %-69s ║%n", maKH);
        System.out.printf("║ Ma nhan vien: %-70s ║%n", maNV);
        System.out.printf("║ Ngay lap: %-74s ║%n", ngayLap);
        System.out.println("╠" + LINE + "╣");
        System.out.println("║                             DANH SACH CHI TIET HOA DON                               ║");
        System.out.println("╠" + LINE + "╣");
        if (soLuongChiTiet > 0 && chiTietHoaDon != null) {
            for (int i = 0; i < soLuongChiTiet; i++) {
                System.out.printf("║ [%02d] %-79s ║%n", (i + 1), "Chi tiet hoa don:");
                chiTietHoaDon[i].Xuat();
                if (i < soLuongChiTiet - 1)
                    System.out.println("╠" + LINE + "╣");
            }
        } else {
            System.out.println(
                    "║ (Khong co chi tiet hoa don)                                                          ║");
        }

        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Tong tien: %-69.0f VND ║%n", tongTien);
        System.out.println("╚" + LINE + "╝");
    }
}