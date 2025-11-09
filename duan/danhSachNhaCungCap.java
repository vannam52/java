package duan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class danhSachNhaCungCap implements ChucNang, IFile {
    private nhaCungCap[] dsNCC = new nhaCungCap[0];
    private int soLuongNCC;

    private static Scanner sc = new Scanner(System.in);

    // Constructor mac dinh
    public danhSachNhaCungCap() {
        this.dsNCC = new nhaCungCap[0];
        this.soLuongNCC = 0;
    }

    // Constructor sao chep
    public danhSachNhaCungCap(danhSachNhaCungCap ds) {
        this.soLuongNCC = ds.soLuongNCC;
        this.dsNCC = new nhaCungCap[ds.soLuongNCC];
        for (int i = 0; i < this.soLuongNCC; i++) {
            this.dsNCC[i] = new nhaCungCap(ds.dsNCC[i]);
        }
    }

    // Kiem tra ma nha cung cap da ton tai hay chua
    public boolean kiemTraMa(String maNCC) {
        for (int i = 0; i < soLuongNCC; i++) {
            if (dsNCC[i].getMaNCC().equals(maNCC))
                return true;
        }
        return false;
    }

    // Them mot nha cung cap vao danh sach
    public void themNhaCungCap(nhaCungCap ncc) {
        if (kiemTraMa(ncc.getMaNCC())) {
            System.out.println("Ma nha cung cap da ton tai");
            return;
        }
        dsNCC = Arrays.copyOf(dsNCC, soLuongNCC + 1);
        dsNCC[soLuongNCC] = ncc;
        soLuongNCC++;
        System.out.println("Them nha cung cap thanh cong");
    }

    // Them nha cung cap moi (nhap tu ban phim)
    @Override
    public void Them() {
        nhaCungCap nccMoi = new nhaCungCap();
        boolean maBiTrung;
        do {
            maBiTrung = false;
            nccMoi.Nhap();
            if (kiemTraMa(nccMoi.getMaNCC())) {
                System.out.println("Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);
        themNhaCungCap(nccMoi);
    }

    // Nhap nhieu nha cung cap
    public void nhapNNhaCungCap() {
        int n;
        try {
            System.out.print("Nhap so luong nha cung cap can them: ");
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
            System.out.println("\n--- Nhap nha cung cap thu " + (soLuongNCC + 1) + " ---");
            Them();
        }
    }

    // Xoa nha cung cap theo ma
    @Override
    public void Xoa() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }
        
        System.out.print("Nhap ma nha cung cap can xoa: ");
        String maNCC = sc.nextLine();
        
        int vt = -1;
        for (int i = 0; i < soLuongNCC; i++) {
            if (dsNCC[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                vt = i;
                break;
            }
        }
        
        if (vt == -1) {
            System.out.println("Khong tim thay nha cung cap co ma " + maNCC);
            return;
        }

        for (int j = vt; j < soLuongNCC - 1; j++) {
            dsNCC[j] = dsNCC[j + 1];
        }
        dsNCC = Arrays.copyOf(dsNCC, soLuongNCC - 1);
        soLuongNCC--;
        System.out.println("Xoa nha cung cap co ma " + maNCC + " thanh cong!");
    }

    // Sua thong tin nha cung cap
    @Override
    public void Sua() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }

        System.out.print("Nhap ma nha cung cap can sua: ");
        String maNCC = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongNCC; i++) {
            if (dsNCC[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma nha cung cap!");
            return;
        }

        nhaCungCap ncc = dsNCC[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║        SUA THONG TIN NHA CUNG CAP: " + String.format("%-10s", maNCC) + "       ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten nha cung cap                                  ║");
            System.out.println("║ 2. Sua dia chi                                           ║");
            System.out.println("║ 3. Sua so dien thoai                                     ║");
            System.out.println("║ 4. Sua tat ca thong tin                                  ║");
            System.out.println("║ 0. Hoan thanh                                            ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-4): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ten nha cung cap moi: ");
                    ncc.setTenNCC(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap dia chi moi: ");
                    ncc.setDiaChi(sc.nextLine());
                    break;

                case "3":
                    System.out.print("Nhap so dien thoai moi: ");
                    ncc.setSdt(sc.nextLine());
                    break;

                case "4":
                    System.out.println("\n>> Nhap lai tat ca thong tin:");
                    ncc.Nhap();
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

    // Tim kiem nha cung cap theo ma
    @Override
    public void TimKiem() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }
        
        System.out.print("Nhap ma nha cung cap can tim: ");
        String maNCC = sc.nextLine();
        
        for (int i = 0; i < soLuongNCC; i++) {
            if (dsNCC[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                dsNCC[i].Xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap co ma: " + maNCC);
    }

    // Menu thong ke nha cung cap
    public void menuThongKe() {
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║           MENU THONG KE NHA CUNG CAP                             ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Thong ke chung                                                ║");
            System.out.println("║ 2. Thong ke theo khu vuc                                         ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-2): ");

            String luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    thongKeChung();
                    break;
                case "2":
                    thongKeTheoKhuVuc();
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

    // Thong ke chung ve nha cung cap
    public void thongKeChung() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║           THONG KE DANH SACH NHA CUNG CAP                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        System.out.printf("║ Tong so nha cung cap: %43d║%n", soLuongNCC);

        String[] cacThanhPho = new String[soLuongNCC];
        int[] demThanhPho = new int[soLuongNCC];
        int soThanhPhoKhacNhau = 0;

        for (int i = 0; i < soLuongNCC; i++) {
            String diaChi = dsNCC[i].getDiaChi().trim();
            String[] cacTu = diaChi.split("\\s+");
            String thanhPho = "";

            if (cacTu.length >= 3 && cacTu[cacTu.length - 3].equalsIgnoreCase("TP")) {
                thanhPho = cacTu[cacTu.length - 3] + " " +
                        cacTu[cacTu.length - 2] + " " +
                        cacTu[cacTu.length - 1];
            } else if (cacTu.length >= 2) {
                thanhPho = cacTu[cacTu.length - 2] + " " + cacTu[cacTu.length - 1];
            } else if (cacTu.length >= 1) {
                thanhPho = cacTu[cacTu.length - 1];
            }

            if (thanhPho.isEmpty()) {
                continue;
            }

            boolean daTonTai = false;
            for (int j = 0; j < soThanhPhoKhacNhau; j++) {
                if (cacThanhPho[j].equalsIgnoreCase(thanhPho)) {
                    demThanhPho[j]++;
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai) {
                cacThanhPho[soThanhPhoKhacNhau] = thanhPho;
                demThanhPho[soThanhPhoKhacNhau] = 1;
                soThanhPhoKhacNhau++;
            }
        }

        System.out.printf("║ So thanh pho khac nhau: %41d║%n", soThanhPhoKhacNhau);
        if (soThanhPhoKhacNhau > 0) {
            System.out.printf("║ Trung binh NCC/thanh pho: %41.2f║%n",
                    (double) soLuongNCC / soThanhPhoKhacNhau);
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Thong ke nha cung cap theo khu vuc (thanh pho)
    public void thongKeTheoKhuVuc() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }

        String[] cacThanhPho = new String[soLuongNCC];
        int[] demThanhPho = new int[soLuongNCC];
        int soThanhPhoKhacNhau = 0;

        for (int i = 0; i < soLuongNCC; i++) {
            String diaChi = dsNCC[i].getDiaChi().trim();
            String[] cacTu = diaChi.split("\\s+");
            String thanhPho = "";

            if (cacTu.length >= 3 && cacTu[cacTu.length - 3].equalsIgnoreCase("TP")) {
                thanhPho = cacTu[cacTu.length - 3] + " " +
                        cacTu[cacTu.length - 2] + " " +
                        cacTu[cacTu.length - 1];
            } else if (cacTu.length >= 2) {
                thanhPho = cacTu[cacTu.length - 2] + " " + cacTu[cacTu.length - 1];
            } else if (cacTu.length >= 1) {
                thanhPho = cacTu[cacTu.length - 1];
            }

            if (thanhPho.isEmpty()) {
                continue;
            }

            boolean daTonTai = false;
            for (int j = 0; j < soThanhPhoKhacNhau; j++) {
                if (cacThanhPho[j].equalsIgnoreCase(thanhPho)) {
                    demThanhPho[j]++;
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai) {
                cacThanhPho[soThanhPhoKhacNhau] = thanhPho;
                demThanhPho[soThanhPhoKhacNhau] = 1;
                soThanhPhoKhacNhau++;
            }
        }

        System.out.println("\n╔════════════════════════════════════╦════════════╗");
        System.out.println("║           Thanh pho                ║  So luong  ║");
        System.out.println("╠════════════════════════════════════╬════════════╣");
        for (int i = 0; i < soThanhPhoKhacNhau; i++) {
            System.out.printf("║ %-34s ║ %10d ║%n", cacThanhPho[i], demThanhPho[i]);
        }
        System.out.println("╚════════════════════════════════════╩════════════╝");
        System.out.printf("Tong so thanh pho: %d%n", soThanhPhoKhacNhau);
    }

    // Hien thi danh sach nha cung cap
    public void hienThiDanhSachNCC() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sach nha cung cap rong");
            return;
        }
        System.out.println("╔════════════╦════════════════════╦══════════════════════════════╦════════════╗");
        System.out.println("║   Ma NCC   ║     Ten NCC        ║          Dia Chi             ║ So DT      ║");
        System.out.println("╠════════════╬════════════════════╬══════════════════════════════╬════════════╣");
        for (int i = 0; i < soLuongNCC; i++) {
            System.out.printf("║ %-10s ║ %-18s ║ %-28s ║ %-10s ║%n",
                    dsNCC[i].getMaNCC(),
                    dsNCC[i].getTenNCC(),
                    dsNCC[i].getDiaChi(),
                    dsNCC[i].getSdt());
        }
        System.out.println("╚════════════╩════════════════════╩══════════════════════════════╩════════════╝");
        System.out.println("Tong so: " + soLuongNCC + " nha cung cap");
    }

    // Doc danh sach nha cung cap tu file
    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsNCC = new nhaCungCap[0];
            this.soLuongNCC = 0;
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
                System.out.println("File khong co nha cung cap de doc.");
                this.dsNCC = new nhaCungCap[0];
                this.soLuongNCC = 0;
                return;
            }

            this.dsNCC = new nhaCungCap[count];
            this.soLuongNCC = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && this.soLuongNCC < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String maNCC = parts[0].trim();
                        String tenNCC = parts[1].trim();
                        String diaChi = parts[2].trim();
                        String sdt = parts[3].trim();

                        this.dsNCC[this.soLuongNCC] = new nhaCungCap(maNCC, tenNCC, diaChi, sdt);
                        this.soLuongNCC++;

                    } catch (Exception e) {
                        System.err.println("Dong " + lineNumber + ": Loi doc du lieu - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 4)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (this.soLuongNCC < count) {
                System.out.println("Canh bao: Chi doc duoc " + this.soLuongNCC + "/" + count + " nha cung cap");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongNCC);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsNCC = new nhaCungCap[0];
            this.soLuongNCC = 0;
        }
    }

    // Ghi danh sach nha cung cap ra file
    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongNCC);

            for (int i = 0; i < soLuongNCC; i++) {
                nhaCungCap ncc = dsNCC[i];
                pw.printf("%s,%s,%s,%s%n",
                        ncc.getMaNCC(),
                        ncc.getTenNCC(),
                        ncc.getDiaChi(),
                        ncc.getSdt());
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongNCC);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }
}