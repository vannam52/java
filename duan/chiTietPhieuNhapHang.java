package duan;

import java.util.Scanner;

public class chiTietPhieuNhapHang {
    private String maPNH;
    private String maThuoc;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public chiTietPhieuNhapHang() {
    }

    public chiTietPhieuNhapHang(String maPNH, String maThuoc, int soLuong, double donGia, double thanhTien) {
        this.maPNH = maPNH;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public chiTietPhieuNhapHang(chiTietPhieuNhapHang other) {
        if (other == null)
            return;
        this.maPNH = other.maPNH;
        this.maThuoc = other.maThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double tinhThanhTien() {
        return this.soLuong * this.donGia;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        if (this.maPNH == null || this.maPNH.isEmpty()) {
            System.out.print("Nhap ma phieu nhap: ");
            this.maPNH = sc.nextLine().trim();
        }
        if (this.maThuoc == null || this.maThuoc.isEmpty()) {
            System.out.print("Nhap ma thuoc: ");
            this.maThuoc = sc.nextLine().trim();
        }
        System.out.print("Nhap so luong: ");
        try {
            this.soLuong = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            this.soLuong = 0;
        }
        System.out.print("Nhap don gia: ");
        try {
            this.donGia = Double.parseDouble(sc.nextLine().trim());
        } catch (Exception e) {
            this.donGia = 0.0;
        }
        this.thanhTien = tinhThanhTien();
    }

    public void Xuat() {
        final int W_LABEL = 18;
        final int W_VALUE = 66;

        final int W_BDR_LABEL = W_LABEL + 2; // 20
        final int W_BDR_VALUE = W_VALUE + 2; // 68

        final int CONTENT_WIDTH = W_BDR_LABEL + 1 + W_BDR_VALUE;

        final String LINE_CONTENT = repeatChar('═', W_BDR_LABEL) + "╤" + repeatChar('═', W_BDR_VALUE);

        final String LINE_TOP = "╔" + LINE_CONTENT + "╗";
        final String LINE_MID = "╠" + LINE_CONTENT.replace('╤', '╬') + "╣";
        final String LINE_BOT = "╚" + LINE_CONTENT.replace('╤', '╧') + "╝";

        final String ROW_FMT = "║ %-" + W_LABEL + "s ║ %-" + W_VALUE + "s ║%n";

        System.out.println(LINE_TOP);

        System.out.printf("║%s║%n", center("CHI TIET PHIEU NHAP", CONTENT_WIDTH));
        System.out.println(LINE_MID);

        System.out.printf(ROW_FMT, "Ma phieu nhap:", truncate(maPNH, W_VALUE));
        System.out.printf(ROW_FMT, "Ma thuoc:", truncate(maThuoc, W_VALUE));
        System.out.printf(ROW_FMT, "So luong:", soLuong);
        System.out.printf(ROW_FMT, "Don gia:", String.format("%,.0f VND", donGia));
        System.out.printf(ROW_FMT, "Thanh tien:", String.format("%,.0f VND", thanhTien));

        System.out.println(LINE_BOT);
    }

    private String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String center(String text, int width) {
        if (text == null || text.length() >= width) {
            return truncate(text, width);
        }
        int padding = width - text.length();
        int leftPad = padding / 2;
        int rightPad = padding - leftPad;
        return repeatChar(' ', leftPad) + text + repeatChar(' ', rightPad);
    }

    private String truncate(String text, int width) {
        if (text == null)
            return "";
        if (text.length() <= width) {
            return text;
        }
        if (width < 3) {
            return text.substring(0, width);
        }
        return text.substring(0, width - 3) + "...";
    }

    @Override
    public String toString() {
        return maPNH + "," + maThuoc + "," +
                soLuong + "," + donGia + "," + thanhTien;
    }
}