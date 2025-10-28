package duan;

public class danhSachNhanVien {
    private nhanVien[] dsNV;
    private int soLuongNV;
    private final int MAX_NV = 100;

    public danhSachNhanVien() {
        this.dsNV = new nhanVien[MAX_NV];
        this.soLuongNV = 0;
    }

    public danhSachNhanVien(danhSachNhanVien other){
        this.dsNV = new nhanVien[100];
        this.soLuongNV = other.soLuongNV;
    }

    //them nhân viên theo ma
    public void themNhanVien(nhanVien nv) {
        if(soLuongNV > MAX_NV){
            System.out.println("Danh sach nhan vien day");
            return;
        }else{
            dsNV[soLuongNV] = new nhanVien(nv);
            nv.NhapThongTinNV();
            if(timKiemTheoMa(nv.getMaNV()) != null){
                System.out.println("ma nhan vien da ton tai");
                return;
            }
            soLuongNV++;
            System.out.println("Them nhan vien thanh cong");
        }
    }
//tim kiem nhan vien theo ma
    public nhanVien timKiemTheoMa(String maNV){
        for(int i = 0; i < soLuongNV; i++){
            if(dsNV[i].getMaNV().equals(maNV)){
                return dsNV[i];
            }
        }
        return null;
    }
//tim kiem nhan vien theo ten
    public nhanVien[] timKiemNhanVien(String tenNV){
        nhanVien[] ketQua = new nhanVien[soLuongNV];
        int dem = 0;
        for(int i = 0; i < soLuongNV; i++){
            if(dsNV[i].getTenNV().equalsIgnoreCase(tenNV)){
                ketQua[dem] = dsNV[i];
                dem++;
            }
        }
        nhanVien[] result = new nhanVien[dem];
        for(int i = 0; i < dem; i++){
            result[i] = ketQua[i];
        }
        return result;
    }

    //hien thi danh sach nhan vien
    public void hienThiDanhSachNV(){
        if (soLuongNV == 0) {
            System.out.println("Danh sach nhan vien rong");
        } else {
            System.out.println("Danh sach nhan vien:");
            for (int i = 0; i < soLuongNV; i++) {
                System.out.println("Nhan vien " + (i + 1) + ":");
                dsNV[i].hienThiThongTinNV();
            }
        }
    }

    //xoa nhan vien theo ma
    public void xoaNhanVien(String maNV){
        if(soLuongNV == 0){
            System.out.println("Danh sach nhan vien rong");
        }else{
            for(int i = 0; i < soLuongNV; i++){
                if(dsNV[i].getMaNV().equals(maNV)){
                    for(int j = i; j < soLuongNV - 1; j++){
                        dsNV[j] = dsNV[j + 1];
                    }
                    dsNV[soLuongNV - 1] = null;
                    soLuongNV--;
                    System.out.println("Da xoa nhan vien co ma "+maNV);
                }
            }
        }
        System.out.println("Khong tim thay nhan vien co ma"+maNV);
    }

    //sua thong tin nhan vien theo ma
    public void suaThongTinNV(String maNV){
        nhanVien nv = timKiemTheoMa(maNV);
        if(nv != null){
            nv.suaThongTinNV();
        }else{
            System.out.println("Khong tim thay nhan vien co ma"+maNV);
        }
    }
    
    //tinh tong luong
    public double tinhTongLuong(){
        double tongLuong = 0;
        for(int i = 0; i < soLuongNV; i++){
            tongLuong += dsNV[i].getLuong();
        }
        return tongLuong;
    }

    //thong ke
    public void thongKe(){
        if(soLuongNV == 0){
            System.out.println("Danh sach rong");
            return;
        }
        double tongLuong = tinhTongLuong();
        double tinhLuongTB = tongLuong / soLuongNV;

        //nhan vien co luong cao nhat
        nhanVien nvMax = dsNV[0];
        for(int i = 0; i < soLuongNV; i++){
            if(dsNV[i].getLuong() > nvMax.getLuong()){
                nvMax = dsNV[i];
            }
        }

        //thong ke theo gioi tinh
        int nam = 0, nu = 0;
        for(int i = 0; i < soLuongNV; i++){
            if(dsNV[i].getGt().equalsIgnoreCase("Nam")){
                nam++;
            }else{
                nu++;
            }
        }

        System.out.println("Thong ke nhan vien: ");
        System.out.println("Tong so nhan vien la: "+soLuongNV);
        System.out.println("So nhan vien nam la: "+nam);
        System.out.println("So nhan vien nu la: "+nu);
        System.out.println("Tong luong la: "+tongLuong +"VND" );
        System.out.println("Luong trung binh la: "+tinhLuongTB +"VND");
        System.out.println("Nhan vien co luong cao nhat la: "+nvMax.getTenNV() + "-" +nvMax.getLuong() + "VND");
    }

    //sap xep theo ten
    public void sapXepTheoTen(){
        for(int i = 0; i < soLuongNV; i++){
            for(int j = i; j < soLuongNV - 1; j++){
                if(dsNV[i].getTenNV().compareToIgnoreCase(dsNV[j].getTenNV()) > 0){
                    nhanVien tmp = dsNV[i];
                    dsNV[i] = dsNV[j];
                    dsNV[j] = tmp;
                }
            }
        }
        System.out.println("Da sap xep theo ten");
    }

    //sap xep theo luong
    public void sapXepTheoLuong(){
        for(int i = 0; i < soLuongNV; i++){
            for(int j = i; j < soLuongNV - 1; j++){
                if(dsNV[i].getLuong() > dsNV[j].getLuong()){
                    nhanVien tmp = dsNV[i];
                    dsNV[i] = dsNV[j];
                    dsNV[j] = tmp;
                }
            }
        }
        System.out.println("Da sap xep theo luong");
    }

    public int getSoLuongNV(){
        return soLuongNV;
    }

    public nhanVien[] getDanhSach(){
        nhanVien[] kq = new nhanVien[soLuongNV];
        for(int i = 0; i < soLuongNV; i++){
            kq[i] = dsNV[i];
        }
        return kq;
    }

    //hien thi danh sach nhan vien(chi tiet)
    public void hienThiDanhSachChiTiet(){
        if(soLuongNV == 0){
            System.out.println("Danh sach nhan vien rong");
            return;
        }

        System.out.println("===DANH SACH NHAN VIEN(CHI TIET)===");
        System.out.printf("%-10s %20s %-10s %-15s %-10s \n", "Ma NV", "Ten NV", "Gioi tinh", "SDT", "Luong" );

        for(int i = 0; i < soLuongNV; i++){
            System.out.printf("%-10s %-20s %-10s %-15s %-10.0f\n",
                dsNV[i].getMaNV(),
                dsNV[i].getTenNV(),
                dsNV[i].getGt(),
                dsNV[i].getSdt(),
                dsNV[i].getLuong());
        }
    }
}
