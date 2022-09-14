package model;


import java.util.ArrayList;
import java.util.Objects;

public class Province {
	private int maTinhInt;
	private String tenTinhString;
	
	public Province(int maTinhInt, String tenTinhString) {
		super();
		this.maTinhInt = maTinhInt;
		this.tenTinhString = tenTinhString;
	}

	public int getMaTinhInt() {
		return maTinhInt;
	}

	public void setMaTinhInt(int maTinhInt) {
		this.maTinhInt = maTinhInt;
	}

	public String getTenTinhString() {
		return tenTinhString;
	}

	public void setTenTinhString(String tenTinhString) {
		this.tenTinhString = tenTinhString;
	}

	@Override
	public String toString() {
		return "Province [maTinhInt=" + maTinhInt + ", tenTinhString=" + tenTinhString + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinhInt, tenTinhString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return maTinhInt == other.maTinhInt && Objects.equals(tenTinhString, other.tenTinhString);
	}
	
	public static ArrayList<Province> getDSTinh() {
		String arrTinh[] = {
				"An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Thành phố Hồ Chí Minh",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái",
		};
		
		ArrayList<Province> listTinhArrayList = new ArrayList<Province>();
		int i =0;
		for(String tenTinh : arrTinh) {
			Province tProvince = new Province(i+1, tenTinh);
			listTinhArrayList.add(tProvince);
		}
		return listTinhArrayList;
	}
	
	public static Province getTinhById(int id) {
		return Province.getDSTinh().get(id);
	}
	
	public static Province getTinhByName(String nameProvince) {
		ArrayList<Province> listTinh = Province.getDSTinh();
		for(Province tinh:listTinh) {
			if(tinh.getTenTinhString().equals(nameProvince)) {
				return tinh;
			}
		}
		return null;
	}
}
