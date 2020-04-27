import java.util.Scanner;

public class CreateProducts {
    public void createProducts() throws Exception {
        ProductStorage productStorage = new ProductStorage();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите category:");
        int category = Integer.parseInt(input.nextLine());
        System.out.println("Введите title:");
        String title = input.nextLine();
        System.out.println("Введите actor:");
        String actor = input.nextLine();
        System.out.println("Введите price:");
        int price = Integer.parseInt(input.nextLine());
        System.out.println("Введите special:");
        int special = Integer.parseInt(input.nextLine());
        System.out.println("Введите common_prod_id:");
        int common_prod_id = Integer.parseInt(input.nextLine());
        Products products = new Products();
        products.setCategory(category);
        products.setTittle(title);
        products.setActor(actor);
        products.setPrice(price);
        products.setSpecial(special);
        products.setCommonProdId(common_prod_id);
        productStorage.insert(products);
        System.out.println(productStorage.findByTittle(title));
    }
}
