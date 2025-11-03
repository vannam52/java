package duan;

import java.util.Scanner;

public class thucPhamChucNang extends Thuoc {
    private String NSX;
    private String HSD;
    private int soLuong;

    public thucPhamChucNang(String ma, String ten, String donVi, double gia, String ngayHH,
            String NSX, String HSD, int soLuong) {
        super(ma, ten, donVi, gia, ngayHH);
        this.NSX = NSX;
        this.HSD = HSD;
        this.soLuong = soLuong;
    }

    public thucPhamChucNang() {
        super();
    }

    public thucPhamChucNang(thucPhamChucNang other) {
        super(other);
        this.NSX = other.NSX;
        this.HSD = other.HSD;
        this.soLuong = other.soLuong;
    }

    // 4. Getters/Setters (Giữ nguyên)
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

    // 5. Sửa lỗi Scanner và Logic trong Nhap()
    @Override
    public void Nhap() {

        Scanner sc = quanLyBanThuocYTe.sc;

        super.NhapMa();

        super.Nhap();

        System.out.print("Nhap NSX: ");
        this.NSX = sc.nextLine().trim();

        String hsd;
        do {
            System.out.print("Nhap HSD (rieng): ");
            hsd = sc.nextLine().trim();
            if (hsd.isEmpty())
                System.out.println(">> Loi: HSD khong duoc de trong. Nhap lai.");
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
                System.out.println(">> Loi: So luong phai la so nguyen khong am. Nhap lai.");
            }
        }
    }

    @Override
    public void Xuat() {
        super.Xuat();

        // In thêm các thuộc tính riêng
        System.out.println("--- Thong Tin Thuc Pham Chuc Nang ---");
        System.out.printf("NSX: %s%n", this.NSX);
        System.out.printf("HSD (rieng): %s%n", this.HSD);
        System.out.printf("So luong: %d%n", this.soLuong);
        System.out.println("-------------------------------------");
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
}