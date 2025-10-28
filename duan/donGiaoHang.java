package duan;

public class donGiaoHang {
    private String maDG;
    private String maHD;
    private String ngayGiao;
    private String trangThai;

    public donGiaoHang(){}

    public donGiaoHang(donGiaoHang other){
        this.maDG = other.maDG;
        this.maHD = other.maHD;
        this.ngayGiao = other.ngayGiao;
        this.trangThai = other.trangThai;
    }
    
    public donGiaoHang(String maDG, String maHD, String ngayGiao, String trangThai) {
        this.maDG = maDG;
        this.maHD = maHD;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
    }

    public String getMaDG() {
        return maDG;
    }
    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public String getNgayGiao() {
        return ngayGiao;
    }
    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void capNhatTrangThai(String trangThaiMoi) {
        this.trangThai = trangThaiMoi;
    }

    public void taoDonGiaoHang(){
        System.out.println("Don giao duoc tao voi ma la: " + maDG);
    }
    public void capNhatTrangThai(){
        System.out.println("Trang thai don giao hang voi ma " + maDG + " da duoc cap nhat thanh: " + trangThai);
    }
    
}
