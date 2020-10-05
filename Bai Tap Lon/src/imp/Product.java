package imp;

import java.io.Serializable;
import java.util.Scanner;

import bkap.IProduct;

public class Product implements IProduct, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String descriptions;
	private boolean productStatus;
	private Categories catalog;
	public Product() {
		super();
	}
	
	public Product(String productId, String productName, String title, float importPrice, float exportPrice,
			float profit, String descriptions, boolean productStatus, Categories catalog) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.profit = profit;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}
	public float getExportPrice() {
		return exportPrice;
	}
	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}	
	
	public Categories getCatalog() {
		return catalog;
	}

	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}

	@Override
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao tieu de san pham: ");
		do {
			this.title = sc.nextLine();
			if (title.length()>=6&&title.length()<=30) {
				break;
			}else {
				System.err.println("Tieu de bao gom tu 6-30 ky tu, vui long nhap lai");
			}
		} while (true);
		System.out.println("Nhap vao gia nhap cua san pham: ");
		do {
			try {
				this.importPrice = Float.parseFloat(sc.nextLine());
				if (this.importPrice>0) {
					break;
				}else {
					System.err.println("Gia nhap phai lon hon khong, vui long nhap lai");
				}
			} catch (Exception e) {
				System.err.println("Gia nhap phai la mot so thuc, xin vui long nhap lai");
			}
		} while (true);
		System.out.println("Nhap vao gia ban san pham: ");
		do {
			try {
				this.exportPrice = Float.parseFloat(sc.nextLine());
				if (this.exportPrice<(this.importPrice*(1+INTEREST_RATE))) {
					System.err.printf("Gia ban phai lon hon %f gia nhap, vui long nhap lai\n",(1+INTEREST_RATE));
				}else {
					break;
				}
			} catch (Exception e) {
				System.err.println("Gia ban phai la mot so thuc, vui long nhap lai");
			}
		} while (true);
		
		System.out.println("Nhap vao mo ta san pham: ");
		do {
			this.descriptions = sc.nextLine();
			if (this.descriptions.equals("")||this.descriptions.length()==0) {
				System.err.println("Mo ta san pham khong duoc de trong, vui long nhap lai");
			}else {
				break;
			}
		} while (true);
		System.out.println("Nhap vao trang thai san pham: ");
		do {
			String trangThai = sc.nextLine();
			if (trangThai.equals("true") || trangThai.equals("false")) {
				this.productStatus = Boolean.parseBoolean(trangThai);
				break;
			} else {
				System.err.println("Trang thai san pham la true hoac false, vui long nhap lai");
			}
		} while (true);
		
	}
	@Override
	public void displayData() {
		System.out.printf("Ma San Pham: %s - Ten San Pham: %s - Danh muc: %s\n",this.productId,this.productName, this.catalog.getCatalogName());
		String trangThai;
		if (productStatus) {
			trangThai = "Hoat Dong";
		}else {
			trangThai = "Khong Hoat Dong";
		}
		System.out.printf("Tieu de san pham: %s - Trang thai: %s\n",this.title,trangThai);
		System.out.printf("Gia nhap: %.1f - Gia ban: %.1f - Loi nhuan: %.1f\n",this.importPrice,this.exportPrice,this.profit);
		System.out.printf("Mo ta san pham: %s\n",this.descriptions);
	}


	@Override
	public void calProfit() {
		this.profit = this.exportPrice - this.importPrice;	
	}

}
