package model;

import java.util.Scanner;

public class NhanVien extends NhanSu {
	/* properties */
	private TruongPhong truongPhongQuanLy;
	private String maSoTruongPhong;
	
	/* constructors */
	public NhanVien() {
		super();
	}
	
	public NhanVien(String maSo, String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay, float luongThang, String maSoTruongPhong) {
		super(maSo,hoTen,soDienThoai,soNgayLam,luongMotNgay,luongThang);
		this.maSoTruongPhong = maSoTruongPhong;
	}
	
	/* getters and setters */
	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}
	
	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public String getMaSoTruongPhong() {
		return maSoTruongPhong;
	}

	public void setMaSoTruongPhong(String maSoTruongPhong) {
		this.maSoTruongPhong = maSoTruongPhong;
	}
	
	/* methods */
	@Override
	public float tinhLuong() {
		this.luongMotNgay = 100;
		this.luongThang = this.soNgayLam * this.luongMotNgay;
		return this.luongThang;
	}
	
	@Override
	public void nhapThongTin(Scanner scanner) {
		super.nhapThongTin(scanner);
		System.out.println("Có trưởng phòng quản lý? 1.Có --- 2.Không");
		
		switch(Integer.parseInt(scanner.nextLine())) {
		case 1: 
			System.out.print("Mã trưởng phòng: ");
			maSoTruongPhong = scanner.nextLine();
			//maSoTruongPhong = truongPhongQuanLy.maSo;
			break;
			
		case 2: maSoTruongPhong = "";
		break;
		
		default:
			System.out.println("Vui lòng nhập lại");
			break;
		
		}
	}
	
	@Override
	public void xuatThongTin(int stt) {
		super.xuatThongTin(stt);
		System.out.println(String.format("%-30s", this.maSoTruongPhong));
	}
}
