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

    public void nhapThongTinNCC() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma NCC la: ");
        maNCC = sc.nextLine();
        System.out.println("Ten NCC la: ");
        tenNCC = sc.nextLine();
        System.out.println("Dia chi la: ");
        diaChi = sc.nextLine();
        System.out.println("So dien thoai la: ");
        sdt = sc.nextLine();
    }

    public void hienThiNCC() {
        System.out.println("Ma nha cung cap la: " + this.maNCC + " Ten nha cung cap la: "
            + this.tenNCC + " Dia chi la: " + this.diaChi + " So dien thoai la: " + this.sdt);
    }
}
