package run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bkap.IProduct;
import imp.Categories;
import imp.Product;

public class ShopManagement {
//	public static final String fileCatalogName = "E:/Java Web/Project_Eclipse/Bai Tap Lon/Categories.txt";
//	public static final String fileProductName = "E:/Java Web/Project_Eclipse/Bai Tap Lon/Products.txt";
	static List<Categories> listCat = new ArrayList<Categories>();
	static List<Product> listPro = new ArrayList<Product>();

	public static void main(String[] args) {
		// Doc du lieu tu file vao danh sach
//		ShopManagement.readObjectFromFile(fileCatalogName);
//		ShopManagement.readObjectFromFile(fileProductName);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("Categories.txt");
			ois = new ObjectInputStream(fis);
			listCat = (List<Categories>) ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		FileInputStream fis2 = null;
		ObjectInputStream ois2 = null;
		
		try {
			fis2 = new FileInputStream("Product.txt");
			ois2 = new ObjectInputStream(fis2);
			listPro = (List<Product>) ois2.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fis2 != null) {
				try {
					fis2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ois2 != null) {
				try {
					ois2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("**********************MENU************************");
				System.out.println("1. Quan ly danh muc");
				System.out.println("2. Quan ly san pham");
				System.out.println("3. Thoat");
				System.out.println("Su lua chon cua ban: ");

				int choiceMenu = Integer.parseInt(sc.nextLine());
				switch (choiceMenu) {
				case 1:
					ShopManagement.displayManageCatMenu(sc);
					break;
				case 2:
					ShopManagement.displayManageProMenu(sc);
					break;
				case 3:
					ShopManagement.writeObjectToFile(listCat,"Categories.txt");
					ShopManagement.writeObjectToFile(listPro,"Product.txt");
					System.exit(0);
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-3");
					break;
				}
			} catch (Exception e) {
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}

	public static <T> void writeObjectToFile(List<T> obj, String fileName) {
		File file = new File(fileName);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static <T> List<T> readObjectFromFile(String fileName) {
		File file = new File(fileName);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				return (List<T>) ois.readObject();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public static void inputListCat(Scanner sc) {
		System.out.println("Nhap vao so danh muc can them: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Categories cat = new Categories();
			System.out.println("Nhap vao ma danh muc: ");
			do {
				try {
					int catId = Integer.parseInt(sc.nextLine());
					if (catId <= 0) {
						System.out.println("Ma danh muc phai lon hon 0, vui long nhap lai.");
					} else {
						boolean checkId = false;
						for (Categories categories : listCat) {
							if (categories.getCatalogId() == catId) {
								checkId = true;
								break;
							}
						}
						if (checkId) {
							System.err.println("Ma danh muc da ton tai, vui long nhap lai.");
						} else {
							cat.setCatalogId(catId);
							break;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
				}
			} while (true);

			System.out.println("Nhap vao ten danh muc: ");
			do {
				String catName = sc.nextLine();
				if (catName.length() >= 6 && catName.length() <= 30) {
					boolean checkName = false;
					for (Categories categories : listCat) {
						if (categories.getCatalogName().toUpperCase().equals(catName.toUpperCase())) {
							checkName = true;
							break;
						}
					}
					if (checkName) {
						System.err.println("Ten danh muc da ton tai, vui long nhap lai.");
					} else {
						cat.setCatalogName(catName);
						break;
					}
				} else {
					System.err.println("Ten danh muc phai co do dai tu 6-30 ky tu, vui long nhap lai.");
				}
			} while (true);

			System.out.println("Nhap vao danh muc cha: ");
			do {
				try {
					int parentId = Integer.parseInt(sc.nextLine());
					if (parentId < 0) {
						System.err.println(
								" Ma danh muc cha phai la mot so nguyen lon hon hoac bang 0, vui long nhap lai.");
					} else if (parentId == 0) {
						cat.setParentId(parentId);
						break;
					} else {
						boolean checkParentId = false;
						for (Categories categories : listCat) {
							if (categories.getCatalogId() == parentId) {
								checkParentId = true;
								break;
							}
						}
						if (checkParentId) {
							cat.setParentId(parentId);
							break;
						} else {
							System.err.println("Ma danh muc cha khong ton tai, vui long nhap lai. ");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Danh muc cha phai la mot so nguyen, vui long nhap lai.");
				}
			} while (true);
			cat.inputData(sc);
			listCat.add(cat);
		}
	}

	public static void displayListCat() {
		int stt1 = 1;
		for (Categories categories : listCat) {
			if (categories.getParentId() == 0) {
				System.out.printf("%d.%s\n", stt1, categories.getCatalogName());
				int stt2 = 1;
				for (Categories categories2 : listCat) {
					if (categories2.getParentId() == categories.getCatalogId()) {
						System.out.printf("\t%d.%d.%s\n", stt1, stt2, categories2.getCatalogName());
						int stt3 = 1;
						for (Categories categories3 : listCat) {
							if (categories3.getParentId() == categories2.getCatalogId()) {
								System.out.printf("\t\t%d.%d.%d.%s\n", stt1, stt2, stt3, categories3.getCatalogName());
								stt3++;
							}
						}
						stt2++;
					}
				}
				stt1++;
			}
		}
	}

	public static void displayCatInfo(Scanner sc) {
		System.out.println("Nhap vao ten danh muc can xem thong tin: ");
		String catName = sc.nextLine();
		boolean check = false;
		for (Categories categories : listCat) {
			if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
				check = true;
				break;
			}
		}
		
		if (check) {
			for (Categories categories : listCat) {
				if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
					System.out.println("_____________________________");
					categories.displayData();
				}
			}
		} else {
			System.err.println("Khong ton tai danh muc ban can xem thong tin.");
		}
	}

	public static void deleteCat(Scanner sc) {
		System.out.println("Nhap vao danh muc can xoa: ");
		int catId = Integer.parseInt(sc.nextLine());

		boolean checkId = false;
		for (Categories categories : listCat) {
			if (categories.getCatalogId() == catId) {
				checkId = true;
				break;
			}
		}
		if (checkId) {
			boolean checkExistPro = false;
			for (Product pro : listPro) {
				if (pro.getCatalog().getCatalogId() == catId) {
					checkExistPro = true;
					break;
				}
			}
			if (checkExistPro) {
				System.out.println("Danh muc da co san pham, khong the xoa duoc.");
			} else {
				for (int i = 0; i < listCat.size(); i++) {
					if (listCat.get(i).getCatalogId() == catId) {
						listCat.remove(i);
						break;
					}
				}
				System.out.println("Da xoa danh muc co ma la " + catId);
			}
		} else {
			System.err.println("Danh muc can xoa khong ton tai.");
		}
	}

	public static void searchCat(Scanner sc) {
		System.out.println("Nhap ten danh muc can tim kiem: ");
		String catName = sc.nextLine();
		boolean check = false;
		for (Categories categories : listCat) {
			if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
				check = true;
				break;
			}
		}
		
		if (check) {
			for (Categories categories : listCat) {
				if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
					System.out.println("_____________________________");
					categories.displayData();
				}
			}
		} else {
			System.err.println("Khong ton tai danh muc ban dang tim kiem.");
		}
	}

	public static void displayManageCatMenu(Scanner sc) {
		boolean checkExitCat = false;
		do {
			try {
				System.out.println("****************QUAN LY DANH MUC*****************");
				System.out.println("1. Danh sach danh muc");
				System.out.println("2. Them danh muc");
				System.out.println("3. Xoa danh muc");
				System.out.println("4. Tim kiem danh muc");
				System.out.println("5. Quay lai");
				System.out.println("Su lua chon cua ban: ");

				int choiceCat = Integer.parseInt(sc.nextLine());

				switch (choiceCat) {
				case 1:
					ShopManagement.displayListCatMenu(sc);
					break;
				case 2:
					ShopManagement.inputListCat(sc);
					break;
				case 3:
					ShopManagement.deleteCat(sc);
					break;
				case 4:
					ShopManagement.searchCat(sc);
					break;
				case 5:
					checkExitCat = true;
					break;
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-5");
					break;
				}
				if (checkExitCat) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}

	public static void displayListCatMenu(Scanner sc) {
		do {
			try {
				System.out.println("******************DANH SACH DANH MUC*****************");
				System.out.println("1. Danh sach cay danh muc");
				System.out.println("2. Thong tin chi tiet danh muc");
				System.out.println("3. Quay lai");
				System.out.println("Su lua chon cua ban: ");

				int choiceCatInfo = Integer.parseInt(sc.nextLine());
				boolean checkExitCatInfo = false;
				switch (choiceCatInfo) {
				case 1:
					ShopManagement.displayListCat();
					break;
				case 2:
					ShopManagement.displayCatInfo(sc);
					break;
				case 3:
					checkExitCatInfo = true;
					break;
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-3");
					break;
				}
				if (checkExitCatInfo) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}

	public static void displayManageProMenu(Scanner sc) {
		do {
			try {
				System.out.println("*******************QUAN LY SAN PHAM******************");
				System.out.println("1. Them san pham moi");
				System.out.println("2. Tinh loi nhuan san pham");
				System.out.println("3. Hien thi thong tin san pham");
				System.out.println("4. Sap xep san pham");
				System.out.println("5. Cap nhat thong tin san pham");
				System.out.println("6. Cap nhat trang thai san pham");
				System.out.println("7. Quay lai");
				System.out.println("Su lua chon cua ban: ");

				int choicePro = Integer.parseInt(sc.nextLine());
				boolean checkExitPro = false;
				switch (choicePro) {
				case 1:
					ShopManagement.inputListPro(sc);
					break;
				case 2:
					ShopManagement.calProfitListPro(sc);
					break;
				case 3:
					ShopManagement.displayProInfoMenu(sc);
					break;
				case 4:
					ShopManagement.displaySortProMenu(sc);
					break;
				case 5:
					ShopManagement.UpdateProInfor(sc);
					break;
				case 6:
					ShopManagement.updateProStatus(sc);
					break;
				case 7:
					checkExitPro = true;
					break;
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-7");
					break;
				}
				if (checkExitPro) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}

	public static void displayProInfoMenu(Scanner sc) {
		do {
			try {
				System.out.println("*******************THONG TIN SAN PHAM*******************");
				System.out.println("1. Hien thi san pham theo danh muc");
				System.out.println("2. Hien thi chi tiet san pham");
				System.out.println("3. Quay lai");
				System.out.println("Su lua chon cua ban: ");

				int choiceProInfo = Integer.parseInt(sc.nextLine());
				boolean checkExitProInfo = false;
				switch (choiceProInfo) {
				case 1:
					ShopManagement.displayProInforByCat(sc);
					break;
				case 2:
					ShopManagement.displayProInfor(sc);
					break;
				case 3:
					checkExitProInfo = true;
					break;
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-3");
					break;
				}
				if (checkExitProInfo) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}

	public static void displaySortProMenu(Scanner sc) {
		do {
			try {
				System.out.println("************************SAP XEP SAN PHAM***********************");
				System.out.println("1. Sap xep san pham theo gia xuat tang dan");
				System.out.println("2. Sap xep san pham theo loi nhuan giam dan");
				System.out.println("3. Quay lai");
				System.out.println("Su lua chon cua ban: ");

				int choiceSortPro = Integer.parseInt(sc.nextLine());
				boolean checkExitSortPro = false;
				switch (choiceSortPro) {
				case 1:
					ShopManagement.sortListProByIncreExportPrice();
					break;
				case 2:
					ShopManagement.sortListProByDecreProfit();
					break;
				case 3:
					checkExitSortPro = true;
					break;
				default:
					System.err.println("Vui long nhap cac lua chon tu 1-3.");
					break;
				}
				if (checkExitSortPro) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Vui long nhap cac lua chon la so nguyen.");
			}
		} while (true);
	}
	
	public static void inputListPro(Scanner sc) {
		System.out.println("Nhap vao so san pham can them moi: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Product pro = new Product();

			System.out.println("Nhap vao ma san pham: ");
			do {
				String proId = sc.nextLine();
				if (proId.length() == 4) {
					if (proId.startsWith("C")) {
						boolean checkProId = false;
						for (Product product : listPro) {
							if (product.getProductId().equals(proId)) {
								checkProId = true;
								break;
							}
						}
						if (checkProId) {
							System.err.println("Ma san pham da ton tai, vui long nhap lai.");
						} else {
							pro.setProductId(proId);
							break;
						}
					} else {
						System.err.println("Ma san pham phai bat dau bang ky tu C, vui long nhap lai.");
					}
				} else {
					System.err.println("Ma san pham phai gom 4 ky tu, vui long nhap lai.");
				}
			} while (true);

			System.out.println("Nhap vao ten san pham: ");
			do {
				String proName = sc.nextLine();
				if (proName.length() >= 6 && proName.length() <= 50) {
					boolean checkProName = false;
					for (Product product : listPro) {
						if (product.getProductName().toLowerCase().equals(proName.toLowerCase())) {
							checkProName = true;
							break;
						}
					}
					if (checkProName) {
						System.err.println("Ten san pham da ton tai, vui long nhap lai.");
					} else {
						pro.setProductName(proName);
						break;
					}
				} else {
					System.err.println("Ten san pham co do dai tu 6-50 ky tu, vui long nhap lai.");
				}
			} while (true);
			
			ShopManagement.displayListCatId();
			System.out.println("Nhap vao danh muc san pham: ");
			do {
				try {
					int catId = Integer.parseInt(sc.nextLine());
					boolean checkCatId = false;
					Categories cat = new Categories();
					for (Categories categories : listCat) {
						if (categories.getCatalogId() == catId) {
							checkCatId = true;
							cat = categories;
							break;
						}
					}
					if (checkCatId) {
						pro.setCatalog(cat);
						break;
					} else {
						System.err.println("Ma danh muc khong ton tai, vui long nhap lai.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
				}
				
			} while (true);

			pro.inputData();
			listPro.add(pro);
		}
	}
	
	public static void displayListCatId() {
		for (Categories categories : listCat) {
			System.out.printf("Ten danh muc: %s - Ma danh muc: %d\n",categories.getCatalogName(),categories.getCatalogId());
		}
	}
	
	public static void calProfitListPro(Scanner sc) {
		for (Product product : listPro) {
			product.calProfit();
		}
		System.out.println("Da tinh xong loi nhuan cho tat cac san pham.");
	}
	
	public static void displayProInfor(Scanner sc) {
		System.out.println("Nhap ten san pham can xem thong tin: ");
		String pro = sc.nextLine();
		boolean check = false;
		for (Product product : listPro) {
			if (product.getProductName().toLowerCase().startsWith(pro.toLowerCase())) {
				check = true;
				break;
			}
		}
		
		if (check) {
			for (Product product : listPro) {
				if (product.getProductName().toLowerCase().startsWith(pro.toLowerCase())) {
					System.out.println("_____________________________");
					product.displayData();
				}
			}
		} else {
			System.err.println("Khong ton tai san pham can xem thong tin.");
		}
	}

	public static void displayProInforByCat(Scanner sc) {
		ShopManagement.displayListCatId();
		System.out.println("Nhap danh muc can xem san pham: ");
		int catId = Integer.parseInt(sc.nextLine());
		boolean check = false;
		for (Product product : listPro) {
			if (product.getCatalog().getCatalogId() == catId) {
				check = true;
				break;
			}
		}
		
		if (check) {
			for (Product product : listPro) {
				if (product.getCatalog().getCatalogId() == catId) {
					System.out.println("________________________");
					product.displayData();
				}
			}
		} else {
			System.err.println("Khong ton tai danh muc can xem san pham.");
		}
	}

	public static void UpdateProInfor(Scanner sc) {
		System.out.println("Ten san pham can cap nhat thong tin: ");
		String proName = sc.nextLine();
		boolean check = false;
		for (Product product : listPro) {
			if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
				check = true;
				break;
			}
		}
		if (check) {
			for (Product product : listPro) {
				if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
					System.out.println("________________________");
					product.displayData();
				}
			}
			
			System.out.println("Nhap ma san pham can cap nhat thong tin: ");
			String proId = sc.nextLine();
			for (Product product : listPro) {
				if (product.getProductId().equals(proId)) {
					do {
						try {
							System.out.println("*************CAP NHAT THONG TIN SAN PHAM*************");
							System.out.println("1. Ten            2. Tieu de");
							System.out.println("3. Gia nhap       4. Gia xuat");
							System.out.println("5. Mo ta          6. Danh muc");
							System.out.println("7. Thoat");
							System.out.println("Su lua chon cua ban: ");
							
							int choice = Integer.parseInt(sc.nextLine());
							boolean checkExitUpdate = false;
							switch (choice) {
							case 1: 
								System.out.println("Nhap vao ten san pham: ");
								do {
									String proNameUpdate = sc.nextLine();
									if (proNameUpdate.length() >= 6 && proNameUpdate.length() <= 50) {
										boolean checkProName = false;
										for (Product product2 : listPro) {
											if (product2.getProductName().toLowerCase().equals(proNameUpdate.toLowerCase())) {
												checkProName = true;
												break;
											}
										}
										if (checkProName) {
											System.err.println("Ten san pham da ton tai, vui long nhap lai.");
										} else {
											product.setProductName(proName);
											break;
										}
									} else {
										System.err.println("Ten san pham co do dai tu 6-50 ky tu, vui long nhap lai.");
									}
								} while (true);
								break;
							case 2:
								System.out.println("Nhap vao tieu de san pham: ");
								do {
									String title = sc.nextLine();
									if (title.length()>=6&&title.length()<=30) {
										product.setTitle(title);
										break;
									}else {
										product.setTitle(title);
										System.err.println("Tieu de bao gom tu 6-30 ky tu, vui long nhap lai");
									}
								} while (true);
								break;
							case 3: 
								System.out.println("Nhap vao gia nhap cua san pham: ");
								do {
									try {
										float importPrice = Float.parseFloat(sc.nextLine());
										if (importPrice>0) {
											break;
										}else {
											product.setImportPrice(importPrice);
											System.err.println("Gia nhap phai lon hon khong, vui long nhap lai");
										}
									} catch (Exception e) {
										System.err.println("Gia nhap phai la mot so thuc, xin vui long nhap lai");
									}
								} while (true);
								break;
							case 4: 
								System.out.println("Nhap vao gia ban san pham: ");
								do {
									try {
										float exportPrice = Float.parseFloat(sc.nextLine());
										if (exportPrice<(product.getImportPrice()*(1+IProduct.INTEREST_RATE))) {
											System.err.printf("Gia ban phai lon hon %f gia nhap, vui long nhap lai\n",(1+IProduct.INTEREST_RATE));
										}else {
											product.setExportPrice(exportPrice);
											break;
										}
									} catch (Exception e) {
										System.err.println("Gia ban phai la mot so thuc, vui long nhap lai");
									}
								} while (true);
								break;
							case 5: 
								System.out.println("Nhap vao mo ta san pham: ");
								do {
									String descriptions = sc.nextLine();
									if (descriptions.equals("")||descriptions.length()==0) {
										System.err.println("Mo ta san pham khong duoc de trong, vui long nhap lai");
									}else {
										product.setDescriptions(descriptions);
										break;
									}
								} while (true);
								break;
							case 6: 
								ShopManagement.displayListCatId();
								System.out.println("Nhap vao danh muc san pham: ");
								do {
									try {
										int catId = Integer.parseInt(sc.nextLine());
										boolean checkCatId = false;
										Categories cat = new Categories();
										for (Categories categories : listCat) {
											if (categories.getCatalogId() == catId) {
												checkCatId = true;
												cat = categories;
												break;
											}
										}
										if (checkCatId) {
											product.setCatalog(cat);
											break;
										} else {
											System.err.println("Ma danh muc khong ton tai, vui long nhap lai.");
										}
									} catch (Exception e) {
										// TODO: handle exception
										System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
									}
									
								} while (true);
								break;
							case 7:
								checkExitUpdate = true;
								break;
							default:
								System.err.println("Vui long nhap cac lua chon tu 1-7");
								break;
							}
							if (checkExitUpdate) {
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.err.println("Vui long nhap cac lua chon la so nguyen.");
						}
					} while (true);
					break;
				}
			}
		} else {
			System.err.println("Khong ton tai san pham can cap nhat thong tin.");
		}
	}
	
	public static void updateProStatus(Scanner sc) {
		System.out.println("Ten san pham can cap nhat trang thai: ");
		String proName = sc.nextLine();
		boolean check = false;
		for (Product product : listPro) {
			if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
				check = true;
				break;
			}
		}
		
		if (check) {
			for (Product product : listPro) {
				if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
					System.out.println("________________________");
					product.displayData();
				}
			}
			System.out.println("Nhap ma san pham can cap nhat trang thai: ");
			String proId = sc.nextLine();
			for (Product product : listPro) {
				if (product.getProductId().equals(proId)) {
					System.out.println("Nhap vao trang thai san pham: ");
					do {
						String trangThai = sc.nextLine();
						if (trangThai.equals("true") || trangThai.equals("false")) {
							boolean status = Boolean.parseBoolean(trangThai);
							product.setProductStatus(status);
							break;
						} else {
							System.err.println("Trang thai san pham la true hoac false, vui long nhap lai");
						}
					} while (true);
				}
			}
		} else {
			System.err.println("Khong ton tai san pham can cap nhat trang thai.");
		}
	}
	
	public static void sortListProByIncreExportPrice() {
		for (int i = 0; i < listPro.size()-1; i++) {
			for (int j = i+1; j < listPro.size(); j++) {
				if (listPro.get(i).getExportPrice() > listPro.get(j).getExportPrice()) {
					Product pro = listPro.get(i);
					listPro.set(i, listPro.get(j));
					listPro.set(j, pro);
				}
			}
		}
		for (Product product : listPro) {
			System.out.println("_________________________");
			product.displayData();
		}
	}
	
	public static void sortListProByDecreProfit() {
		for (int i = 0; i < listPro.size()-1; i++) {
			for (int j = i+1; j < listPro.size(); j++) {
				if (listPro.get(i).getProfit() < listPro.get(j).getProfit() ) {
					Product pro = listPro.get(i);
					listPro.set(i, listPro.get(j));
					listPro.set(j, pro);
				}
			}
		}
		for (Product product : listPro) {
			System.out.println("_________________________");
			product.displayData();
		}
	}
}
