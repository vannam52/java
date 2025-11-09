package duan;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class danhSachChiTietPhieuNhapHang implements ChucNang, IFile {
    private chiTietPhieuNhapHang[] dsCTPNH;
    private int soLuongCTPNH;

    public danhSachChiTietPhieuNhapHang() {
        this.dsCTPNH = new chiTietPhieuNhapHang[0];
        this.soLuongCTPNH = 0;
    }

    public void themChiTietPhieuNhapHang(chiTietPhieuNhapHang ctpnh) {
        if (timKiemTheoMa(ctpnh.getMaPNH(), ctpnh.getMaThuoc()) != null) {
            System.out.println("Ma chi tiet phieu nhap hang (PNH+Thuoc) da ton tai");
            return;
        }
        dsCTPNH = Arrays.copyOf(dsCTPNH, soLuongCTPNH + 1);
        dsCTPNH[soLuongCTPNH] = ctpnh;
        soLuongCTPNH++;
        System.out.println("Them chi tiet phieu nhap hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        chiTietPhieuNhapHang ctpnhMoi;
        boolean maBiTrung;

        do {
            maBiTrung = false;
            ctpnhMoi = new chiTietPhieuNhapHang();

            System.out.println("--- Nhap thong tin chi tiet phieu nhap hang moi ---");
            ctpnhMoi.nhapChiTietPhieuNhapHang();

            if (timKiemTheoMa(ctpnhMoi.getMaPNH(), ctpnhMoi.getMaThuoc()) != null) {
                System.out.println("✗ Ma chi tiet (PNH+Thuoc) da ton tai! Vui long nhap lai toan bo thong tin.");
                maBiTrung = true;
            } else {
                themChiTietPhieuNhapHang(ctpnhMoi);
                System.out.println("✓ Da them chi tiet phieu nhap hang thanh cong!");
            }

        } while (maBiTrung);
    }

    public void xoaChiTietPhieuNhapHang(String maPNH, String maThuoc) {
        int vt = -1;
        for (int i = 0; i < soLuongCTPNH; i++) {
            if (dsCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH) && dsCTPNH[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay chi tiet phieu nhap hang co ma " + maPNH + " + " + maThuoc);
            return;
        }

        for (int j = vt; j < soLuongCTPNH - 1; j++) {
            dsCTPNH[j] = dsCTPNH[j + 1];
        }
        dsCTPNH = Arrays.copyOf(dsCTPNH, soLuongCTPNH - 1);
        soLuongCTPNH--;
        System.out.println("✓ Xoa chi tiet phieu nhap hang thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongCTPNH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang can xoa: ");
        String maPNH = sc.nextLine();
        System.out.print("Nhap ma thuoc can xoa: ");
        String maThuoc = sc.nextLine();
        xoaChiTietPhieuNhapHang(maPNH, maThuoc);
    }

    @Override
    public void Sua() {
        if (soLuongCTPNH == 0) {
            System.out.println("✗ Danh sach chi tiet phieu nhap hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang (MaPNH) can sua: ");
        String maPNH = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < soLuongCTPNH; i++) {
            if (dsCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("✗ Khong tim thay phieu xuat hang co ma: " + maPNH);
            return;
        }

        chiTietPhieuNhapHang ctpnh = dsCTPNH[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║           SUA THONG TIN CHI TIET PHIEU NHAP: " + String.format("%-20s", maPNH) + "║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma thuoc                                                  ║");
            System.out.println("║ 2. Sua so luong                                                  ║");
            System.out.println("║ 3. Sua don gia                                                   ║");
            System.out.println("║ 4. Sua tat ca thong tin (tru ma)                                 ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-3): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ma thuoc moi: ");
                    ctpnh.setMaThuoc(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap so luong moi: ");
                    ctpnh.setSoLuong(Integer.parseInt(sc.nextLine()));
                    ctpnh.thanhTien(); // tự động tính lại
                    break;

                case "3":
                    System.out.print("Nhap don gia moi (Hien tai: " + ctpnh.getDonGia() + "): ");
                    String donGiaStr = sc.nextLine().trim();
                    if (!donGiaStr.isEmpty()) {
                        try {
                            ctpnh.setDonGia(Double.parseDouble(donGiaStr));
                        } catch (NumberFormatException e) {
                            System.out.println("(!) Loi: Don gia nhap vao khong hop le.");
                        }
                    }
                    ctpnh.thanhTien();
                    break;
                case "4":
                    System.out.println("\n>> Nhap lai tat ca thong tin (tru ma phieu & thanh tien):");
                    String maCu = ctpnh.getMaPNH(); // giữ lại mã cũ
                    System.out.print("Nhap ma thuoc: ");
                    ctpnh.setMaThuoc(sc.nextLine());
                    System.out.print("Nhap so luong: ");
                    ctpnh.setSoLuong(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap don gia: ");
                    ctpnh.setDonGia(Double.parseDouble(sc.nextLine()));
                    ctpnh.thanhTien(); // tự động tính lại
                    ctpnh.setMaPNH(maCu); // giữ nguyên mã phiếu
                    break;
                case "0":
                    System.out.println(">> Hoan thanh sua thong tin chi tiet phieu nhap!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    public chiTietPhieuNhapHang timKiemTheoMa(String maPNH, String maThuoc) {
        for (int i = 0; i < soLuongCTPNH; i++) {
            if (dsCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH) && dsCTPNH[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                return dsCTPNH[i];
            }
        }
        return null;
    }

    public chiTietPhieuNhapHang[] timKiemTheoMaPNH(String maPNH) {
        chiTietPhieuNhapHang[] ketQua = new chiTietPhieuNhapHang[soLuongCTPNH];
        int dem = 0;
        for (int i = 0; i < soLuongCTPNH; i++) {
            if (dsCTPNH[i].getMaPNH().toLowerCase().contains(maPNH.toLowerCase())) {
                ketQua[dem] = dsCTPNH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongCTPNH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM CHI TIET PHIEU NHAP HANG ---");
        System.out.println("1. Tim theo ma PNH + Ma Thuoc (Chinh xac)");
        System.out.println("2. Tim theo ma Phieu Nhap Hang (Gan dung)");
        System.out.print("Chon loai tim kiem: ");

        int chon = 0;
        try {
            chon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✗ Lua chon khong hop le!");
            return;
        }

        switch (chon) {
            case 1:
                System.out.print("Nhap ma phieu nhap hang can tim: ");
                String maPNH = sc.nextLine();
                System.out.print("Nhap ma thuoc can tim: ");
                String maThuoc = sc.nextLine();
                chiTietPhieuNhapHang ctpnh = timKiemTheoMa(maPNH, maThuoc);
                if (ctpnh != null) {
                    System.out.println("✓ Tim thay chi tiet phieu nhap hang:");
                    hienThiBang(new chiTietPhieuNhapHang[] { ctpnh }, 1);
                } else {
                    System.out.println("✗ Khong tim thay chi tiet co ma: " + maPNH + " + " + maThuoc);
                }
                break;
            case 2:
                System.out.print("Nhap ma phieu nhap hang can tim: ");
                String maPNH_TK = sc.nextLine();
                chiTietPhieuNhapHang[] ketQua = timKiemTheoMaPNH(maPNH_TK);
                if (ketQua.length > 0) {
                    System.out.println("✓ Tim thay " + ketQua.length + " chi tiet:");
                    hienThiBang(ketQua, ketQua.length);
                } else {
                    System.out.println("✗ Khong tim thay chi tiet phieu nhap hang co ma: " + maPNH_TK);
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
    }

    public void thongKe() {
        if (soLuongCTPNH == 0) {
            System.out.println("✗ Danh sach chi tiet phieu nhap hang rong");
            return;
        }

        double tongChi = 0;
        double maxThanhTien = dsCTPNH[0].getThanhTien();
        double minThanhTien = dsCTPNH[0].getThanhTien();
        chiTietPhieuNhapHang ctpnhMax = dsCTPNH[0];
        chiTietPhieuNhapHang ctpnhMin = dsCTPNH[0];

        for (int i = 0; i < soLuongCTPNH; i++) {
            tongChi += dsCTPNH[i].getThanhTien();
            if (dsCTPNH[i].getThanhTien() > maxThanhTien) {
                maxThanhTien = dsCTPNH[i].getThanhTien();
                ctpnhMax = dsCTPNH[i];
            }
            if (dsCTPNH[i].getThanhTien() < minThanhTien) {
                minThanhTien = dsCTPNH[i].getThanhTien();
                ctpnhMin = dsCTPNH[i];
            }
        }

        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                             BANG THONG KE CHI TIET PHIEU NHAP HANG                                            ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║%n",
                "Tong so CTPNH",
                "Tong chi",
                "Chi TB",
                "CTPNH cao nhat",
                "CTPNH thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                soLuongCTPNH,
                tongChi,
                (soLuongCTPNH > 0 ? tongChi / soLuongCTPNH : 0),
                ctpnhMax.getMaPNH() + "/" + ctpnhMax.getMaThuoc(),
                ctpnhMin.getMaPNH() + "/" + ctpnhMin.getMaThuoc(),
                maxThanhTien - minThanhTien);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    public void hienThiBang(chiTietPhieuNhapHang[] arr, int size) {
        final String LINE = "═════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out
                .println("║                    DANH SACH CHI TIET PHIEU NHAP HANG                   ║");
        System.out
                .println("╠══════════════╦══════════════╦═══════════╦═══════════════╦═══════════════╣");
        System.out
                .println("║   Ma PNH     ║  Ma Thuoc    ║ So Luong  ║   Don Gia     ║  Thanh Tien   ║");
        System.out
                .println("╠══════════════╬══════════════╬═══════════╬═══════════════╬═══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.printf("║ %-12s ║ %-12s ║ %-9d ║ %13.2f ║ %13.2f ║%n",
                        arr[i].getMaPNH(),
                        arr[i].getMaThuoc(),
                        arr[i].getSoLuong(),
                        arr[i].getDonGia(),
                        arr[i].getThanhTien());
            }
        }

        System.out
                .println("╚══════════════╩══════════════╩═══════════╩═══════════════╩═══════════════╝");
        System.out.println("Tong so: " + size + " chi tiet phieu nhap hang");
    }

    public void XuatDS() {
        if (soLuongCTPNH == 0) {
            System.out.println("✗ Danh sach chi tiet phieu nhap hang rong");
        } else {
            hienThiBang(dsCTPNH, soLuongCTPNH);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chi tiet phieu nhap hang muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println("✗ So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Loi: Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("\n--- Nhap chi tiet phieu nhap hang thu " + (soLuongCTPNH + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            THONG BAO FILE KHONG TON TAI                               ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-79s", tenFile) + " ║");
            System.out.println(
                    "║ → Bat dau voi danh sach RONG. Hay them chi tiet phieu nhap hang moi!                  ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsCTPNH = new chiTietPhieuNhapHang[0];
            this.soLuongCTPNH = 0;
            return;
        }

        System.out.println("→ Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co chi tiet phieu nhap hang de doc.");
                this.dsCTPNH = new chiTietPhieuNhapHang[0];
                this.soLuongCTPNH = 0;
                return;
            }

            this.dsCTPNH = new chiTietPhieuNhapHang[count];
            this.soLuongCTPNH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongCTPNH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String maPNH = parts[0].trim();
                        String maThuoc = parts[1].trim();
                        int soLuong = Integer.parseInt(parts[2].trim());
                        double donGia = Double.parseDouble(parts[3].trim());

                        dsCTPNH[soLuongCTPNH] = new chiTietPhieuNhapHang(maPNH, maThuoc, soLuong, donGia);
                        soLuongCTPNH++;

                    } catch (NumberFormatException e) {
                        System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 4)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongCTPNH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongCTPNH + "/" + count + " chi tiet");
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongCTPNH);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsCTPNH = new chiTietPhieuNhapHang[0];
            this.soLuongCTPNH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongCTPNH);

            for (int i = 0; i < soLuongCTPNH; i++) {
                chiTietPhieuNhapHang ctpnh = dsCTPNH[i];
                pw.printf("%s,%s,%d,%.2f%n",
                        ctpnh.getMaPNH(),
                        ctpnh.getMaThuoc(),
                        ctpnh.getSoLuong(),
                        ctpnh.getDonGia());
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongCTPNH);
            System.out.printf("║ Vao file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    public chiTietPhieuNhapHang[] getDsCTPNH() {
        return Arrays.copyOf(dsCTPNH, soLuongCTPNH);
    }

    public int getSoLuongCTPNH() {
        return soLuongCTPNH;
    }
}