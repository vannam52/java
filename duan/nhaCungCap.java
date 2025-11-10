package duan;

import java.util.Scanner;

public class nhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sdt;

    public nhaCungCap() {
    }

    public nhaCungCap(nhaCungCap other) {
        this.maNCC = other.maNCC;
        this.tenNCC = other.tenNCC;
        this.diaChi = other.diaChi;
        this.sdt = other.sdt;
    }

    public nhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.print("║ Nhap ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.print("║ Nhap ten nha cung cap: ");
        tenNCC = sc.nextLine();
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.print("║ Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.print("║ Nhap so dien thoai: ");
        sdt = sc.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
    }

    public void Xuat() {
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ MA NHA CUNG CAP    : %-45s ║%n", maNCC);
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ TEN NHA CUNG CAP   : %-45s ║%n", tenNCC);
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ DIA CHI            : %-45s ║%n", diaChi);
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ SO DIEN THOAI      : %-45s ║%n", sdt);
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
    }
}