package run;

import imp.Categories;
import imp.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesFunction {
    public void inputListCat(Scanner sc, List<Categories> catList) {
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
                        for (Categories categories : catList) {
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
                    System.err.println("Ma danh muc phai la mot so nguyen, vui long nhap lai.");
                }
            } while (true);

            System.out.println("Nhap vao ten danh muc: ");
            do {
                String catName = sc.nextLine();
                if (catName.length() >= 6 && catName.length() <= 30) {
                    boolean checkName = false;
                    for (Categories categories : catList) {
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
                        for (Categories categories : catList) {
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
                    System.err.println("Danh muc cha phai la mot so nguyen, vui long nhap lai.");
                }
            } while (true);
            cat.inputData(sc);
            catList.add(cat);
        }
    }

    public void displayListCat(List<Categories> catList) {
        int stt1 = 1;
        for (Categories categories : catList) {
            if (categories.getParentId() == 0) {
                System.out.printf("%d.%s\n", stt1, categories.getCatalogName());
                int stt2 = 1;
                for (Categories categories2 : catList) {
                    if (categories2.getParentId() == categories.getCatalogId()) {
                        System.out.printf("\t%d.%d.%s\n", stt1, stt2, categories2.getCatalogName());
                        int stt3 = 1;
                        for (Categories categories3 : catList) {
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

    public void displayCatInfo(Scanner sc, List<Categories> catList) {
        System.out.println("Nhap vao ten danh muc can xem thong tin: ");
        String catName = sc.nextLine();
        boolean check = false;
        for (Categories categories : catList) {
            if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Categories categories : catList) {
                if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
                    System.out.println("_____________________________");
                    categories.displayData();
                }
            }
        } else {
            System.err.println("Khong ton tai danh muc ban can xem thong tin.");
        }
    }

    public void deleteCat(Scanner sc, List<Categories> catList, List<Product> proList) {
        System.out.println("Nhap vao danh muc can xoa: ");
        int catId = Integer.parseInt(sc.nextLine());

        boolean checkId = false;
        for (Categories categories : catList) {
            if (categories.getCatalogId() == catId) {
                checkId = true;
                break;
            }
        }
        if (checkId) {
            boolean checkExistPro = false;
            for (Product pro : proList) {
                if (pro.getCatalog().getCatalogId() == catId) {
                    checkExistPro = true;
                    break;
                }
            }
            if (checkExistPro) {
                System.out.println("Danh muc da co san pham, khong the xoa duoc.");
            } else {
                for (int i = 0; i < catList.size(); i++) {
                    if (catList.get(i).getCatalogId() == catId) {
                        catList.remove(i);
                        break;
                    }
                }
                System.out.println("Da xoa danh muc co ma la " + catId);
            }
        } else {
            System.err.println("Danh muc can xoa khong ton tai.");
        }
    }

    public void searchCat(Scanner sc, List<Categories> catList) {
        System.out.println("Nhap ten danh muc can tim kiem: ");
        String catName = sc.nextLine();
        boolean check = false;
        for (Categories categories : catList) {
            if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
                check = true;
                break;
            }
        }

        if (check) {
            for (Categories categories : catList) {
                if (categories.getCatalogName().toLowerCase().startsWith(catName.toLowerCase())) {
                    System.out.println("_____________________________");
                    categories.displayData();
                }
            }
        } else {
            System.err.println("Khong ton tai danh muc ban dang tim kiem.");
        }
    }

    public void displayListCatId(List<Categories> catList) {
        for (Categories categories : catList) {
            System.out.printf("Ten danh muc: %s - Ma danh muc: %d\n", categories.getCatalogName(), categories.getCatalogId());
        }
    }

}
