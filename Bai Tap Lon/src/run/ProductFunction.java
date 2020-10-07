package run;

import bkap.IProduct;
import imp.Categories;
import imp.Product;

import java.util.List;
import java.util.Scanner;

public class ProductFunction {
    public CategoriesFunction categoriesFunction;

    public void inputListPro(Scanner sc, List<Product> productList,List<Categories> categoriesList) {
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
                        for (Product product : productList) {
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
                    for (Product product : productList) {
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

            categoriesFunction.displayListCatId(categoriesList);
            System.out.println("Nhap vao danh muc san pham: ");
            do {
                try {
                    int catId = Integer.parseInt(sc.nextLine());
                    boolean checkCatId = false;
                    Categories cat = new Categories();
                    for (Categories categories : categoriesList) {
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
                    System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
                }

            } while (true);

            pro.inputData();
            productList.add(pro);
        }
    }

    public void calProfitListPro(Scanner sc, List<Product> productList) {
        for (Product product : productList) {
            product.calProfit();
        }
        System.out.println("Da tinh xong loi nhuan cho tat cac san pham.");
    }

    public void UpdateProInfor(Scanner sc, List<Product> productList, List<Categories> categoriesList) {
        System.out.println("Ten san pham can cap nhat thong tin: ");
        String proName = sc.nextLine();
        boolean check = false;
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
                check = true;
                break;
            }
        }
        if (check) {
            for (Product product : productList) {
                if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
                    System.out.println("________________________");
                    product.displayData();
                }
            }

            System.out.println("Nhap ma san pham can cap nhat thong tin: ");
            String proId = sc.nextLine();
            for (Product product : productList) {
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
                                            for (Product product2 : productList) {
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
                                        if (title.length() >= 6 && title.length() <= 30) {
                                            product.setTitle(title);
                                            break;
                                        } else {
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
                                            if (importPrice > 0) {
                                                break;
                                            } else {
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
                                            if (exportPrice < (product.getImportPrice() * (1 + IProduct.INTEREST_RATE))) {
                                                System.err.printf("Gia ban phai lon hon %f gia nhap, vui long nhap lai\n", (1 + IProduct.INTEREST_RATE));
                                            } else {
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
                                        if (descriptions.equals("") || descriptions.length() == 0) {
                                            System.err.println("Mo ta san pham khong duoc de trong, vui long nhap lai");
                                        } else {
                                            product.setDescriptions(descriptions);
                                            break;
                                        }
                                    } while (true);
                                    break;
                                case 6:
                                    categoriesFunction.displayListCatId(categoriesList);
                                    System.out.println("Nhap vao danh muc san pham: ");
                                    do {
                                        try {
                                            int catId = Integer.parseInt(sc.nextLine());
                                            boolean checkCatId = false;
                                            Categories cat = new Categories();
                                            for (Categories categories : categoriesList) {
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

    public void updateProStatus(Scanner sc, List<Product> productList) {
        System.out.println("Ten san pham can cap nhat trang thai: ");
        String proName = sc.nextLine();
        boolean check = false;
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Product product : productList) {
                if (product.getProductName().toLowerCase().startsWith(proName.toLowerCase())) {
                    System.out.println("________________________");
                    product.displayData();
                }
            }
            System.out.println("Nhap ma san pham can cap nhat trang thai: ");
            String proId = sc.nextLine();
            for (Product product : productList) {
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

    public static void sortListProByIncreExportPrice( List<Product> productList) {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                if (productList.get(i).getExportPrice() > productList.get(j).getExportPrice()) {
                    Product pro = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, pro);
                }
            }
        }
        for (Product product : productList) {
            System.out.println("_________________________");
            product.displayData();
        }
    }

    public static void sortListProByDecreProfit(List<Product> productList) {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                if (productList.get(i).getProfit() < productList.get(j).getProfit()) {
                    Product pro = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, pro);
                }
            }
        }
        for (Product product : productList) {
            System.out.println("_________________________");
            product.displayData();
        }
    }
}
