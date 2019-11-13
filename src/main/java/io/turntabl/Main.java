package io.turntabl;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
        ProductImpl pro = new ProductImpl();
        try {
//            for (ProdcutTO sales: pro.getProducstByCustomer("Thomas Hardy")){
//                System.out.printf("%10s %30s",sales.getProduct_name(), sales.getPrice());
//                System.out.println();
//            }
            for (ProdcutTO sales: pro.topFiveProducts()){
                System.out.printf("%10s %30s",sales.getProduct_name(), sales.getPrice());
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            System.out.println("Please enter the name of the search candidate: ");
////            String name = scanner.nextLine();
////            DB.searchCustomersByName(name);
//            DB.searchCateByName("Seafood");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Class not found: " + e);
//        }

    }
}
