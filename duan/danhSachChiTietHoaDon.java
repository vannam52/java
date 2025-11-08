package duan;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import duan.chiTietHoaDon;

public class danhSachChiTietHoaDon implements ChucNang, IFile {
    chiTietHoaDon[] dsChiTietHD;
    int soLuongChiTietHD;
    final int MAX_CHI_TIET_HD = 300;

    private static Scanner sc = new Scanner(System.in);

    public danhSachChiTietHoaDon() {
        dsChiTietHD = new chiTietHoaDon[MAX_CHI_TIET_HD];
        soLuongChiTietHD = 0;

    }

    public danhSachChiTietHoaDon(danhSachChiTietHoaDon dsct) {
        this.dsChiTietHD = new chiTietHoaDon[dsct.soLuongChiTietHD];
        this.soLuongChiTietHD = dsct.soLuongChiTietHD;
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            this.dsChiTietHD[i] = new chiTietHoaDon(dsct.dsChiTietHD[i]);
        }
    }

    // them chi tiet hoa don
    public void themChiTietHoaDon(chiTietHoaDon ct) {
        if (soLuongChiTietHD < MAX_CHI_TIET_HD) {
            dsChiTietHD[soLuongChiTietHD] = ct;
            soLuongChiTietHD++;
        } else {
            System.out.println("Danh sach chi tiet hoa don da day.");
        }
    }

    // them n chi tiet hoa don
    public void nhapNChiTietHoaDon() {
        System.out.print("Nhap so luong chi tiet hoa don can them: ");
        int n = Integer.parseInt(sc.nextLine());
        if (soLuongChiTietHD + n > MAX_CHI_TIET_HD) {
            System.out.println("Khong the them " + n + " chi tiet hoa don. Vuot qua so luong toi da.");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            chiTietHoaDon ct = new chiTietHoaDon();
            ct.Nhap();
            this.themChiTietHoaDon(ct);
        }
    }

    // kiem tra rang buoc ma
    public boolean kiemTraMa(String maHD) {
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equals(maHD))
                return true;
        }
        return false;
    }

    // kiem tra ma thuoc
    public boolean kiemTraMaThuoc(String maThuoc) {
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaThuoc().equals(maThuoc))
                return true;
        }
        return false;
    }

    // kiem tra ma thuoc trong ma hoa don
    public boolean kiemTraMaThuocTrongMaHD(String maHD, String maThuoc) {
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (this.dsChiTietHD[i].getMaHD().equals(maHD) && this.dsChiTietHD[i].getMaThuoc().equals(maThuoc))
                return true;
        }
        return false;
    }

    // them chi tiet hoa don khong tham so
    @Override
    public void Them() {
        if (soLuongChiTietHD >= MAX_CHI_TIET_HD) {
            System.out.println("Danh sach chi tiet hoa don da day.");
            return;
        }

        String maHD;
        do {
            System.out.print("Nhap ma hoa don (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
            if (kiemTraMa(maHD))
                break;
            System.out.println("Ma hoa don khong ton tai. Vui long nhap lai.");
        } while (true);
        chiTietHoaDon ct = new chiTietHoaDon();
        ct.setMaHD(maHD);
        ct.Nhap();
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equals(maHD) && dsChiTietHD[i].getMaThuoc().equals(ct.getMaThuoc())) {
                System.out.println("Thuoc nay da ton tai trong hoa don. Vui long nhap lai.");
                return;
            }
        }
        dsChiTietHD = Arrays.copyOf(this.dsChiTietHD, soLuongChiTietHD + 1);
        dsChiTietHD[soLuongChiTietHD] = new chiTietHoaDon(ct);
        soLuongChiTietHD++;
        System.out.println("Them chi tiet hoa don thanh cong");
    }

    // xoa chi tiet hoa don khong tham so
    @Override
    public void Xoa() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        String maHD;
        String maThuoc;
        do {
            System.out.print("Nhap ma hoa don can xoa chi tiet (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
            if (kiemTraMa(maHD))
                break;
            System.out.println("Ma hoa don khong ton tai. Vui long nhap lai.");
        } while (true);
        do {
            System.out.print("Nhap ma thuoc can xoa chi tiet (nhap 'q' de thoat): ");
            maThuoc = sc.nextLine();
            if (maThuoc.equalsIgnoreCase("q"))
                return;
            if (kiemTraMaThuocTrongMaHD(maHD, maThuoc))
                break;
            System.out.println("Ma thuoc khong ton tai. Vui long nhap lai.");
        } while (true);
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (this.dsChiTietHD[i].getMaHD().equals(maHD) && this.dsChiTietHD[i].getMaThuoc().equals(maThuoc)) {
                for (int j = i; j < this.soLuongChiTietHD - 1; j++) {
                    dsChiTietHD[j] = dsChiTietHD[j + 1];
                }
                dsChiTietHD = Arrays.copyOf(dsChiTietHD, soLuongChiTietHD - 1);
                soLuongChiTietHD--;
                System.out.println("Xoa thanh cong chi tiet hoa don");
                return;
            }
        }
    }

    // tim kiem chi tiet hoa don co tham so
    public void timKiemChiTietHoaDon(String maHD) {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le. Vui long nhap lai (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
        }
        hienThiChiTietHoaDonTheoMaHD(maHD);
    }

    public void timKiemTheoMaThuoc(String maThuoc) {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        int found = 0;
        System.out.println("╔════════════╦════════════╦════════════════════╦════════════╦════════════╦════════════╗");
        System.out.println("║   Ma HD    ║   Ma Thuoc ║    Ten Thuoc       ║ So Luong   ║  Don Gia   ║ Thanh Tien ║");
        System.out.println("╠════════════╬════════════╬════════════════════╬════════════╬════════════╬════════════╣");
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaThuoc().equals(maThuoc)) {
                System.out.printf("║ %-10s ║ %-10s ║ %-18s ║ %-10d ║ %-10d ║ %-10d ║%n",
                        dsChiTietHD[i].getMaHD(),
                        dsChiTietHD[i].getMaThuoc(),
                        dsChiTietHD[i].getTenThuoc(),
                        dsChiTietHD[i].getSoLuong(),
                        dsChiTietHD[i].getDonGia(),
                        dsChiTietHD[i].getThanhTien());
                found = 1;
            }
        }
        System.out.println("╚════════════╩════════════╩════════════════════╩════════════╩════════════╩════════════╝");
        if (found == 0) {
            System.out.println("Khong tim thay chi tiet hoa don co ma thuoc: " + maThuoc);
        }
    }

    // tim kiem chi tiet hoa don khong tham so
    @Override
    public void TimKiem() {
        System.out.println("Tim kiem chi tiet hoa don theo:");
        System.out.println("1. Ma hoa don");
        System.out.println("2. Ma thuoc");
        System.out.print("Chon loai tim kiem (1/2): ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Nhap ma hoa don can tim: ");
            String maHD = sc.nextLine();
            timKiemChiTietHoaDon(maHD);
        } else if (choice.equals("2")) {
            System.out.print("Nhap ma thuoc can tim: ");
            String maThuoc = sc.nextLine();
            timKiemTheoMaThuoc(maThuoc);
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }


    //sua chi tiet hoa don khong tham so
    @Override
    public void Sua() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can sua chi tiet: ");
        String maHD = sc.nextLine();

        System.out.print("Nhap ma thuoc can sua chi tiet: ");
        String maThuoc = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equalsIgnoreCase(maHD) &&
                    dsChiTietHD[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println(">> Khong tim thay chi tiet hoa don!");
            return;
        }

        chiTietHoaDon ct = dsChiTietHD[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║         SUA THONG TIN CHI TIET HOA DON                   ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.printf("║ Ma hoa don: %-45s║%n", maHD);
            System.out.printf("║ Ma thuoc  : %-45s║%n", maThuoc);
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten thuoc                                         ║");
            System.out.println("║ 2. Sua so luong                                          ║");
            System.out.println("║ 3. Sua don gia                                           ║");
            System.out.println("║ 4. Sua tat ca thong tin                                  ║");
            System.out.println("║ 0. Hoan thanh                                            ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-4): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ten thuoc moi: ");
                    ct.setTenThuoc(sc.nextLine());
                    break;

                case "2":
                    while (true) {
                        try {
                            System.out.print("Nhap so luong moi: ");
                            int soLuongMoi = Integer.parseInt(sc.nextLine());
                            if (soLuongMoi <= 0)
                                throw new NumberFormatException();
                            ct.setSoLuong(soLuongMoi);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("So luong khong hop le. Vui long nhap lai.");
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        try {
                            System.out.print("Nhap don gia moi: ");
                            int donGiaMoi = Integer.parseInt(sc.nextLine());
                            if (donGiaMoi <= 0)
                                throw new NumberFormatException();
                            ct.setDonGia(donGiaMoi);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Don gia khong hop le. Vui long nhap lai.");
                        }
                    }
                    break;

                case "4":
                    System.out.println(">> Nhap lai tat ca thong tin:");
                    ct.Nhap();
                    break;

                case "0":
                    System.out.println(">> Hoan thanh sua thong tin chi tiet hoa don!");
                    tiepTuc = false;
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    // hien thi chi tiet hoa don
    public void hienThiChiTietHoaDon() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        System.out.println("╔════════════╦════════════╦════════════════════╦════════════╦════════════╦════════════╗");
        System.out.println("║   Ma HD    ║   Ma Thuoc ║    Ten Thuoc       ║ So Luong   ║  Don Gia   ║ Thanh Tien ║");
        System.out.println("╠════════════╬════════════╬════════════════════╬════════════╬════════════╬════════════╣");
        for (int i = 0; i < soLuongChiTietHD; i++) {
            System.out.printf("║ %-10s ║ %-10s ║ %-18s ║ %-10d ║ %-10d ║ %-10d ║%n",
                    dsChiTietHD[i].getMaHD(),
                    dsChiTietHD[i].getMaThuoc(),
                    dsChiTietHD[i].getTenThuoc(),
                    dsChiTietHD[i].getSoLuong(),
                    dsChiTietHD[i].getDonGia(),
                    dsChiTietHD[i].getThanhTien());
        }
        System.out.println("╚════════════╩════════════╩════════════════════╩════════════╩════════════╩════════════╝");
    }

    // hien thi chi tiet hoa don theo ma hoa don
    public void hienThiChiTietHoaDonTheoMaHD(String maHD) {
        boolean found = false;
        System.out.println("╔════════════╦════════════╦════════════════════╦════════════╦════════════╦════════════╗");
        System.out.println("║   Ma HD    ║   Ma Thuoc ║    Ten Thuoc       ║ So Luong   ║  Don Gia   ║ Thanh Tien ║");
        System.out.println("╠════════════╬════════════╬════════════════════╬════════════╬════════════╬════════════╣");
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equals(maHD)) {
                System.out.printf("║ %-10s ║ %-10s ║ %-18s ║ %-10d ║ %-10d ║ %-10d ║%n",
                        dsChiTietHD[i].getMaHD(),
                        dsChiTietHD[i].getMaThuoc(),
                        dsChiTietHD[i].getTenThuoc(),
                        dsChiTietHD[i].getSoLuong(),
                        dsChiTietHD[i].getDonGia(),
                        dsChiTietHD[i].getThanhTien());
                found = true;
            }
        }
        System.out.println("╚════════════╩════════════╩════════════════════╩════════════╩════════════╩════════════╝");
        if (!found) {
            System.out.println("Khong tim thay chi tiet hoa don co ma: " + maHD);
        }
    }

    // thong ke tong so luong chi tiet hoa don
    public void thongKeTongSoLuongMaThuoc() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        int total = 0;
        String maThuoc;
        do {
            System.out.print("Nhap ma thuoc can tim (nhap 'q' de thoat): ");
            maThuoc = sc.nextLine();
            if (maThuoc.equalsIgnoreCase("q"))
                return;
            if (kiemTraMaThuoc(maThuoc))
                break;
            System.out.println("Ma thuoc khong ton tai. Vui long nhap lai.");
        } while (true);
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (this.dsChiTietHD[i].getMaThuoc().equals(maThuoc)) {
                total += dsChiTietHD[i].getSoLuong();
            }
        }
        System.out.println("Tong so luong thuoc co ma " + maThuoc + " la: " + total);
    }

    // thong ke so luong chi tiet theo tung ma hoa don
    public void thongKeSoLuongTheoMaHD() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }
        String maHD;
        int cnt = 0;
        do {
            System.out.print("Nhap ma hoa don can tim (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
            if (kiemTraMa(maHD))
                break;
            System.out.println("Ma hoa don khong ton tai. Vui long nhap lai.");
        } while (true);
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            if (this.dsChiTietHD[i].getMaHD().equals(maHD)) {
                cnt++;
            }
        }
        System.out.println("Tong so luong chi tiet hoa don co ma " + maHD + " la: " + cnt);
    }

    // doc file
    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsChiTietHD = new chiTietHoaDon[0];
            this.soLuongChiTietHD = 0;
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
                System.out.println("File khong co chi tiet hoa don de doc.");
                this.dsChiTietHD = new chiTietHoaDon[0];
                this.soLuongChiTietHD = 0;
                return;
            }

            this.dsChiTietHD = new chiTietHoaDon[count];
            this.soLuongChiTietHD = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && this.soLuongChiTietHD < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    try {
                        String maHD = parts[0].trim();
                        String maThuoc = parts[1].trim();
                        String tenThuoc = parts[2].trim();
                        int soLuong = Integer.parseInt(parts[3].trim());
                        int donGia = Integer.parseInt(parts[4].trim());

                        this.dsChiTietHD[this.soLuongChiTietHD] = new chiTietHoaDon(maHD, maThuoc, tenThuoc, soLuong,
                                donGia);
                        this.soLuongChiTietHD++;

                    } catch (NumberFormatException e) {
                        System.err.println("Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 5)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (this.soLuongChiTietHD < count) {
                System.out
                        .println("Canh bao: Chi doc duoc " + this.soLuongChiTietHD + "/" + count + " chi tiet hoa don");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongChiTietHD);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsChiTietHD = new chiTietHoaDon[0];
            this.soLuongChiTietHD = 0;
        }
    }

    // ghi file
    @Override
    public void ghiFile(String tenFile) {
        if (this.soLuongChiTietHD == 0) {
            System.out.println("Danh sach trong, khong co du lieu de ghi.");
            return;
        }

        System.out.println("Dang ghi file: " + tenFile + "...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            bw.write(this.soLuongChiTietHD + "\n");
            bw.write("╔════════════╦════════════╦════════════════════╦════════════╦════════════╦════════════╗\n");
            bw.write("║   Ma HD    ║   Ma Thuoc ║    Ten Thuoc       ║ So Luong   ║  Don Gia   ║ Thanh Tien ║\n");
            bw.write("╠════════════╬════════════╬════════════════════╬════════════╬════════════╬════════════╣\n");

            for (int i = 0; i < this.soLuongChiTietHD; i++) {
                chiTietHoaDon ct = this.dsChiTietHD[i];
                bw.write(String.format("║ %-10s ║ %-10s ║ %-18s ║ %-10d ║ %-10d ║ %-10d ║\n",
                        ct.getMaHD(),
                        ct.getMaThuoc(),
                        ct.getTenThuoc(),
                        ct.getSoLuong(),
                        ct.getDonGia(),
                        ct.getThanhTien()));
            }

            bw.write("╚════════════╩════════════╩════════════════════╩════════════╩════════════╩════════════╝\n");

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongChiTietHD);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }
}
