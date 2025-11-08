package duan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class danhSachHoaDon implements ChucNang, IFile {
    public hoaDon[] dsHoaDon;
    public int soLuongHoaDon;
    final int MAX_HOA_DON = 100;

    private static Scanner sc = new Scanner(System.in);

    public danhSachHoaDon() {
        dsHoaDon = new hoaDon[0];
        soLuongHoaDon = 0;
    }

    public danhSachHoaDon(danhSachHoaDon other) {
        this.soLuongHoaDon = other.soLuongHoaDon;
        this.dsHoaDon = new hoaDon[other.soLuongHoaDon];
        for (int i = 0; i < other.soLuongHoaDon; i++) {
            this.dsHoaDon[i] = new hoaDon(other.dsHoaDon[i]);
        }
    }

    public boolean kiemTraMa(String maHD) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equals(maHD))
                return true;
        }
        return false;
    }

    public void themHoaDon(hoaDon hd) {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day");
            return;
        }
        String maHD;
        while (kiemTraMa(hd.getMaHD())) {
            System.out.print("Nhap ma hoa don khac: ");
            maHD = sc.nextLine();
            if (!kiemTraMa(maHD)) {
                hd.setMaHD(maHD);
                break;
            }
            System.out.println("Ma hoa don bi trung, vui long nhap lai!");
        }
        this.dsHoaDon = Arrays.copyOf(dsHoaDon, dsHoaDon.length + 1);
        dsHoaDon[soLuongHoaDon] = hd;
        soLuongHoaDon++;
        System.out.println("Them hoa don thanh cong");
    }

    @Override
    public void Them() {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day");
            return;
        }
        hoaDon hd = new hoaDon();
        hd.Nhap();
        this.themHoaDon(hd);
    }

    public void xoaHoaDon(String maHD) {
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le, vui long nhap lai (nhan 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equals(maHD)) {
                for (int j = i; j < soLuongHoaDon - 1; j++) {
                    dsHoaDon[j] = dsHoaDon[j + 1];
                }
                dsHoaDon = Arrays.copyOf(dsHoaDon, soLuongHoaDon - 1);
                soLuongHoaDon--;
                System.out.println("Xoa hoa don thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can xoa");
    }

    @Override
    public void Xoa() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can xoa: ");
        String maHD = sc.nextLine();
        xoaHoaDon(maHD);
    }

    public void suaHoaDon(String maHD) {
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le, vui long nhap lai (nhan 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
        }
        for (int i = 0; i < this.soLuongHoaDon; i++) {
            if (this.dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                System.out.println(">> Nhap lai thong tin moi: ");
                this.dsHoaDon[i].Nhap();
                System.out.println(">> Da cap nhat!");
                return;
            }
        }
        System.out.println(">> Khong tim thay ma hoa don!");
    }

    @Override
    public void Sua() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can sua: ");
        String maHD = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma hoa don!");
            return;
        }

        hoaDon hd = dsHoaDon[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║          SUA THONG TIN HOA DON: " + String.format("%-10s", maHD) + "         ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma KH                                             ║");
            System.out.println("║ 2. Sua ma NV                                             ║");
            System.out.println("║ 3. Sua ngay lap                                          ║");
            System.out.println("║ 4. Sua so luong chi tiet                                 ║");
            System.out.println("║ 5. Sua tat ca thong tin                                  ║");
            System.out.println("║ 0. Hoan thanh                                            ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-5): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ma KH moi: ");
                    hd.setMaKH(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap ma NV moi: ");
                    hd.setMaNV(sc.nextLine());
                    break;

                case "3":
                    while (true) {
                        try {
                            System.out.print("Nhap ngay lap moi (dd/MM/yyyy): ");
                            String ngayMoi = sc.nextLine();
                            String[] parts = ngayMoi.split("/");
                            if (parts.length != 3)
                                throw new Exception("Ngay lap khong hop le");
                            int day = Integer.parseInt(parts[0]);
                            int month = Integer.parseInt(parts[1]);
                            int year = Integer.parseInt(parts[2]);
                            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2025)
                                throw new Exception("Ngay lap khong hop le");
                            hd.setNgayLap(ngayMoi);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + ". Vui long nhap lai.");
                        }
                    }
                    break;

                case "4":
                    while (true) {
                        try {
                            System.out.print("Nhap so luong chi tiet moi: ");
                            int soLuongMoi = Integer.parseInt(sc.nextLine());
                            if (soLuongMoi <= 0 || soLuongMoi > 100)
                                throw new NumberFormatException();
                            hd.setSoLuongChiTiet(soLuongMoi);
                            for (int i = 0; i < soLuongMoi; i++) {
                                System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
                                hd.getChiTietHoaDon()[i] = new chiTietHoaDon();
                                hd.getChiTietHoaDon()[i].setMaHD(hd.getMaHD());
                                hd.getChiTietHoaDon()[i].Nhap();
                            }
                            hd.setTongTien(hd.tinhTongTien());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("So luong chi tiet khong hop le. Vui long nhap lai.");
                        }
                    }
                    break;

                case "5":
                    this.suaHoaDon(maHD);
                    break;

                case "0":
                    System.out.println(">> Hoan thanh sua thong tin hoa don!");
                    tiepTuc = false;
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    public void timKiemHoaDon(String maHD) {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le. Vui long nhap lai (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                break;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                dsHoaDon[i].Xuat();
                return;
            }
        }
        System.out.println("Khong tim thay hoa don co ma " + maHD);
    }

    public void timKiemTheoMaKH(String maKH) {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        int found = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equals(maKH)) {
                dsHoaDon[i].Xuat();
                found = 1;
            }
        }
        if (found == 0) {
            System.out.println("Khong tim thay hoa don co ma " + maKH);
        }
    }

    public void timKiemTheoMaNV(String maNV) {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        int found = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equals(maNV)) {
                dsHoaDon[i].Xuat();
                found = 1;
            }
        }
        if (found == 0) {
            System.out.println("Khong tim thay hoa don co ma " + maNV);
        }
    }

    @Override
    public void TimKiem() {
        System.out.println("Tim kiem hoa don theo:");
        System.out.println("1. Ma khach hang");
        System.out.println("2. Ma nhan vien");
        System.out.println("3. Ma hoa don");
        System.out.print("Chon loai tim kiem (1/2/3): ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Nhap ma khach hang can tim: ");
            String maKH = sc.nextLine();
            timKiemTheoMaKH(maKH);
        } else if (choice.equals("2")) {
            System.out.print("Nhap ma nhan vien can tim: ");
            String maNV = sc.nextLine();
            timKiemTheoMaNV(maNV);
        } else if (choice.equals("3")) {
            System.out.print("Nhap ma hoa don can tim: ");
            String maHD = sc.nextLine();
            timKiemHoaDon(maHD);
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }

    public void hienThiDanhSachHoaDon() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            dsHoaDon[i].Xuat();
            System.out.println("-----------------------");
        }
    }

    public void thongKeHoaDonTheoMaKH(String maKH) {
        int cnt = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equals(maKH))
                cnt++;
        }
        if (cnt == 0) {
            System.out.println("Khong tim thay hoa don cua khach hang ma: " + maKH);
            return;
        }
        System.out.println("So luong hoa don cua khach hang ma: " + maKH + " la: " + cnt);
    }

    public void thongKeHoaDonTheoMaNV(String maNV) {
        int cnt = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equals(maNV))
                cnt++;
        }
        if (cnt == 0) {
            System.out.println("Khong tim thay hoa don nhan vien co ma: " + maNV);
            return;
        }
        System.out.println("So luong hoa don nhan vien co ma: " + maNV + " la: " + cnt);
    }

    public void nhapNHoaDon() {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day, khong the nhap them");
            return;
        }
        try {
            System.out.print("Nhap so luong hoa don can them: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("So luong phai lon hon 0");
                return;
            }
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap hoa don thu " + (i + 1) + ":");
                this.Them();
            }
        } catch (NumberFormatException e) {
            System.out.println("So luong khong hop le");
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsHoaDon = new hoaDon[0];
            this.soLuongHoaDon = 0;
            return;
        }

        System.out.println("Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co hoa don de doc.");
                this.dsHoaDon = new hoaDon[0];
                this.soLuongHoaDon = 0;
                return;
            }

            this.dsHoaDon = new hoaDon[count];
            this.soLuongHoaDon = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && this.soLuongHoaDon < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    try {
                        String maHD = parts[0].trim();
                        String maKH = parts[1].trim();
                        String maNV = parts[2].trim();
                        String ngayLap = parts[3].trim();
                        Double tongTien = Double.parseDouble(parts[4].trim());
                        int soLuongChiTiet = Integer.parseInt(parts[5].trim());

                        int expectedLength = 6 + (soLuongChiTiet * 4);
                        if (parts.length < expectedLength) {
                            System.err.println(" Dong " + lineNumber + ": Thiếu dữ liệu chi tiết. (có " + parts.length
                                    + " trường, cần " + expectedLength + ")");
                            lineNumber++;
                            continue;
                        }

                        this.dsHoaDon[this.soLuongHoaDon] = new hoaDon(maHD, maKH, maNV, ngayLap, tongTien);
                        this.dsHoaDon[this.soLuongHoaDon].chiTietHoaDon = new chiTietHoaDon[soLuongChiTiet];

                        for (int i = 0; i < soLuongChiTiet; i++) {
                            String maHH = parts[6 + i * 4].trim();
                            String tenHH = parts[7 + i * 4].trim();
                            int soLuong = Integer.parseInt(parts[8 + i * 4].trim());
                            int gia = Integer.parseInt(parts[9 + i * 4].trim());

                            this.dsHoaDon[this.soLuongHoaDon].chiTietHoaDon[i] = new chiTietHoaDon(maHD, maHH, tenHH,
                                    soLuong, gia);
                        }

                        this.soLuongHoaDon++;

                    } catch (NumberFormatException e) {
                        System.err.println("Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can toi thieu 10)");
                }

                lineNumber++;
            }

            if (this.soLuongHoaDon < count) {
                System.out.println("Canh bao: Chi doc duoc " + this.soLuongHoaDon + "/" + count + " hoa don");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsHoaDon = new hoaDon[0];
            this.soLuongHoaDon = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        if (this.soLuongHoaDon == 0) {
            System.out.println("Danh sach trong, khong co du lieu de ghi.");
            return;
        }

        System.out.println("Dang ghi file: " + tenFile + "...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {

            bw.write(
                    "╔════════════╦════════════╦════════════╦════════════╦══════════════╦════════════╦════════════════════╦════════════╦════════════╦══════════════╗\n");
            bw.write(
                    "║   Ma HD    ║   Ma KH    ║   Ma NV    ║  Ngay Lap  ║   Tong Tien  ║   Ma Thuoc ║       Ten          ║  So Luong  ║    Gia     ║   Tong Chi   ║\n");
            bw.write(
                    "╠════════════╬════════════╬════════════╬════════════╬══════════════╬════════════╬════════════════════╬════════════╬════════════╬══════════════╣\n");

            for (int i = 0; i < this.soLuongHoaDon; i++) {
                hoaDon hd = this.dsHoaDon[i];

                for (int j = 0; j < hd.chiTietHoaDon.length; j++) {
                    chiTietHoaDon ct = hd.chiTietHoaDon[j];
                    double tongChi = ct.getSoLuong() * ct.getDonGia();

                    if (j == 0) {
                        bw.write(String.format(
                                "║ %-10s ║ %-10s ║ %-10s ║ %-10s ║ %12.0f ║ %-10s ║ %-18s ║ %10d ║ %10.0f ║ %12.0f ║%n",
                                hd.getMaHD(),
                                hd.getMaKH(),
                                hd.getMaNV(),
                                hd.getNgayLap(),
                                hd.getTongTien(),
                                ct.getMaThuoc(),
                                ct.getTenThuoc(),
                                ct.getSoLuong(),
                                ct.getDonGia(),
                                tongChi));
                    } else {
                        bw.write(String.format(
                                "║ %-10s ║ %-10s ║ %-10s ║ %-10s ║ %-12s ║ %-10s ║ %-18s ║ %10d ║ %10.0f ║ %12.0f ║%n",
                                "",
                                "",
                                "",
                                "",
                                "",
                                ct.getMaThuoc(),
                                ct.getTenThuoc(),
                                ct.getSoLuong(),
                                ct.getDonGia(),
                                tongChi));
                    }
                }
            }

            bw.write(
                    "╚════════════╩════════════╩════════════╩════════════╩══════════════╩════════════╩════════════════════╩════════════╩════════════╩══════════════╝\n");

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

}