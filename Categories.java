package imp;

import java.io.Serializable;
import java.util.Scanner;

import bkap.ICategories;

public class Categories implements ICategories,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int catalogId;
	private String catalogName;
	private String descriptions;
	private int parentId;
	private boolean catalogStatus;

	public Categories() {
		super();
	}

	public Categories(int catalogId, String catalogName, String descriptions, int parentId, boolean catalogStatus) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.parentId = parentId;
		this.catalogStatus = catalogStatus;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	@Override
	public void inputData(Scanner sc) {		
		System.out.println("Nhap vao mo ta danh muc: ");
		do {
			this.descriptions = sc.nextLine();
			if (descriptions.equals("") || descriptions.length() == 0) {
				System.err.println("Mo ta danh muc khong the de trong, vui long nhap lai");
			} else {
				break;
			}
		} while (true);

		System.out.println("Nhap vao trang thai danh muc: ");
		do {
			String trangThai = sc.nextLine();
			if (trangThai.equals("true") || trangThai.equals("false")) {
				this.catalogStatus = Boolean.parseBoolean(trangThai);
				break;
			} else {
				System.err.println("Trang thai danh muc la true hoac false, vui long nhap lai");
			}

		} while (true);		
	}

	@Override
	public void displayData() {
		System.out.printf("Ma danh muc: %d - Ten danh muc: %s\n",this.catalogId,this.catalogName);
		System.out.printf("Mo ta: %s\n",this.descriptions);
		String trangThai;
		if (catalogStatus) {
			trangThai = "Hoat Dong";
		}else {
			trangThai = "Khong Hoat Dong";
		}
		System.out.printf("Danh muc cha: %d - Trang thai: %s\n",this.parentId,trangThai);	
	}

}
