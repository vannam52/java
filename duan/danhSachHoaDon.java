package duan;

import java.io.*;
import java.util.*;

public class danhSachHoaDon implements ChucNang, IFile {
    private hoaDon[] dsHoaDon = new hoaDon[0];
    private int soLuongHoaDon;

    private static Scanner sc = new Scanner(System.in);

    // Constructor mac dinh
    public danhSachHoaDon() {
        this.dsHoaDon = new hoaDon[0];
        this.soLuongHoaDon = 0;
    }

    // Constructor sao chep
    public danhSachHoaDon(danhSachHoaDon ds) {
        this.soLuongHoaDon = ds.soLuongHoaDon;
        this.dsHoaDon = new hoaDon[ds.soLuongHoaDon];
        for (int i = 0; i < this.soLuongHoaDon; i++) {
            this.dsHoaDon[i] = new hoaDon(ds.dsHoaDon[i]);
        }
    }

    // Kiem tra ma hoa don da ton tai hay chua
    public boolean kiemTraMa(String maHD) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equals(maHD))
                return true;
        }
        return false;
    }

    // Them mot hoa don vao danh sach
    public void themHoaDon(hoaDon hd) {
        if (kiemTraMa(hd.getMaHD())) {
            System.out.println("Ma hoa don da ton tai");
            return;
        }
        dsHoaDon = Arrays.copyOf(dsHoaDon, soLuongHoaDon + 1);
        dsHoaDon[soLuongHoaDon] = hd;
        soLuongHoaDon++;
        System.out.println("Them hoa don thanh cong");
    }

    // Them hoa don moi (nhap tu ban phim)
    @Override
    public void Them() {
        hoaDon hdMoi = new hoaDon();
        boolean maBiTrung;
        do {
            maBiTrung = false;
            hdMoi.Nhap();
            if (kiemTraMa(hdMoi.getMaHD())) {
                System.out.println("Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);
        themHoaDon(hdMoi);
    }

    // Nhap nhieu hoa don
    public void nhapNHoaDon() {
        int n;
        try {
            System.out.print("Nhap so luong hoa don can them: ");
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
            System.out.println("\n--- Nhap hoa don thu " + (soLuongHoaDon + 1) + " ---");
            Them();
        }
    }

    // Xoa hoa don theo ma
    @Override
    public void Xoa() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can xoa: ");
        String maHD = sc.nextLine();

        int vt = -1;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay hoa don co ma " + maHD);
            return;
        }

        for (int j = vt; j < soLuongHoaDon - 1; j++) {
            dsHoaDon[j] = dsHoaDon[j + 1];
        }
        dsHoaDon = Arrays.copyOf(dsHoaDon, soLuongHoaDon - 1);
        soLuongHoaDon--;
        System.out.println("Xoa hoa don co ma " + maHD + " thanh cong!");
    }

    // Sua thong tin hoa don
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
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║          SUA THONG TIN HOA DON: " + String.format("%-10s", maHD) + "                     ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma khach hang                                             ║");
            System.out.println("║ 2. Sua ma nhan vien                                              ║");
            System.out.println("║ 3. Sua ngay lap                                                  ║");
            System.out.println("║ 4. Sua chi tiet hoa don                                          ║");
            System.out.println("║ 5. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
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
                            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2100)
                                throw new Exception("Ngay lap khong hop le");
                            hd.setNgayLap(ngayMoi);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + ". Vui long nhap lai.");
                        }
                    }
                    break;

                case "4":
                    System.out.println(">> Sua chi tiet hoa don chua duoc ho tro!");
                    break;

                case "5":
                    System.out.println("\n>> Nhap lai tat ca thong tin:");
                    hd.Nhap();
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

    // Tim kiem hoa don (theo ma khach hang hoac ma nhan vien)
    @Override
    public void TimKiem() {
        System.out.println("Tim kiem hoa don theo:");
        System.out.println("1. Ma khach hang");
        System.out.println("2. Ma nhan vien");
        System.out.print("Chon loai tim kiem (1/2): ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Nhap ma khach hang can tim: ");
            String maKH = sc.nextLine().trim();

            hoaDon[] ketQua = timKiemTheoMaKH(maKH);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " hoa don cua khach hang ma " + maKH + ":");
                hienThiBangHoaDon(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay hoa don cua khach hang ma: " + maKH);
            }
        } else if (choice.equals("2")) {
            System.out.print("Nhap ma nhan vien can tim: ");
            String maNV = sc.nextLine().trim();

            hoaDon[] ketQua = timKiemTheoMaNV(maNV);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " hoa don cua nhan vien ma " + maNV + ":");
                hienThiBangHoaDon(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay hoa don cua nhan vien ma: " + maNV);
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    // Tim kiem hoa don theo ma khach hang
    private hoaDon[] timKiemTheoMaKH(String maKH) {
        int count = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equalsIgnoreCase(maKH)) {
                count++;
            }
        }

        hoaDon[] ketQua = new hoaDon[count];
        int index = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equalsIgnoreCase(maKH)) {
                ketQua[index++] = dsHoaDon[i];
            }
        }
        return ketQua;
    }

    // Tim kiem hoa don theo ma nhan vien
    private hoaDon[] timKiemTheoMaNV(String maNV) {
        int count = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equalsIgnoreCase(maNV)) {
                count++;
            }
        }

        hoaDon[] ketQua = new hoaDon[count];
        int index = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equalsIgnoreCase(maNV)) {
                ketQua[index++] = dsHoaDon[i];
            }
        }
        return ketQua;
    }

    // Hien thi bang hoa don
    private void hienThiBangHoaDon(hoaDon[] danhSach, int soLuong) {
        if (soLuong == 0) {
            System.out.println("Danh sach rong");
            return;
        }

        int[] colWidths = {12, 12, 12, 12, 15};
        String[] headers = {"Ma HD", "Ma KH", "Ma NV", "Ngay lap", "Tong tien"};

        String border = buildBorder(colWidths);
        String headerRow = buildRowFormat(colWidths, headers);

        System.out.println(border);
        System.out.println(headerRow);
        System.out.println(border);

        for (int i = 0; i < soLuong; i++) {
            String[] rowData = {
                safeString(danhSach[i].getMaHD()),
                safeString(danhSach[i].getMaKH()),
                safeString(danhSach[i].getMaNV()),
                safeString(danhSach[i].getNgayLap()),
                String.format("%.0f", danhSach[i].getTongTien())
            };
            System.out.println(buildRowFormat(colWidths, rowData));
        }

        System.out.println(border);
    }

    // Hien thi danh sach hoa don
    public void hienThiDanhSachHoaDon() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        int[] colWidths = {12, 12, 12, 12, 15};
        String[] headers = {"Ma HD", "Ma KH", "Ma NV", "Ngay lap", "Tong tien"};

        String border = buildBorder(colWidths);
        String titleBorder = buildTitleBorder(colWidths);
        String headerRow = buildRowFormat(colWidths, headers);

        System.out.println(titleBorder);
        System.out.println(buildCenteredTitle("DANH SACH HOA DON", colWidths));
        System.out.println(border);
        System.out.println(headerRow);
        System.out.println(border);

        for (int i = 0; i < soLuongHoaDon; i++) {
            String[] rowData = {
                safeString(dsHoaDon[i].getMaHD()),
                safeString(dsHoaDon[i].getMaKH()),
                safeString(dsHoaDon[i].getMaNV()),
                safeString(dsHoaDon[i].getNgayLap()),
                String.format("%.0f", dsHoaDon[i].getTongTien())
            };
            System.out.println(buildRowFormat(colWidths, rowData));
        }

        System.out.println(buildBottomBorder(colWidths));
        System.out.println("Tong so: " + soLuongHoaDon + " hoa don");
    }

    // Tao duong vien giua
    private String buildBorder(int[] colWidths) {
        StringBuilder sb = new StringBuilder("╠");
        for (int i = 0; i < colWidths.length; i++) {
            sb.append(repeatChar('═', colWidths[i]));
            if (i < colWidths.length - 1) {
                sb.append("╬");
            }
        }
        sb.append("╣");
        return sb.toString();
    }

    // Tao duong vien tren
    private String buildTitleBorder(int[] colWidths) {
        StringBuilder sb = new StringBuilder("╔");
        for (int i = 0; i < colWidths.length; i++) {
            sb.append(repeatChar('═', colWidths[i]));
            if (i < colWidths.length - 1) {
                sb.append("═");
            }
        }
        sb.append("╗");
        return sb.toString();
    }

    // Tao duong vien duoi
    private String buildBottomBorder(int[] colWidths) {
        StringBuilder sb = new StringBuilder("╚");
        for (int i = 0; i < colWidths.length; i++) {
            sb.append(repeatChar('═', colWidths[i]));
            if (i < colWidths.length - 1) {
                sb.append("╩");
            }
        }
        sb.append("╝");
        return sb.toString();
    }

    // Tao tieu de can giua
    private String buildCenteredTitle(String title, int[] colWidths) {
        int totalWidth = 0;
        for (int width : colWidths) {
            totalWidth += width;
        }
        totalWidth += (colWidths.length - 1);

        int padding = (totalWidth - title.length()) / 2;
        StringBuilder sb = new StringBuilder("║");
        sb.append(repeatChar(' ', padding));
        sb.append(title);
        sb.append(repeatChar(' ', totalWidth - padding - title.length()));
        sb.append("║");
        return sb.toString();
    }

    // Tao dong du lieu trong bang
    private String buildRowFormat(int[] colWidths, String[] data) {
        StringBuilder sb = new StringBuilder("║");
        for (int i = 0; i < colWidths.length; i++) {
            String value = i < data.length ? data[i] : "";
            sb.append(String.format(" %-" + (colWidths[i] - 2) + "s ║", value));
        }
        return sb.toString();
    }

    // Lap lai ky tu n lan
    private String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Xu ly chuoi null
    private String safeString(String s) {
        return s == null ? "" : s;
    }

    // Menu thong ke hoa don
    public void menuThongKe() {
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              MENU THONG KE HOA DON                               ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Thong ke chung                                                ║");
            System.out.println("║ 2. Thong ke theo khach hang                                      ║");
            System.out.println("║ 3. Thong ke theo nhan vien                                       ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-3): ");

            String luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    thongKeChung();
                    break;
                case "2":
                    thongKeTheoKhachHang();
                    break;
                case "3":
                    thongKeTheoNhanVien();
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

    // Thong ke chung ve hoa don
    public void thongKeChung() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              THONG KE DANH SACH HOA DON                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        System.out.printf("║ Tong so hoa don: %48d║%n", soLuongHoaDon);

        hoaDon hdMax = dsHoaDon[0];
        for (int i = 1; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getTongTien() > hdMax.getTongTien()) {
                hdMax = dsHoaDon[i];
            }
        }
        System.out.printf("║ Hoa don co tong tien cao nhat: %-33s║%n", hdMax.getMaHD());
        System.out.printf("║ Tong tien: %51.0f VND ║%n", hdMax.getTongTien());

        double tongDoanhThu = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            tongDoanhThu += dsHoaDon[i].getTongTien();
        }
        System.out.printf("║ Tong doanh thu: %46.0f VND ║%n", tongDoanhThu);
        System.out.printf("║ Trung binh tien/hoa don: %35.2f VND ║%n",
                tongDoanhThu / soLuongHoaDon);

        String[] dsMaKH = new String[soLuongHoaDon];
        int soKhachHang = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            boolean daTonTai = false;
            for (int j = 0; j < soKhachHang; j++) {
                if (dsHoaDon[i].getMaKH().equals(dsMaKH[j])) {
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai) {
                dsMaKH[soKhachHang] = dsHoaDon[i].getMaKH();
                soKhachHang++;
            }
        }
        System.out.printf("║ So khach hang da mua: %43d║%n", soKhachHang);
        if (soKhachHang > 0) {
            System.out.printf("║ Trung binh hoa don/khach: %39.2f║%n",
                    (double) soLuongHoaDon / soKhachHang);
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Thong ke theo khach hang
    public void thongKeTheoKhachHang() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma khach hang can thong ke: ");
        String maKH = sc.nextLine().trim();

        int soLuong = 0;
        double tongTien = 0;

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equalsIgnoreCase(maKH)) {
                soLuong++;
                tongTien += dsHoaDon[i].getTongTien();
            }
        }

        if (soLuong == 0) {
            System.out.println("Khach hang chua co hoa don nao!");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ Thong ke khach hang: %-44s║%n", maKH);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ So luong hoa don: %47d║%n", soLuong);
        System.out.printf("║ Tong chi tieu: %45.0f VND ║%n", tongTien);
        System.out.printf("║ Trung binh/hoa don: %40.2f VND ║%n", tongTien / soLuong);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Thong ke theo nhan vien
    public void thongKeTheoNhanVien() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma nhan vien can thong ke: ");
        String maNV = sc.nextLine().trim();

        int soLuong = 0;
        double tongTien = 0;

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equalsIgnoreCase(maNV)) {
                soLuong++;
                tongTien += dsHoaDon[i].getTongTien();
            }
        }

        if (soLuong == 0) {
            System.out.println("Nhan vien chua lap hoa don nao!");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ Thong ke nhan vien: %-45s║%n", maNV);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ So luong hoa don da lap: %40d║%n", soLuong);
        System.out.printf("║ Tong doanh thu: %45.0f VND ║%n", tongTien);
        System.out.printf("║ Trung binh/hoa don: %40.2f VND ║%n", tongTien / soLuong);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Doc danh sach hoa don tu file
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

            while ((line = br.readLine()) != null && this.soLuongHoaDon < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    try {
                        String maHD = parts[0].trim();
                        String maKH = parts[1].trim();
                        String maNV = parts[2].trim();
                        String ngayLap = parts[3].trim();
                        double tongTien = Double.parseDouble(parts[4].trim());
                        int soLuongCT = Integer.parseInt(parts[5].trim());

                        hoaDon hd = new hoaDon();
                        hd.setMaHD(maHD);
                        hd.setMaKH(maKH);
                        hd.setMaNV(maNV);
                        hd.setNgayLap(ngayLap);
                        hd.setTongTien(tongTien);

                        this.dsHoaDon[this.soLuongHoaDon] = hd;
                        this.soLuongHoaDon++;

                    } catch (Exception e) {
                        System.err.println("Loi doc du lieu hoa don: " + e.getMessage());
                    }
                }
            }

            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                            DOC FILE THANH CONG!                                      ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsHoaDon = new hoaDon[0];
            this.soLuongHoaDon = 0;
        }
    }

    // Ghi danh sach hoa don ra file
    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongHoaDon);

            for (int i = 0; i < soLuongHoaDon; i++) {
                hoaDon hd = dsHoaDon[i];
                pw.printf("%s,%s,%s,%s,%.0f,0%n",
                        hd.getMaHD(),
                        hd.getMaKH(),
                        hd.getMaNV(),
                        hd.getNgayLap(),
                        hd.getTongTien());
            }

            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                            GHI FILE THANH CONG!                                      ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }
}