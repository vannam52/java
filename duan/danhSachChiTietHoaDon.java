package duan;

import java.util.*;
import java.io.*;

public class danhSachChiTietHoaDon implements ChucNang, IFile {
    private chiTietHoaDon[] dsChiTietHD = new chiTietHoaDon[0];
    private int soLuongChiTietHD;

    private static Scanner sc = new Scanner(System.in);

    public danhSachChiTietHoaDon() {
        this.dsChiTietHD = new chiTietHoaDon[0];
        this.soLuongChiTietHD = 0;
    }

    public danhSachChiTietHoaDon(danhSachChiTietHoaDon dsct) {
        this.soLuongChiTietHD = dsct.soLuongChiTietHD;
        this.dsChiTietHD = new chiTietHoaDon[dsct.soLuongChiTietHD];
        for (int i = 0; i < this.soLuongChiTietHD; i++) {
            this.dsChiTietHD[i] = new chiTietHoaDon(dsct.dsChiTietHD[i]);
        }
    }

    public void themChiTietHoaDon(chiTietHoaDon ct) {
        dsChiTietHD = Arrays.copyOf(dsChiTietHD, soLuongChiTietHD + 1);
        dsChiTietHD[soLuongChiTietHD] = ct;
        soLuongChiTietHD++;
        System.out.println("Them chi tiet hoa don thanh cong");
    }

    @Override
    public void Them() {
        chiTietHoaDon ct = new chiTietHoaDon();
        ct.Nhap();
        themChiTietHoaDon(ct);
    }

    public void nhapNChiTietHoaDon() {
        int n;
        try {
            System.out.print("Nhap so luong chi tiet hoa don can them: ");
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap chi tiet hoa don thu " + (soLuongChiTietHD + 1) + " ---");
            Them();
        }
    }

    @Override
    public void Xoa() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma thuoc can xoa: ");
        String maThuoc = sc.nextLine();

        int vt = -1;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equalsIgnoreCase(maHD) &&
                    dsChiTietHD[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet hoa don");
            return;
        }

        for (int j = vt; j < soLuongChiTietHD - 1; j++) {
            dsChiTietHD[j] = dsChiTietHD[j + 1];
        }
        dsChiTietHD = Arrays.copyOf(dsChiTietHD, soLuongChiTietHD - 1);
        soLuongChiTietHD--;
        System.out.println("Xoa chi tiet hoa don thanh cong!");
    }

    @Override
    public void Sua() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma thuoc can sua: ");
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
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║          SUA THONG TIN CHI TIET HOA DON                          ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten thuoc                                                 ║");
            System.out.println("║ 2. Sua so luong                                                  ║");
            System.out.println("║ 3. Sua don gia                                                   ║");
            System.out.println("║ 4. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
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
                            int sl = Integer.parseInt(sc.nextLine());
                            if (sl > 0) {
                                ct.setSoLuong(sl);
                                ct.setThanhTien(ct.getSoLuong() * ct.getDonGia());
                                break;
                            } else {
                                System.out.println("So luong phai lon hon 0!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap so hop le!");
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        try {
                            System.out.print("Nhap don gia moi: ");
                            int dg = Integer.parseInt(sc.nextLine());
                            if (dg > 0) {
                                ct.setDonGia(dg);
                                ct.setThanhTien(ct.getSoLuong() * ct.getDonGia());
                                break;
                            } else {
                                System.out.println("Don gia phai lon hon 0!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap so hop le!");
                        }
                    }
                    break;

                case "4":
                    System.out.println("\n>> Nhap lai tat ca thong tin:");
                    ct.Nhap();
                    break;

                case "0":
                    System.out.println(">> Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    // Tim kiem chi tiet hoa don (theo ma hoa don hoac ma thuoc)
    @Override
    public void TimKiem() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.println("Tim kiem chi tiet hoa don theo:");
        System.out.println("1. Ma hoa don");
        System.out.println("2. Ma thuoc");
        System.out.print("Chon loai tim kiem (1/2): ");

        String choice = sc.nextLine();

        if (choice.equals("1")) {
            System.out.print("Nhap ma hoa don can tim: ");
            String maHD = sc.nextLine();

            chiTietHoaDon[] ketQua = timKiemTheoMaHD(maHD);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " chi tiet cua hoa don " + maHD + ":");
                hienThiBangChiTiet(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay chi tiet cua hoa don: " + maHD);
            }
        } else if (choice.equals("2")) {
            System.out.print("Nhap ma thuoc can tim: ");
            String maThuoc = sc.nextLine();

            chiTietHoaDon[] ketQua = timKiemTheoMaThuoc(maThuoc);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " chi tiet co ma thuoc " + maThuoc + ":");
                hienThiBangChiTiet(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay chi tiet co ma thuoc: " + maThuoc);
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    // Tim kiem chi tiet hoa don theo ma hoa don
    private chiTietHoaDon[] timKiemTheoMaHD(String maHD) {
        int count = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                count++;
            }
        }

        chiTietHoaDon[] ketQua = new chiTietHoaDon[count];
        int index = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                ketQua[index++] = dsChiTietHD[i];
            }
        }
        return ketQua;
    }

    // Tim kiem chi tiet hoa don theo ma thuoc
    private chiTietHoaDon[] timKiemTheoMaThuoc(String maThuoc) {
        int count = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                count++;
            }
        }

        chiTietHoaDon[] ketQua = new chiTietHoaDon[count];
        int index = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                ketQua[index++] = dsChiTietHD[i];
            }
        }
        return ketQua;
    }

    // Hien thi bang chi tiet hoa don
    private void hienThiBangChiTiet(chiTietHoaDon[] danhSach, int soLuong) {
        if (soLuong == 0) {
            System.out.println("Danh sach rong");
            return;
        }

        System.out.println("╔══════════╦══════════╦════════════════════╦══════════╦══════════╦════════════╗");
        System.out.println("║  Ma HD   ║ Ma Thuoc ║     Ten Thuoc      ║ So Luong ║ Don Gia  ║ Thanh Tien ║");
        System.out.println("╠══════════╬══════════╬════════════════════╬══════════╬══════════╬════════════╣");

        for (int i = 0; i < soLuong; i++) {
            System.out.printf("║ %-8s ║ %-8s ║ %-18s ║ %8d ║ %8d ║ %10d ║%n",
                    danhSach[i].getMaHD(),
                    danhSach[i].getMaThuoc(),
                    danhSach[i].getTenThuoc(),
                    danhSach[i].getSoLuong(),
                    danhSach[i].getDonGia(),
                    danhSach[i].getThanhTien());
        }

        System.out.println("╚══════════╩══════════╩════════════════════╩══════════╩══════════╩════════════╝");
    }

    // Hien thi danh sach chi tiet hoa don
    public void hienThiDanhSachChiTiet() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    DANH SACH CHI TIET HOA DON                               ║");
        System.out.println("╠══════════╦══════════╦════════════════════╦══════════╦══════════╦════════════╣");
        System.out.println("║  Ma HD   ║ Ma Thuoc ║     Ten Thuoc      ║ So Luong ║ Don Gia  ║ Thanh Tien ║");
        System.out.println("╠══════════╬══════════╬════════════════════╬══════════╬══════════╬════════════╣");

        for (int i = 0; i < soLuongChiTietHD; i++) {
            System.out.printf("║ %-8s ║ %-8s ║ %-18s ║ %8d ║ %8d ║ %10d ║%n",
                    dsChiTietHD[i].getMaHD(),
                    dsChiTietHD[i].getMaThuoc(),
                    dsChiTietHD[i].getTenThuoc(),
                    dsChiTietHD[i].getSoLuong(),
                    dsChiTietHD[i].getDonGia(),
                    dsChiTietHD[i].getThanhTien());
        }

        System.out.println("╚══════════╩══════════╩════════════════════╩══════════╩══════════╩════════════╝");
        System.out.println("Tong so: " + soLuongChiTietHD + " chi tiet");
    }

    // Menu thong ke chi tiet hoa don
    public void menuThongKe() {
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║           MENU THONG KE CHI TIET HOA DON                         ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Thong ke chung                                                ║");
            System.out.println("║ 2. Thong ke tong so luong theo ma thuoc                          ║");
            System.out.println("║ 3. Thong ke so luong chi tiet theo ma hoa don                    ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-3): ");

            String luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    thongKeChung();
                    break;
                case "2":
                    thongKeTongSoLuongMaThuoc();
                    break;
                case "3":
                    thongKeSoLuongTheoMaHD();
                    break;
                case "0":
                    System.out.println(">> Thoat menu thong ke!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le!");
            }
        }
    }

    // Thong ke chung ve chi tiet hoa don
    public void thongKeChung() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║           THONG KE DANH SACH CHI TIET HOA DON                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        System.out.printf("║ Tong so chi tiet hoa don: %-39d║%n", soLuongChiTietHD);

        chiTietHoaDon ctMax = dsChiTietHD[0];
        for (int i = 1; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getThanhTien() > ctMax.getThanhTien()) {
                ctMax = dsChiTietHD[i];
            }
        }
        System.out.println("║ Chi tiet co thanh tien cao nhat:                                 ║");
        System.out.printf("║   Ma hoa don: %-51s║%n", ctMax.getMaHD());
        System.out.printf("║   Ma thuoc: %-53s║%n", ctMax.getMaThuoc());
        System.out.printf("║   Ten thuoc: %-52s║%n", ctMax.getTenThuoc());
        System.out.printf("║   Thanh tien: %46d VND ║%n", ctMax.getThanhTien());

        long tongThanhTien = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            tongThanhTien += dsChiTietHD[i].getThanhTien();
        }
        System.out.printf("║ Tong thanh tien tat ca chi tiet: %27d VND ║%n", tongThanhTien);
        System.out.printf("║ Trung binh thanh tien/chi tiet: %28.2f VND ║%n",
                (double) tongThanhTien / soLuongChiTietHD);

        int tongSoLuong = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            tongSoLuong += dsChiTietHD[i].getSoLuong();
        }
        System.out.printf("║ Tong so luong thuoc da ban: %37d║%n", tongSoLuong);

        String[] dsMaHD = new String[soLuongChiTietHD];
        int soHoaDon = 0;
        for (int i = 0; i < soLuongChiTietHD; i++) {
            boolean daTonTai = false;
            for (int j = 0; j < soHoaDon; j++) {
                if (dsChiTietHD[i].getMaHD().equals(dsMaHD[j])) {
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai) {
                dsMaHD[soHoaDon] = dsChiTietHD[i].getMaHD();
                soHoaDon++;
            }
        }
        System.out.printf("║ So hoa don co chi tiet: %41d║%n", soHoaDon);
        if (soHoaDon > 0) {
            System.out.printf("║ Trung binh chi tiet/hoa don: %36.2f║%n",
                    (double) soLuongChiTietHD / soHoaDon);
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Thong ke tong so luong thuoc da ban theo ma thuoc
    public void thongKeTongSoLuongMaThuoc() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.print("Nhap ma thuoc can thong ke: ");
        String maThuoc = sc.nextLine().trim();

        int tongSoLuong = 0;
        int soChiTiet = 0;

        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                tongSoLuong += dsChiTietHD[i].getSoLuong();
                soChiTiet++;
            }
        }

        if (soChiTiet == 0) {
            System.out.println("Khong tim thay thuoc co ma: " + maThuoc);
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ Thong ke ma thuoc: %-46s║%n", maThuoc);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ So lan xuat hien: %47d║%n", soChiTiet);
        System.out.printf("║ Tong so luong da ban: %43d║%n", tongSoLuong);
        System.out.printf("║ Trung binh so luong/lan: %39.2f ║%n", (double) tongSoLuong / soChiTiet);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Thong ke so luong chi tiet theo ma hoa don
    public void thongKeSoLuongTheoMaHD() {
        if (soLuongChiTietHD == 0) {
            System.out.println("Danh sach chi tiet hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can thong ke: ");
        String maHD = sc.nextLine().trim();

        int soChiTiet = 0;
        long tongTien = 0;

        for (int i = 0; i < soLuongChiTietHD; i++) {
            if (dsChiTietHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                soChiTiet++;
                tongTien += dsChiTietHD[i].getThanhTien();
            }
        }

        if (soChiTiet == 0) {
            System.out.println("Khong tim thay chi tiet cua hoa don: " + maHD);
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ Thong ke hoa don: %-47s║%n", maHD);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ So luong chi tiet: %46d║%n", soChiTiet);
        System.out.printf("║ Tong thanh tien: %43d VND ║%n", tongTien);
        System.out.printf("║ Trung binh tien/chi tiet: %34.2f VND ║%n", (double) tongTien / soChiTiet);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Doc danh sach chi tiet hoa don tu file
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
                System.out.println("File khong co chi tiet de doc.");
                this.dsChiTietHD = new chiTietHoaDon[0];
                this.soLuongChiTietHD = 0;
                return;
            }

            this.dsChiTietHD = new chiTietHoaDon[count];
            this.soLuongChiTietHD = 0;
            String line;

            while ((line = br.readLine()) != null && this.soLuongChiTietHD < count) {
                line = line.trim();
                if (line.isEmpty()) {
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

                    } catch (Exception e) {
                        System.err.println("Loi doc du lieu chi tiet: " + e.getMessage());
                    }
                }
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

    // Ghi danh sach chi tiet hoa don ra file
    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongChiTietHD);

            for (int i = 0; i < soLuongChiTietHD; i++) {
                chiTietHoaDon ct = dsChiTietHD[i];
                pw.printf("%s,%s,%s,%d,%d%n",
                        ct.getMaHD(),
                        ct.getMaThuoc(),
                        ct.getTenThuoc(),
                        ct.getSoLuong(),
                        ct.getDonGia());
            }

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