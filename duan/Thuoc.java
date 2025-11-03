package duan;

import java.util.Scanner;

public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private String donViTinh;
    private double giaBan;
    private String ngayHetHan;

    public Thuoc() {}

    public Thuoc(Thuoc other) {
        this.maThuoc = other.maThuoc;
        this.tenThuoc = other.tenThuoc;
        this.donViTinh = other.donViTinh;
        this.giaBan = other.giaBan;
        this.ngayHetHan = other.ngayHetHan;
    }

    public Thuoc(String maThuoc, String tenThuoc, String donViTinh, double giaBan, String ngayHetHan) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donViTinh = donViTinh;
        this.giaBan = giaBan;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters & Setters
    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    // Nhập mã thuốc (dùng khi thêm mới)
    public void NhapMa() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhap ma thuoc (TH...): ");
            this.maThuoc = sc.nextLine();
            if (this.maThuoc.trim().isEmpty()) {
                System.out.println(">> Loi: Ma thuoc khong duoc de trong.");
            }
        } while (this.maThuoc.trim().isEmpty());
    }

    // Nhập thông tin thuốc (không nhập mã)
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap ten thuoc: ");
        this.tenThuoc = sc.nextLine();
        
        System.out.print("Nhap don vi tinh: ");
        this.donViTinh = sc.nextLine();
        
        boolean nhapSai;
        do {
            nhapSai = false;
            System.out.print("Nhap gia ban: ");
            try {
                this.giaBan = Double.parseDouble(sc.nextLine());
                if (this.giaBan < 0)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println(">> Loi: Gia ban phai la so duong.");
                nhapSai = true;
            }
        } while (nhapSai);
        
        System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
        this.ngayHetHan = sc.nextLine();
    }

    // Xuất thông tin đầy đủ (dạng box)
    public void Xuat() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   THONG TIN CHI TIET THUOC                       ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Ma thuoc: %-54s ║%n", maThuoc);
        System.out.printf("║ Ten thuoc: %-53s ║%n", tenThuoc);
        System.out.printf("║ Don vi tinh: %-51s ║%n", donViTinh);
        System.out.printf("║ Gia ban: %-55.2f ║%n", giaBan);
        System.out.printf("║ Ngay het han: %-50s ║%n", ngayHetHan);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Sửa thông tin thuốc
    public void suaThongTinThuoc(Scanner sc) {
        System.out.println("--- Cap nhat thong tin Thuoc ---");
        System.out.println("(Bo trong neu khong muon thay doi)");

        System.out.print("Ten thuoc moi: ");
        String tenMoi = sc.nextLine();
        if (!tenMoi.isEmpty())
            this.tenThuoc = tenMoi;

        System.out.print("Don vi tinh moi: ");
        String donViMoi = sc.nextLine();
        if (!donViMoi.isEmpty())
            this.donViTinh = donViMoi;

        System.out.print("Gia ban moi: ");
        String giaStr = sc.nextLine();
        if (!giaStr.isEmpty()) {
            try {
                double giaMoi = Double.parseDouble(giaStr);
                if (giaMoi >= 0)
                    this.giaBan = giaMoi;
            } catch (NumberFormatException e) {
                System.out.println(">> Gia khong hop le, giu nguyen gia cu");
            }
        }

        System.out.print("Ngay het han moi: ");
        String ngayMoi = sc.nextLine();
        if (!ngayMoi.isEmpty())
            this.ngayHetHan = ngayMoi;

        System.out.println("✓ Cap nhat thanh cong!");
    }
}