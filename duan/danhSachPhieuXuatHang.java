package duan;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class danhSachPhieuXuatHang implements ChucNang, IFile {
    private phieuXuatHang[] dsPXH = new phieuXuatHang[0];
    private int soLuongPXH;

    public danhSachPhieuXuatHang() {
        this.dsPXH = new phieuXuatHang[0];
        this.soLuongPXH = 0;
    }

    // THEM
    public void themPhieuXuatHang(phieuXuatHang pxh) {
        if (timKiemTheoMa(pxh.getMaPXH()) != null) {
            System.out.println("Ma phieu xuat hang da ton tai");
            return;
        }
        dsPXH = Arrays.copyOf(dsPXH, soLuongPXH + 1);
        dsPXH[soLuongPXH] = pxh;
        soLuongPXH++;
        System.out.println("Them phieu xuat hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        phieuXuatHang pxhMoi;
        boolean maBiTrung;

        do {
            maBiTrung = false;
            pxhMoi = new phieuXuatHang();

            System.out.println("--- Nhap thong tin phieu xuat hang moi ---");
            pxhMoi.nhapPhieuXuatHang(); // Nhập tất cả, bao gồm cả mã PXH

            // Kiểm tra trùng mã
            if (timKiemTheoMa(pxhMoi.getMaPXH()) != null) {
                System.out.println("✗ Ma phieu xuat hang da ton tai! Vui long nhap lai toan bo thong tin.");
                maBiTrung = true;
            } else {
                themPhieuXuatHang(pxhMoi);
                System.out.println("✓ Da them phieu xuat hang thanh cong!");
            }

        } while (maBiTrung);
    }

    // XOA
    public void xoaPhieuXuatHang(String maPXH) {
        int vt = -1;
        for (int i = 0; i < soLuongPXH; i++) {
            if (dsPXH[i].getMaPXH().equalsIgnoreCase(maPXH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay phieu xuat hang co ma " + maPXH);
            return;
        }

        for (int j = vt; j < soLuongPXH - 1; j++) {
            dsPXH[j] = dsPXH[j + 1];
        }
        dsPXH = Arrays.copyOf(dsPXH, soLuongPXH - 1);
        soLuongPXH--;
        System.out.println("✓ Xoa phieu xuat hang co ma " + maPXH + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongPXH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu xuat hang can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaPhieuXuatHang(maCanXoa);
    }

    // SUA
    @Override
    public void Sua() {
        if (soLuongPXH == 0) {
            System.out.println("✗ Danh sach phieu xuat hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu xuat hang can sua: ");
        String ma = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < soLuongPXH; i++) {
            if (dsPXH[i].getMaPXH().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("✗ Khong tim thay phieu xuat hang co ma: " + ma);
            return;
        }

        phieuXuatHang pxh = dsPXH[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║           SUA THONG TIN PHIEU XUAT HANG: " + String.format("%-25s", ma) + "║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma thuoc                                                  ║");
            System.out.println("║ 2. Sua so luong                                                  ║");
            System.out.println("║ 3. Sua don gia                                                   ║");
            System.out.println("║ 4. Sua ma khach hang                                             ║");
            System.out.println("║ 5. Sua tat ca thong tin (tru ma phieu & thanh tien)              ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-5): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ma thuoc moi: ");
                    pxh.setMaThuoc(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap so luong moi: ");
                    pxh.setSoLuong(Integer.parseInt(sc.nextLine()));
                    pxh.thanhTien(); // tự động tính lại
                    break;

                case "3":
                    System.out.print("Nhap don gia moi: ");
                    pxh.setDonGia(Double.parseDouble(sc.nextLine()));
                    pxh.thanhTien(); // tự động tính lại
                    break;

                case "4":
                    System.out.print("Nhap ma khach hang moi: ");
                    pxh.setMaKH(sc.nextLine());
                    break;

                case "5":
                    System.out.println("\n>> Nhap lai tat ca thong tin (tru ma phieu & thanh tien):");
                    String maCu = pxh.getMaPXH(); // giữ lại mã cũ
                    System.out.print("Nhap ma thuoc: ");
                    pxh.setMaThuoc(sc.nextLine());
                    System.out.print("Nhap so luong: ");
                    pxh.setSoLuong(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap don gia: ");
                    pxh.setDonGia(Double.parseDouble(sc.nextLine()));
                    System.out.print("Nhap ma khach hang: ");
                    pxh.setMaKH(sc.nextLine());
                    pxh.thanhTien(); // tự động tính lại
                    pxh.setMaPXH(maCu); // giữ nguyên mã phiếu
                    break;

                case "0":
                    System.out.println(">> Hoan thanh sua thong tin phieu xuat hang!");
                    tiepTuc = false;
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    // TIM KIEM
    public phieuXuatHang timKiemTheoMa(String maPXH) {
        for (int i = 0; i < soLuongPXH; i++) {
            if (dsPXH[i].getMaPXH().equalsIgnoreCase(maPXH)) {
                return dsPXH[i];
            }
        }
        return null;
    }

    public phieuXuatHang[] timKiemTheoMaThuoc(String maThuoc) {
        phieuXuatHang[] ketQua = new phieuXuatHang[soLuongPXH];
        int dem = 0;
        for (int i = 0; i < soLuongPXH; i++) {
            if (dsPXH[i].getMaThuoc().toLowerCase().contains(maThuoc.toLowerCase())) {
                ketQua[dem] = dsPXH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongPXH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM PHIEU XUAT HANG ---");
        System.out.println("1. Tim theo ma phieu xuat hang");
        System.out.println("2. Tim theo ma thuoc");
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
                System.out.print("Nhap ma phieu xuat hang can tim: ");
                String maPXH = sc.nextLine();
                phieuXuatHang pxh = timKiemTheoMa(maPXH);
                if (pxh != null) {
                    System.out.println("✓ Tim thay phieu xuat hang:");
                    hienThiBang(new phieuXuatHang[] { pxh }, 1);
                } else {
                    System.out.println("✗ Khong tim thay phieu xuat hang co ma: " + maPXH);
                }
                break;
            case 2:
                System.out.print("Nhap ma thuoc can tim: ");
                String maThuoc = sc.nextLine();
                phieuXuatHang[] ketQuaThuoc = timKiemTheoMaThuoc(maThuoc);
                if (ketQuaThuoc.length > 0) {
                    System.out.println("✓ Tim thay " + ketQuaThuoc.length + " phieu xuat hang:");
                    hienThiBang(ketQuaThuoc, ketQuaThuoc.length);
                } else {
                    System.out.println("✗ Khong tim thay phieu xuat hang co ma thuoc: " + maThuoc);
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
    }

    public void thongKe() {
        if (soLuongPXH == 0) {
            System.out.println("✗ Danh sach phieu xuat hang rong");
            return;
        }

        double tongDoanhThu = 0;
        double maxThanhTien = dsPXH[0].getthanhTien();
        double minThanhTien = dsPXH[0].getthanhTien();
        phieuXuatHang pxhMax = dsPXH[0];
        phieuXuatHang pxhMin = dsPXH[0];

        for (int i = 0; i < soLuongPXH; i++) {
            tongDoanhThu += dsPXH[i].getthanhTien();
            if (dsPXH[i].getthanhTien() > maxThanhTien) {
                maxThanhTien = dsPXH[i].getthanhTien();
                pxhMax = dsPXH[i];
            }
            if (dsPXH[i].getthanhTien() < minThanhTien) {
                minThanhTien = dsPXH[i].getthanhTien();
                pxhMin = dsPXH[i];
            }
        }

        // Bảng thống kê ngang
        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                  BANG THONG KE PHIEU XUAT HANG                                                ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║%n",
                "Tong so PXH",
                "Tong doanh thu",
                "Doanh thu TB",
                "PXH cao nhat",
                "PXH thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                soLuongPXH,
                tongDoanhThu,
                tongDoanhThu / soLuongPXH,
                pxhMax.getMaPXH(),
                pxhMin.getMaPXH(),
                maxThanhTien - minThanhTien);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    public void hienThiBang(phieuXuatHang[] arr, int size) {
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out
                .println("║                              DANH SACH PHIEU XUAT HANG                                  ║");
        System.out
                .println("╠══════════════╦══════════════╦═══════════╦═══════════════╦═══════════════╦═══════════════╣");
        System.out
                .println("║   Ma PXH     ║  Ma Thuoc    ║ So Luong  ║   Don Gia     ║  Thanh Tien   ║    Ma KH      ║");
        System.out
                .println("╠══════════════╬══════════════╬═══════════╬═══════════════╬═══════════════╬═══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.printf("║ %-12s ║ %-12s ║ %-9d ║ %13.2f ║ %13.2f ║ %-13s ║%n",
                        arr[i].getMaPXH(),
                        arr[i].getMaThuoc(),
                        arr[i].getSoLuong(),
                        arr[i].getDonGia(),
                        arr[i].getthanhTien(),
                        arr[i].getmaKH());
            }
        }

        System.out
                .println("╚══════════════╩══════════════╩═══════════╩═══════════════╩═══════════════╩═══════════════╝");
        System.out.println("Tong so: " + size + " phieu xuat hang");
    }

    public void XuatDS() {
        if (soLuongPXH == 0) {
            System.out.println("✗ Danh sach phieu xuat hang rong");
        } else {
            hienThiBang(dsPXH, soLuongPXH);
        }
    }
    // NHAP

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu xuat hang muon them: ");
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
            System.out.println("\n--- Nhap phieu xuat hang thu " + (soLuongPXH + 1) + " ---");
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
                    "║                            THONG BAO FILE KHONG TON TAI                              ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-80s", tenFile) + " ║");
            System.out.println(
                    "║ → Bat dau voi danh sach RONG. Hay them phieu xuat hang moi!                          ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsPXH = new phieuXuatHang[0];
            this.soLuongPXH = 0;
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
                System.out.println("File khong co phieu xuat hang de doc.");
                this.dsPXH = new phieuXuatHang[0];
                this.soLuongPXH = 0;
                return;
            }

            this.dsPXH = new phieuXuatHang[count];
            this.soLuongPXH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongPXH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String maPXH = parts[0].trim();
                        String maThuoc = parts[1].trim();
                        int soLuong = Integer.parseInt(parts[2].trim());
                        double donGia = Double.parseDouble(parts[3].trim());
                        String maKH = parts[4].trim();

                        dsPXH[soLuongPXH] = new phieuXuatHang(maPXH, maThuoc, soLuong, donGia, maKH);
                        soLuongPXH++;

                    } catch (NumberFormatException e) {
                        System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 5)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongPXH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongPXH + "/" + count + " phieu xuat hang");
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongPXH);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsPXH = new phieuXuatHang[0];
            this.soLuongPXH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongPXH);

            for (int i = 0; i < soLuongPXH; i++) {
                phieuXuatHang pxh = dsPXH[i];
                pw.printf("%s,%s,%d,%.2f,%s%n",
                        pxh.getMaPXH(),
                        pxh.getMaThuoc(),
                        pxh.getSoLuong(),
                        pxh.getDonGia(),
                        pxh.getmaKH());
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongPXH);
            System.out.printf("║ Vao file: %-74s  ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Getter cho danh sach
    public phieuXuatHang[] getDsPXH() {
        return Arrays.copyOf(dsPXH, soLuongPXH);
    }

    public int getSoLuongPXH() {
        return soLuongPXH;
    }
}
