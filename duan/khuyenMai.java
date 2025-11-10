package duan;

import java.util.Scanner;

public class khuyenMai {
    private String maKM;
    private String tenKM;
    private double phanTramGiamGia;
    private String ngayBD;
    private String ngayKT;

    public khuyenMai() {
    }

    public khuyenMai(String maKM, String tenKM, double phanTramGiamGia, String ngayBD, String ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public khuyenMai(khuyenMai other) {
        this.maKM = other.maKM;
        this.tenKM = other.tenKM;
        this.phanTramGiamGia = other.phanTramGiamGia;
        this.ngayBD = other.ngayBD;
        this.ngayKT = other.ngayKT;
    }

    public String getMaKM() {
        return maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khuyen mai: ");
        this.maKM = sc.nextLine();
        System.out.print("Nhap ten khuyen mai: ");
        this.tenKM = sc.nextLine();
        System.out.print("Nhap phan tram giam gia (%): ");
        try {
            this.phanTramGiamGia = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Phan tram giam gia khong hop le, dat ve 0!");
            this.phanTramGiamGia = 0;
        }
        System.out.print("Nhap ngay bat dau KM (dd/mm/yyyy): ");
        this.ngayBD = sc.nextLine();
        System.out.print("Nhap ngay ket thuc KM (dd/mm/yyyy): ");
        this.ngayKT = sc.nextLine();
    }

    public void Xuat() {
        final String LINE = "═══════════════════════════════════════════════════════════════════════════════";
        final int W = 77;
        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ---------------------- THONG TIN KHUYEN MAI --------------------------------- ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma KM: %-" + (W - 7) + "s ║%n", maKM);
        System.out.printf("║ Ten KM: %-" + (W - 8) + "s ║%n", tenKM);
        System.out.printf("║ Phan tram giam gia: %-" + (W - 21) + ".2f  ║%n", phanTramGiamGia);
        System.out.printf("║ Ngay bat dau: %-" + (W - 14) + "s ║%n", ngayBD);
        System.out.printf("║ Ngay ket thuc: %-" + (W - 15) + "s ║%n", ngayKT);
        System.out.println("╚" + LINE + "╝");
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-8.2f%% | %-15s | %-15s |",
                maKM,
                tenKM,
                phanTramGiamGia,
                ngayBD,
                ngayKT);
    }
}