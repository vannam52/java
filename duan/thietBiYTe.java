package duan;

import java.util.Scanner;

public class thietBiYTe extends Thuoc {
    private String loaiTB;
    private String NSX;
    private String HSD;
    private int soLuong;

    public thietBiYTe() {
    }

    public thietBiYTe(thietBiYTe other) {
        super(other);
        this.loaiTB = other.loaiTB;
        this.NSX = other.NSX;
        this.HSD = other.HSD;
        this.soLuong = other.soLuong;
    }

    public thietBiYTe(String ma, String ten, String dv, double gia, String ngayHH,
            String loaiTB, String NSX, String HSD, int soLuong) {
        super(ma, ten, dv, gia, ngayHH);
        this.loaiTB = loaiTB;
        this.NSX = NSX;
        this.HSD = HSD;
        this.soLuong = soLuong;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public void setLoaiTB(String loaiTB) {
        this.loaiTB = loaiTB;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return getGiaBan() * this.soLuong;
    }

    public boolean kiemTraHetHang() {
        return this.soLuong <= 0;
    }

    public boolean kiemTraConHang() {
        return this.soLuong > 0;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.NhapMa();
        System.out.print("Nhap ten thiet bi: ");
        String ten;
        do {
            ten = sc.nextLine().trim();
            if (ten.isEmpty())
                System.out.println("Ten khong duoc de trong. Nhap lai:");
        } while (ten.isEmpty());
        setTenThuoc(ten);

        System.out.print("Nhap don vi tinh: ");
        String dv;
        do {
            dv = sc.nextLine().trim();
            if (dv.isEmpty())
                System.out.println("Don vi tinh khong duoc de trong. Nhap lai:");
        } while (dv.isEmpty());
        setDonViTinh(dv);

        while (true) {
            System.out.print("Nhap gia ban: ");
            try {
                double g = Double.parseDouble(sc.nextLine());
                if (g < 0)
                    throw new NumberFormatException();
                setGiaBan(g);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Gia ban phai la so duong. Nhap lai.");
            }
        }

        System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
        String nh;
        do {
            nh = sc.nextLine().trim();
            if (nh.isEmpty())
                System.out.println("Ngay het han khong duoc de trong. Nhap lai:");
        } while (nh.isEmpty());
        setNgayHetHan(nh);

        // Trường riêng
        System.out.print("Nhap loai thiet bi: ");
        this.loaiTB = sc.nextLine();

        System.out.print("Nhap NSX: ");
        this.NSX = sc.nextLine();

        System.out.print("Nhap HSD (dd/mm/yyyy): ");
        String hsd;
        do {
            hsd = sc.nextLine().trim();
            if (hsd.isEmpty())
                System.out.println("HSD khong duoc de trong. Nhap lai:");
        } while (hsd.isEmpty());
        this.HSD = hsd;

        while (true) {
            System.out.print("Nhap so luong: ");
            try {
                int sl = Integer.parseInt(sc.nextLine());
                if (sl < 0)
                    throw new NumberFormatException();
                this.soLuong = sl;
                break;
            } catch (NumberFormatException e) {
                System.out.println("So luong phai la so nguyen khong am. Nhap lai.");
            }
        }
    }

    @Override
    public void Xuat() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║               THONG TIN CHI TIET THIET BI Y TE                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Ma: %-60s ║%n", getMaThuoc());
        System.out.printf("║ Ten: %-59s ║%n", getTenThuoc());
        System.out.printf("║ Don vi tinh: %-51s ║%n", getDonViTinh());
        System.out.printf("║ Gia ban: %-56.2f ║%n", getGiaBan());
        System.out.printf("║ Ngay het han: %-50s ║%n", getNgayHetHan());
        System.out.printf("║ Loai: %-57s ║%n", this.loaiTB);
        System.out.printf("║ NSX: %-59s ║%n", this.NSX);
        System.out.printf("║ HSD: %-59s ║%n", this.HSD);
        System.out.printf("║ So luong: %-55d ║%n", this.soLuong);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }
}
