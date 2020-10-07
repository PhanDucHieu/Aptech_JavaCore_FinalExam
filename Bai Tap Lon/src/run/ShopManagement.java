package run;

import imp.Categories;
import imp.Product;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {

    private CategoriesFunction categoriesFunction = new CategoriesFunction();

    private ProductFunction productFunction = new ProductFunction();

    private static final String CATEGORIES_FILE = "Categories.txt";
    private static final String PRODUCT_FILE = "Product.txt";


    private static void writeObject(Object object, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> List<T> readFile(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ShopManagement shopManagement = new ShopManagement();
        List<Categories> categoriesTemp = readFile(CATEGORIES_FILE);
        List<Product> productTemp = readFile(PRODUCT_FILE);
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
                        shopManagement.displayManageCatMenu(sc, categoriesTemp, productTemp);
                        break;
                    case 2:
                        shopManagement.displayManageProMenu(sc, productTemp, categoriesTemp);
                        break;
                    case 3:
                        ShopManagement.writeObject(categoriesTemp, CATEGORIES_FILE);
                        ShopManagement.writeObject(productTemp, PRODUCT_FILE);
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

//    public static void inputListCat(Scanner sc, List<Categories> catList) {
//        System.out.println("Nhap vao so danh muc can them: ");
//        int n = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < n; i++) {
//            Categories cat = new Categories();
//            System.out.println("Nhap vao ma danh muc: ");
//            do {
//                try {
//                    int catId = Integer.parseInt(sc.nextLine());
//                    if (catId <= 0) {
//                        System.out.println("Ma danh muc phai lon hon 0, vui long nhap lai.");
//                    } else {
//                        boolean checkId = false;
//                        for (Categories categories : catList) {
//                            if (categories.getCatalogId() == catId) {
//                                checkId = true;
//                                break;
//                            }
//                        }
//                        if (checkId) {
//                            System.err.println("Ma danh muc da ton tai, vui long nhap lai.");
//                        } else {
//                            cat.setCatalogId(catId);
//                            break;
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
//                }
//            } while (true);
//
//            System.out.println("Nhap vao ten danh muc: ");
//            do {
//                String catName = sc.nextLine();
//                if (catName.length() >= 6 && catName.length() <= 30) {
//                    boolean checkName = false;
//                    for (Categories categories : catList) {
//                        if (categories.getCatalogName().toUpperCase().equals(catName.toUpperCase())) {
//                            checkName = true;
//                            break;
//                        }
//                    }
//                    if (checkName) {
//                        System.err.println("Ten danh muc da ton tai, vui long nhap lai.");
//                    } else {
//                        cat.setCatalogName(catName);
//                        break;
//                    }
//                } else {
//                    System.err.println("Ten danh muc phai co do dai tu 6-30 ky tu, vui long nhap lai.");
//                }
//            } while (true);
//
//            System.out.println("Nhap vao danh muc cha: ");
//            do {
//                try {
//                    int parentId = Integer.parseInt(sc.nextLine());
//                    if (parentId < 0) {
//                        System.err.println(
//                                " Ma danh muc cha phai la mot so nguyen lon hon hoac bang 0, vui long nhap lai.");
//                    } else if (parentId == 0) {
//                        cat.setParentId(parentId);
//                        break;
//                    } else {
//                        boolean checkParentId = false;
//                        for (Categories categories : catList) {
//                            if (categories.getCatalogId() == parentId) {
//                                checkParentId = true;
//                                break;
//                            }
//                        }
//                        if (checkParentId) {
//                            cat.setParentId(parentId);
//                            break;
//                        } else {
//                            System.err.println("Ma danh muc cha khong ton tai, vui long nhap lai. ");
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println("Danh muc cha phai la mot so nguyen, vui long nhap lai.");
//                }
//            } while (true);
//            cat.inputData(sc);
//            catList.add(cat);
//        }
//    }

//    public static void displayListCat() {
//        int stt1 = 1;
//        for (Categories categories : catList) {
//            if (categories.getParentId() == 0) {
//                System.out.printf("%d.%s\n", stt1, categories.getCatalogName());
//                int stt2 = 1;
//                for (Categories categories2 : listCat) {
//                    if (categories2.getParentId() == categories.getCatalogId()) {
//                        System.out.printf("\t%d.%d.%s\n", stt1, stt2, categories2.getCatalogName());
//                        int stt3 = 1;
//                        for (Categories categories3 : listCat) {
//                            if (categories3.getParentId() == categories2.getCatalogId()) {
//                                System.out.printf("\t\t%d.%d.%d.%s\n", stt1, stt2, stt3, categories3.getCatalogName());
//                                stt3++;
//                            }
//                        }
//                        stt2++;
//                    }
//                }
//                stt1++;
//            }
//        }
//    }

//    public static void displayCatInfo(Scanner sc) {
//        System.out.println("Nhap vao ten danh muc can xem thong tin: ");
//        String catName = sc.nextLine();
//        boolean check = false;
//        for (Categories categories : listCat) {
//            if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
//                check = true;
//                break;
//            }
//        }
//
//        if (check) {
//            for (Categories categories : listCat) {
//                if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
//                    System.out.println("_____________________________");
//                    categories.displayData();
//                }
//            }
//        } else {
//            System.err.println("Khong ton tai danh muc ban can xem thong tin.");
//        }
//    }
//
//    public static void deleteCat(Scanner sc) {
//        System.out.println("Nhap vao danh muc can xoa: ");
//        int catId = Integer.parseInt(sc.nextLine());
//
//        boolean checkId = false;
//        for (Categories categories : listCat) {
//            if (categories.getCatalogId() == catId) {
//                checkId = true;
//                break;
//            }
//        }
//        if (checkId) {
//            boolean checkExistPro = false;
//            for (Product pro : listPro) {
//                if (pro.getCatalog().getCatalogId() == catId) {
//                    checkExistPro = true;
//                    break;
//                }
//            }
//            if (checkExistPro) {
//                System.out.println("Danh muc da co san pham, khong the xoa duoc.");
//            } else {
//                for (int i = 0; i < listCat.size(); i++) {
//                    if (listCat.get(i).getCatalogId() == catId) {
//                        listCat.remove(i);
//                        break;
//                    }
//                }
//                System.out.println("Da xoa danh muc co ma la " + catId);
//            }
//        } else {
//            System.err.println("Danh muc can xoa khong ton tai.");
//        }
//    }

    private void displayManageCatMenu(Scanner sc, List<Categories> categoriesList, List<Product> productList) {
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
                        displayListCatMenu(sc, categoriesList);
                        break;
                    case 2:
                        categoriesFunction.inputListCat(sc, categoriesList);
                        break;
                    case 3:
                        categoriesFunction.deleteCat(sc, categoriesList, productList);
                        break;
                    case 4:
                        categoriesFunction.searchCat(sc, categoriesList);
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
                System.err.println("Vui long nhap cac lua chon la so nguyen.");
            }
        } while (true);
    }

    private void displayListCatMenu(Scanner sc, List<Categories> categoriesList) {
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
                        categoriesFunction.displayListCat(categoriesList);
                        break;
                    case 2:
                        categoriesFunction.displayCatInfo(sc, categoriesList);
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
                System.err.println(e);
                System.err.println("Vui long nhap cac lua chon la so nguyen.");
            }
        } while (true);
    }

    private void displayManageProMenu(Scanner sc, List<Product> productList, List<Categories> categoriesList) {
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
                        productFunction.inputListPro(sc, productList, categoriesList);
                        break;
                    case 2:
                        productFunction.calProfitListPro(sc, productList);
                        break;
                    case 3:
                        displayProInfoMenu(sc, productList, categoriesList);
                        break;
                    case 4:
                        displaySortProMenu(sc, productList);
                        break;
                    case 5:
                        productFunction.UpdateProInfor(sc, productList, categoriesList);
                        break;
                    case 6:
                        productFunction.updateProStatus(sc, productList);
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
                System.err.println("Vui long nhap cac lua chon la so nguyen.");
            }
        } while (true);
    }

    private void displayProInfoMenu(Scanner sc, List<Product> productList, List<Categories> categoriesList) {
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
                        displayProInforByCat(sc, productList, categoriesList);
                        break;
                    case 2:
                        displayProInfor(sc, productList);
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
                System.err.println("Vui long nhap cac lua chon la so nguyen.");
            }
        } while (true);
    }

    private void displaySortProMenu(Scanner sc, List<Product> productList) {
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
                        ProductFunction.sortListProByIncreExportPrice(productList);
                        break;
                    case 2:
                        ProductFunction.sortListProByDecreProfit(productList);
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
                System.err.println("Vui long nhap cac lua chon la so nguyen.");
            }
        } while (true);
    }

    private void displayProInfor(Scanner sc, List<Product> productList) {
        System.out.println("Nhap ten san pham can xem thong tin: ");
        String pro = sc.nextLine();
        boolean check = false;
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().startsWith(pro.toLowerCase())) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Product product : productList) {
                if (product.getProductName().toLowerCase().startsWith(pro.toLowerCase())) {
                    System.out.println("_____________________________");
                    product.displayData();
                }
            }
        } else {
            System.err.println("Khong ton tai san pham can xem thong tin.");
        }
    }

    private void displayProInforByCat(Scanner sc, List<Product> productList, List<Categories> categoriesList) {
        categoriesFunction.displayListCatId(categoriesList);
        System.out.println("Nhap danh muc can xem san pham: ");
        int catId = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for (Product product : productList) {
            if (product.getCatalog().getCatalogId() == catId) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Product product : productList) {
                if (product.getCatalog().getCatalogId() == catId) {
                    System.out.println("________________________");
                    product.displayData();
                }
            }
        } else {
            System.err.println("Khong ton tai danh muc can xem san pham.");
        }
    }


}
